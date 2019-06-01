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

import com.qx.po.Basedetail;
import com.qx.po.Chargingitems;
import com.qx.po.Chargingitemsdetail;
import com.qx.po.Ouhosinfo;
import com.qx.po.Stockdetail;
import com.qx.po.Users;
import com.qx.service.ChargingitemsService;
import com.qx.service.OuhosinfoService;
import com.qx.service.StockService;
import com.qx.service.UserService;
import com.qx.util.Tools;
import com.qx.vo.Bsgrid;
import com.qx.vo.JsonReturn;

@Controller
@RequestMapping("/OuShouFeiController")
public class OuShouFeiController {
	
	//用户信息  
	@Autowired
	private UserService userService;
	
	//门诊挂号病人
	@Autowired
	private OuhosinfoService ouhosinfoService;
	
	//收费项目
	@Autowired
	private ChargingitemsService chargingitemsService;
	
	//进货明细-药品信息
	@Autowired
	private StockService stockService;
	
	/*
	 * 门诊收费页面
	 */
	@RequestMapping("/ShouFei")
	public String ShouFei(HttpServletRequest request){
		//项目单位
		List<Basedetail> BasedetailList = userService.findByBaseId(7);
		request.setAttribute("BasedetailList", BasedetailList);
		
		//收费医生
    	List<Users> UsersList = userService.findByDoctor(3,4,5);
    	request.setAttribute("UsersList", UsersList);
						
		return "/MenZhen/ShouFei";
	}
	
