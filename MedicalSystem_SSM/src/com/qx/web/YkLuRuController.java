package com.qx.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qx.po.Company;
import com.qx.po.Drug;
import com.qx.po.Stock;
import com.qx.po.Stockdetail;
import com.qx.po.Users;
import com.qx.service.StockService;
import com.qx.service.UserService;
import com.qx.util.Tools;
import com.qx.vo.Bsgrid;
import com.qx.vo.JsonReturn;

@Controller
@RequestMapping("/YkLuRuController")
public class YkLuRuController {
	
	//用户信息  
	@Autowired
	private UserService userService;
	
	@Autowired
	private StockService stockService;	
	
	/*
	 *界面跳转 
	 */
	@RequestMapping("/QingGouDan")
	public String QingGouDan(HttpServletRequest request){				
			
		//采购人员
    	List<Users> UsersList = userService.findByDoctor(3,4,5);
    	request.setAttribute("UsersList", UsersList);
		
		//查询供应商   	
		List<Company> CompanyList = stockService.findCompanyId();
		request.setAttribute("CompanyList", CompanyList);
		
		return "/YaoKu/QingGouDan";
		
	}
	
	/*
     * 药品请购单录入 
     */
    @ResponseBody
	@RequestMapping(value="/AllStockdetail",produces="application/json")
	public Object AllStockdetail(HttpServletRequest request){
		
		JsonReturn jsonReturn =new JsonReturn();		
		
		//获取页面传过来的值
		String stockcode = request.getParameter("stockcode"); 
		String companyId = request.getParameter("companyId"); 
		String applytime = request.getParameter("applytime");
		String arrivaltime =request.getParameter("arrivaltime");
		String drugspecies =request.getParameter("drugspecies");
		String userId =request.getParameter("userId");
		String stocktime =request.getParameter("stocktime");
		
		//数据类型转换
		int strcompanyId=Integer.parseInt(companyId);
		int struserId=Integer.parseInt(userId);
		Date strapplytime = null; 
		Date strarrivaltime = null;
		Date strstocktime = null;		
		try {
			strapplytime = new SimpleDateFormat("yyyy-MM-dd").parse(applytime);
			strarrivaltime = new SimpleDateFormat("yyyy-MM-dd").parse(arrivaltime);
			strstocktime = new SimpleDateFormat("yyyy-MM-dd").parse(stocktime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//先新增进货表信息 ，返回进货ID给明细表使用
		Stock strStock = new Stock();
		strStock.setStockcode(stockcode);
		strStock.setCompanyId(strcompanyId);
		strStock.setApplytime(strapplytime);
		strStock.setArrivaltime(strarrivaltime);
		strStock.setDrugspecies(drugspecies);
		strStock.setUserId(struserId);
		strStock.setStocktime(strstocktime);		
		boolean bol= stockService.InsertStock(strStock);
		
		//获取页面数组信息
		String strShuZu = request.getParameter("suzu");
		
		//初始化切割值
		String  drugIdA="";
		String stocknumA="";
		
		//先以,切割数组行数
		String[] dh=strShuZu.split(",");
		
		//再进行循环遍历出对应的明细条数
		for (int i = 0; i < dh.length; i++) {
			//获取一条数据进行切割
			String sttt = dh[i];
			String[] ttr = sttt.split("SS");
			//将切割完的信息进行排序
			drugIdA = ttr[0];
			stocknumA = ttr[1];
			
			//转换数据类型
			int strDrugId = Integer.parseInt(drugIdA);

			if (bol) {
				//获取明细信息
				Stockdetail strDetail = new Stockdetail();
				strDetail.setStockId(strStock.getStockId());
				strDetail.setDrugId(strDrugId);
				strDetail.setStocknum(stocknumA);				
				//保存明细信息
				boolean bols = stockService.InsertStockdetail(strDetail);
				if (bols) {
					jsonReturn.setState(true);
					jsonReturn.setMsg("请购单录入成功");
				} else {
					jsonReturn.setState(false);
					jsonReturn.setMsg("基本信息不能为空，录入失败");
				}
			}

		}
		
		return JSONSerializer.toJSON(jsonReturn);
    }
	
	 /*
     * 查询药品信息
     */
    @ResponseBody
    @RequestMapping(value="/YaoPinXinXi",produces="application/json;charset=UTF-8")
    public String YaoPinXinXi(HttpServletRequest request){
    	    	    	
    	String strpageSize = request.getParameter("pageSize");
		String strcurPage = request.getParameter("curPage");
				
		//分页
		Bsgrid<Drug> bsgrid = new Bsgrid<Drug>();
		
		if (Tools.isNum(strpageSize) && Tools.isNum(strcurPage)) {
			
			int pageSize = Integer.parseInt(strpageSize);
			int curPage = Integer.parseInt(strcurPage);

			int startIndex = (curPage - 1) * pageSize;
			
			List<Drug> list = stockService.findDrugId("1=1", startIndex, pageSize);
			int totalRows = stockService.getDrugIdRow("1=1");			

			bsgrid.setCurPage(curPage);
			bsgrid.setTotalRows(totalRows);
			bsgrid.setSuccess(true);
			bsgrid.setData(list);
			
		} else {
			bsgrid.setSuccess(false);
		}		
		return JSONSerializer.toJSON(bsgrid).toString();   	
    }
	
    /*
     * 查询药品表回填药品信息
     */
    @ResponseBody
    @RequestMapping(value="/HuiTianXinXi",produces="application/json;charset=UTF-8")
    public String HuiTianXinXi(Drug drug ,HttpServletRequest request){
    	
    	JsonReturn jsonReturn=new JsonReturn();
    	   	
    	String strdrugId =request.getParameter("drugID");
    	int drugId = Integer.parseInt(strdrugId);	 
    	
    	Drug StrList=null;
    	
    	if(drugId >0){       		
    		 StrList=stockService.getHuiTianDrug(drugId);    				
    	}
    	else {
    		StrList=null;
    		jsonReturn.setState(false);
			jsonReturn.setMsg("获取数据失败");
		}   
    	
    	return JSONSerializer.toJSON(StrList).toString();
    }
	
	/*
	 * 药库-请购单编码
	 */
    @ResponseBody
	@RequestMapping(value="/getStockcode",produces="application/json")	
	public Object getStockcode(Stock stock,HttpServletRequest request) {    	    	
    	JsonReturn jsonReturn=new JsonReturn();   
		List<Stock> list=stockService.findStockcode(stock.getStockcode());//查询数据库表最新新增或是否有新增该字段		
		String max_code = ""; //定义装获取数据的信息
		String comment_code = ""; //定义装拼接好的信息						
		if (list.size() > 0) {
			max_code = (String) list.get(0).getStockcode();
		} 
		//时间字符串产生方式  MMddHHmm
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		// 组合流水号前一部分，时间字符串，如：2018
		String uid_pfix = format.format(new Date());
		// 判断数据库是否有数据
		if (max_code != null && max_code.contains(uid_pfix)) {
			// 从20180001截取字符串最后四位，结果:0001
			String uid_end = max_code.substring(8, 12);
			// 把String类型的0001转化为int类型的1
			int endNum = Integer.parseInt(uid_end);			
			int tmpNum = 10000 + endNum + 1;// 结果10002
			// 把10002首位的1去掉，再拼成GH201812110002字符串
			comment_code = uid_pfix + YkLuRuController.subStr("" + tmpNum, 1);
		} else {
			// 当数据库没有数据时，输出GH201812110001
			comment_code = uid_pfix + "0001";
		}
		jsonReturn.setMsg(comment_code);
		return JSONSerializer.toJSON(jsonReturn);		
	}

	/*
	 * 请购单编码-把10002首位的1去掉的实现方法
	 */
	public static String subStr(String str, int start) {

		if (str == null || str.equals("") || str.length() == 0)
			return "";
		if (start < str.length()) {
			return str.substring(start);
		} else {
			return "";
		}

	}
	
	
	
}
