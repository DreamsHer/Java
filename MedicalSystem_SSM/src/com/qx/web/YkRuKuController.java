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

import com.qx.po.Enterstock;
import com.qx.po.Enterstockdetail;
import com.qx.po.Stockdetail;
import com.qx.po.Users;
import com.qx.service.EnterstockService;
import com.qx.service.StockService;
import com.qx.service.UserService;
import com.qx.util.Tools;
import com.qx.vo.Bsgrid;
import com.qx.vo.JsonReturn;

@Controller
@RequestMapping("/YkRuKuController")
public class YkRuKuController {
	
	//用户表
	@Autowired
	private UserService userService;
	//进货表
	@Autowired
	private StockService stockService;		
	//进库表
	@Autowired
	private EnterstockService enterstockService;	
	
	//入库审核
	@RequestMapping("/RuKuShenHe")
	public String RuKuShenHe(HttpServletRequest request){
				
		//查询登记人
		List<Users> UsersList = userService.findByDoctor(3,4,5);
    	request.setAttribute("UsersList", UsersList);
		
    	//JSP页面
		return "/YaoKu/RuKuShenHe";
	}
	
	/*
     * 查询请购单入库信息
     */
    @ResponseBody
    @RequestMapping(value="/QingGouRuKu",produces="application/json;charset=UTF-8")
    public String QingGouRuKu(HttpServletRequest request){
    	    	    	
    	String strpageSize = request.getParameter("pageSize");
		String strcurPage = request.getParameter("curPage");
				
		//分页
		Bsgrid<Stockdetail> bsgrid = new Bsgrid<Stockdetail>();
		
		if (Tools.isNum(strpageSize) && Tools.isNum(strcurPage)) {
			
			int pageSize = Integer.parseInt(strpageSize);
			int curPage = Integer.parseInt(strcurPage);

			int startIndex = (curPage - 1) * pageSize;
			
			List<Stockdetail> list = stockService.getYaoPinRuKu("1=1", startIndex, pageSize);
			int totalRows = stockService.getYaoPinRuKuRow("1=1");			

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
     * 查询请购单入库信息回填
     */
    @ResponseBody
    @RequestMapping(value="/HuiTianXinXi",produces="application/json;charset=UTF-8")
    public String HuiTianXinXi(Stockdetail stockdetail,HttpServletRequest request){
    	
    	JsonReturn jsonReturn=new JsonReturn();
    	   	
    	String strStockdetailId =request.getParameter("StockdetailId");
    	int stockdetailId = Integer.parseInt(strStockdetailId);	 
    	
    	Stockdetail StrList=null;
    	
    	if(stockdetailId >0){    		
    		 StrList=stockService.getHuiTianStock(stockdetailId);    				
    	}
    	else {
    		StrList=null;
    		jsonReturn.setState(false);
			jsonReturn.setMsg("获取数据失败");
		}   
    	
    	return JSONSerializer.toJSON(StrList).toString();
    }
	

    /*
	 * 药库-进库单号
	 */
    @ResponseBody
	@RequestMapping(value="/getEnterstockcode",produces="application/json")	
	public Object getEnterstockcode(Enterstock enterstock,HttpServletRequest request) {
    	    	
    	JsonReturn jsonReturn=new JsonReturn();
    	
    	//查询数据库表字段
		List<Enterstock> list=enterstockService.FindEnterStockCode(enterstock.getEnterstockcode());
		
		String max_code = ""; //定义装获取数据的信息
		String comment_code = ""; //定义装拼接好的信息						
		if (list.size() > 0) {
			max_code = (String) list.get(0).getEnterstockcode();
		} 
		//时间字符串产生方式  MMddHHmm
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		// 组合流水号前一部分，时间字符串，如：20181211
		String uid_pfix = format.format(new Date());
		// 判断数据库是否有数据
		if (max_code != null && max_code.contains(uid_pfix)) {
			// 从20180001截取字符串最后四位，结果:0001
			String uid_end = max_code.substring(8, 12);
			// 把String类型的0001转化为int类型的1
			int endNum = Integer.parseInt(uid_end);
			// 结果10002
			int tmpNum = 10000 + endNum + 1;
			// 把10002首位的1去掉，再拼成201812110002字符串
			comment_code = uid_pfix + YkRuKuController.subStr("" + tmpNum, 1);
		} else {
			// 当数据库没有数据时，输出201812110001
			comment_code = uid_pfix + "0001";
		}

		jsonReturn.setMsg(comment_code);
		return JSONSerializer.toJSON(jsonReturn);		

	}

	/*
	 * 进库单号-把10002首位的1去掉的实现方法
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
	
	
	/*
     * 新增药品入库
     */
    @ResponseBody
	@RequestMapping(value="/AllStockdetail",produces="application/json")
	public Object AllStockdetail(HttpServletRequest request){
		
		JsonReturn jsonReturn =new JsonReturn();		
		
		//获取页面传过来的值
		String enterstockcode = request.getParameter("enterstockcode"); 
		String enterdate = request.getParameter("enterdate"); 
		String djuserId = request.getParameter("djuserId");
		String enterauditorbit =request.getParameter("enterauditorbit");
						
		//数据类型转换
		Date strenterdate = null;
		int strdjuserId=Integer.parseInt(djuserId);
		boolean strenterauditorbit=Boolean.parseBoolean(enterauditorbit);
		try {
			strenterdate = new SimpleDateFormat("yyyy-MM-dd").parse(enterdate);			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//先新增进货表信息 ，返回进货ID给明细表使用		
		Enterstock strEnterstock = new Enterstock();
		strEnterstock.setEnterstockcode(enterstockcode);
		strEnterstock.setEnterdate(strenterdate);
		strEnterstock.setDjuserId(strdjuserId);
	    strEnterstock.setEnterauditorbit(strenterauditorbit);
		boolean bol= enterstockService.insertEnterStock(strEnterstock);
		
		//获取页面数组信息
		String strShuZu = request.getParameter("suzu");
		
		//初始化切割值
		String stockdetailIdA="";
		
		//先以,切割数组行数
		String[] dh=strShuZu.split(",");
		
		//再进行循环遍历出对应的明细条数
		for (int i = 0; i < dh.length; i++) {
			//获取一条数据进行切割
			String sttt = dh[i];
			String[] ttr = sttt.split("SS");
			//将切割完的信息进行排序
			stockdetailIdA = ttr[0];
			
			//转换数据类型
			int strStockdetailIdA = Integer.parseInt(stockdetailIdA);

			if (bol) {
				//获取明细信息
				Enterstockdetail strDetail = new Enterstockdetail();
				strDetail.setEnterstockId(strEnterstock.getEnterstockId());
				strDetail.setStockdetailId(strStockdetailIdA);		
				//保存明细信息
				boolean bols = enterstockService.insertEnterStockDetail_ID(strDetail);
				if (bols) {
					jsonReturn.setState(true);
					jsonReturn.setMsg("请购药品入库成功");
				} else {
					jsonReturn.setState(false);
					jsonReturn.setMsg("基本信息不能为空，入库失败");
				}
			}

		}
		
		return JSONSerializer.toJSON(jsonReturn);
    }
    
	
    /*
     * 查询药品入库信息
     */
    @ResponseBody
    @RequestMapping(value="/JinKuShenHe",produces="application/json;charset=UTF-8")
    public String JinKuShenHe(HttpServletRequest request){
    	    	    	
    	String strpageSize = request.getParameter("pageSize");
		String strcurPage = request.getParameter("curPage");
				
		//分页
		Bsgrid<Enterstockdetail> bsgrid = new Bsgrid<Enterstockdetail>();
		
		if (Tools.isNum(strpageSize) && Tools.isNum(strcurPage)) {
			
			int pageSize = Integer.parseInt(strpageSize);
			int curPage = Integer.parseInt(strcurPage);

			int startIndex = (curPage - 1) * pageSize;
			
			List<Enterstockdetail> list = enterstockService.getEnterStocks("1=1", startIndex, pageSize);
			int totalRows = enterstockService.getEnterStockRow("1=1");			

			bsgrid.setCurPage(curPage);
			bsgrid.setTotalRows(totalRows);
			bsgrid.setSuccess(true);
			bsgrid.setData(list);
			
		} else {
			bsgrid.setSuccess(false);
		}
		
		return JSONSerializer.toJSON(bsgrid).toString();
    	
    }
    
    
	
	
	
	
}