	/*
	 * 门诊-处方单号
	 */
    @ResponseBody
	@RequestMapping(value="/ByPrescriptioncode",produces="application/json")	
	public Object ByPrescriptioncode(Chargingitems chargingitems,HttpServletRequest request) {    	    	
    	JsonReturn jsonReturn=new JsonReturn();   	
    	//查询数据库字段
		List<Chargingitems> list=chargingitemsService.findOuBianHao(chargingitems.getPrescriptioncode());		
		String max_code = ""; //定义装获取数据的信息
		String comment_code = ""; //定义装拼接好的信息						
		if (list.size() > 0) {
			max_code = (String) list.get(0).getPrescriptioncode();
		} 
		//时间字符串产生方式
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
		//组合流水号前一部分，时间字符串，如：20181211081023
		String uid_pfix = format.format(new Date()); 
		//判断数据库是否有数据
		if (max_code != null && max_code.contains(uid_pfix)) {								
			//前缀拼接+时间
			comment_code = "CF" + uid_pfix ;			
		} else {
			//当数据库没有数据时，输出20181211081023
			comment_code ="CF" + uid_pfix ;
		}	
		jsonReturn.setMsg(comment_code);
		return JSONSerializer.toJSON(jsonReturn);				
	}
    
	
    /*
     * 查询挂号病人信息
     */
    @ResponseBody
    @RequestMapping(value="/ShouFeiBingRen",produces="application/json;charset=UTF-8")
    public String ShouFeiBingRen(HttpServletRequest request){
    	    	    	
    	String strpageSize = request.getParameter("pageSize");
		String strcurPage = request.getParameter("curPage");
				
		//分页
		Bsgrid<Ouhosinfo> bsgrid = new Bsgrid<Ouhosinfo>();
		
		if (Tools.isNum(strpageSize) && Tools.isNum(strcurPage)) {
			
			int pageSize = Integer.parseInt(strpageSize);
			int curPage = Integer.parseInt(strcurPage);

			int startIndex = (curPage - 1) * pageSize;
			
			List<Ouhosinfo> list = ouhosinfoService.findPage("1=1", startIndex, pageSize);
			int totalRows = ouhosinfoService.getTotalRow("1=1");			

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
     * 回填挂号病人信息
     */
    @ResponseBody
    @RequestMapping(value="/HuiTianXinXi",produces="application/json;charset=UTF-8")
    public String HuiTianXinXi(Ouhosinfo ouhosinfo ,HttpServletRequest request){
    	
    	JsonReturn jsonReturn=new JsonReturn();
    	   	
    	String strOuhosinfoId =request.getParameter("ouhosinfoIdCS");
    	int ouhosinfoId = Integer.parseInt(strOuhosinfoId);	 
    	
    	Ouhosinfo StrList=null;
    	
    	if(ouhosinfoId >0){    		
    		 StrList=ouhosinfoService.findHuiTian(ouhosinfoId);    				
    	}
    	else {
    		StrList=null;
    		jsonReturn.setState(false);
			jsonReturn.setMsg("获取数据失败");
		}   
    	
    	return JSONSerializer.toJSON(StrList).toString();
    }
	
    /*
     * 调出收费药品信息
     */
    @ResponseBody
    @RequestMapping(value="/ShouFeiYaoPin",produces="application/json;charset=UTF-8")
    public String ShouFeiYaoPin(HttpServletRequest request){
    	    	    	
    	String strpageSize = request.getParameter("pageSize");
		String strcurPage = request.getParameter("curPage");
				
		//分页
		Bsgrid<Stockdetail> bsgrid = new Bsgrid<Stockdetail>();
		
		if (Tools.isNum(strpageSize) && Tools.isNum(strcurPage)) {
			
			int pageSize = Integer.parseInt(strpageSize);
			int curPage = Integer.parseInt(strcurPage);

			int startIndex = (curPage - 1) * pageSize;
			
			List<Stockdetail> list = stockService.getShouFeiYaoPin("1=1", startIndex, pageSize);
			int totalRows = stockService.getShouFeiYaoPinRow("1=1");			

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
     * 回填收费药品信息
     */
    @ResponseBody
    @RequestMapping(value="/HuiTianYaoPinXinXi",produces="application/json;charset=UTF-8")
    public String HuiTianYaoPinXinXi(Stockdetail stockdetail ,HttpServletRequest request){
    	
    	JsonReturn jsonReturn=new JsonReturn();
    	   	
    	String strStockDetail_ID =request.getParameter("stockdetailId");
    	int stockdetailId = Integer.parseInt(strStockDetail_ID);	 
    	
    	Stockdetail StrList=null;
    	
    	if(stockdetailId >0){ 		
    		 StrList=stockService.HuiTianShouFeiYaoPin(stockdetailId);    				
    	}
    	else {
    		StrList=null;
    		jsonReturn.setState(false);
			jsonReturn.setMsg("获取数据失败");
		}   
    	
    	return JSONSerializer.toJSON(StrList).toString();
    }
    
    
    /*
     * 新增收费项目明细信息 
     */
    @ResponseBody
	@RequestMapping(value="/PayService",produces="application/json")
	public Object PayService(HttpServletRequest request){
		
		JsonReturn jsonReturn =new JsonReturn();
		
		//获取jsp页面数组信息
		String strsu = request.getParameter("suzu");
		
		//获取页面传过来的值
		String prescriptioncode = request.getParameter("prescriptioncode");
		String ouhosinfoId = request.getParameter("ouhosinfoId");
		String receivablemoney =request.getParameter("receivablemoney");
		String paymentmoney =request.getParameter("paymentmoney");
		String userId =request.getParameter("userId");
		String chargingtime =request.getParameter("chargingtime");
		
		//数据类型转换
		int strouhosinfoId=Integer.parseInt(ouhosinfoId);
		double strreceivablemoney =Double.parseDouble(receivablemoney);
		double strpaymentmoney =Double.parseDouble(paymentmoney);
		int struserId=Integer.parseInt(userId);
		Date sqlData = null; 
		try {
			sqlData = new SimpleDateFormat("yyyy-MM-dd").parse(chargingtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		//实例化收费表 ，返回收费表ID给明细表使用
		Chargingitems strChargingitems =new Chargingitems();
		strChargingitems.setPrescriptioncode(prescriptioncode);		
		strChargingitems.setOuhosinfoId(strouhosinfoId);
		strChargingitems.setReceivablemoney(strreceivablemoney);
		strChargingitems.setPaymentmoney(strpaymentmoney); 
		strChargingitems.setUserId(struserId);
		strChargingitems.setChargingtime(sqlData);		
		boolean bol= chargingitemsService.InsertShouFei(strChargingitems);	
		
		//初始化切割值
		String stockdetailIdA="";
		String amountA="";
		String itemmoneyA="";
		String discountA="";
		String frequencyA="";
		String coefficientA="";
		
		//先以,切割数组行数
		String[]  dh=strsu.split(",");
		
		//再进行循环遍历出对应的明细条数
		for (int i = 0; i < dh.length; i++) {
			//获取一条数据进行切割
			String sttt = dh[i];
			String[] ttr = sttt.split("SS");
			//将切割完的信息进行对应排序
			stockdetailIdA = ttr[0];
			amountA = ttr[1];
			itemmoneyA = ttr[2];
			discountA = ttr[3];
			frequencyA = ttr[4];
			coefficientA = ttr[5];
			//转换数据类型
			int strStockdetailId = Integer.parseInt(stockdetailIdA);
			double stritemmoney = Double.parseDouble(itemmoneyA);
			double strdiscount = Double.parseDouble(discountA);

			if (bol) {
				//获取明细信息
				Chargingitemsdetail strDetail = new Chargingitemsdetail();
				strDetail.setChargingitemId(strChargingitems.getChargingitemId());
				strDetail.setStockdetailId(strStockdetailId);
				strDetail.setAmount(amountA);
				strDetail.setItemmoney(stritemmoney);
				strDetail.setDiscount(strdiscount);
				strDetail.setFrequency(frequencyA);
				strDetail.setCoefficient(coefficientA);				
				//保存明细信息
				boolean bols = chargingitemsService.InsertShouFeiMingXi(strDetail);
				if (bols) {
					jsonReturn.setState(true);
					jsonReturn.setMsg("收费成功");
				} else {
					jsonReturn.setState(false);
					jsonReturn.setMsg("明细信息不能为空，收费失败");
				}
			}

		}
		
		return JSONSerializer.toJSON(jsonReturn);
    }
    
    
}
