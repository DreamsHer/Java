package com.qx.web;

import java.util.Date;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qx.util.Tools;
import com.qx.po.Basedetail;
import com.qx.po.Ouhosinfo;
import com.qx.po.Patient;
import com.qx.po.Users;
import com.qx.service.PatientService;
import com.qx.service.UserService;
import com.qx.service.OuhosinfoService;
import com.qx.vo.JsonReturn;

@Controller
@RequestMapping("/OuGuaHaoController")
public class OuGuaHaoController {
	
	//用户信息   MenZhenController
	@Autowired
	private UserService userService;
	
	//门诊挂号
	@Autowired
	private OuhosinfoService ouhosinfoService;
	
	//病人信息表
	@Autowired
	private PatientService patientService;
	
	/*
	 * 页面跳转，加载下拉框
	 */
	@RequestMapping("/GuaHao")
	public String GuaHao(HttpServletRequest request){
		
		//性别
		List<Basedetail> BasedetailList = userService.findByBaseId(2);
		request.setAttribute("BasedetailList", BasedetailList);
		
		//挂号类型
		List<Basedetail> BasedetailListt = userService.findByBaseId1(1);
		request.setAttribute("BasedetailListt", BasedetailListt);
		
		//挂号科室
		List<Basedetail> BasedetailListtt = userService.findByBaseId2(4);
		request.setAttribute("BasedetailListtt", BasedetailListtt);
		
		//挂号医生
		List<Users> UsersList = userService.findByDoctor(3,4,5);
		request.setAttribute("UsersList", UsersList); 
				
		return "/MenZhen/GuaHao";		
	}	
	
	/*
	 * 自动生成挂号编号，格式：GH+yyyyMMdd+四位流水号 
	 */
    @ResponseBody
	@RequestMapping(value="/mzregno",produces="application/json")	
	public Object mzregno(Ouhosinfo ouhosinfos,HttpServletRequest request) {  	    	
    	//实例化输出Json格式
    	JsonReturn jsonReturn=new JsonReturn(); 
    	
    	//查询数据库最新生成的编号
		List<Ouhosinfo> list=ouhosinfoService.findByGuaHao(ouhosinfos.getMzregno());
		
		String max_code = ""; //定义装获取数据的信息
		String comment_code = ""; //定义拼接好的信息						
		if (list.size() > 0) {
			max_code = (String) list.get(0).getMzregno();
		} 
		//时间字符串产生方式
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); 
		//组合流水号前一部分，时间字符串，如：20190219
		String uid_pfix = format.format(new Date()); 
		//判断数据库是否有数据
		if (max_code != null && max_code.contains(uid_pfix)) {			
			//从GH2019021910001截取字符串最后四位，结果:0001
			String uid_end = max_code.substring(10, 14); 
			//把String类型的0001转化为int类型的1
			int endNum = Integer.parseInt(uid_end); 
			//结果10002
			int tmpNum = 10000 + endNum + 1; 			
			//把10002首位的1去掉，再拼成GH2019021910002字符串
			comment_code = "GH" + uid_pfix + OuGuaHaoController.subStr("" + tmpNum, 1);			
		} else {
			//当数据库没有数据时，输出GH201812110001
			comment_code ="GH" + uid_pfix + "0001";
		}
 	
		jsonReturn.setMsg(comment_code);
		return JSONSerializer.toJSON(jsonReturn);		
		
	}
	
	/*
	 * 把10002首位的1去掉的实现方法
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
	 * 新增门诊挂号信息
	 */
	@ResponseBody
	@RequestMapping(value="/MenZhenGuaHao",produces="application/json")
	public Object MenZhenGuaHao(HttpServletRequest request){
		
    	JsonReturn jsonReturn=new JsonReturn(); //实例化输出Json格式		
    	
		String mzregno = request.getParameter("mzregno"); //挂号单号
		String strregtime =request.getParameter("regtime"); //挂号时间		
		String patientname =request.getParameter("patientname");//病人姓名
		String strbasedetailId1=request.getParameter("basedetailId1");//性别
		String age=request.getParameter("age");//年龄
		String certificateid =request.getParameter("certificateid");//病人身份证号
		String cardno=request.getParameter("cardno");//医疗卡号
		String socialsecurityno=request.getParameter("socialsecurityno");//社保账号			
		String strlxbasedetailId =request.getParameter("lxbasedetailId");//挂号类型			
		String registerno=request.getParameter("registerno");//挂号张数
		String struserId=request.getParameter("userId");//挂号医生			
		String strksbasedetailId =request.getParameter("ksbasedetailId");//挂号科室					
		String regfee=request.getParameter("regfee");//挂号费用		
		String pay=request.getParameter("pay");//支付金额 
		String strfirstdate =request.getParameter("firstdate"); //出诊时间	
		String strjzbasedetailId =request.getParameter("jzbasedetailId"); //出诊科室	
		
		if (Tools.isNotNull(mzregno) && Tools.isNotNull(patientname) && Tools.isNotNull(certificateid)){
			//时间转换
	        Date sqlData = null; 
	        Date sqlfirstdate =null;
			try {
				sqlData = new SimpleDateFormat("yyyy-MM-dd").parse(strregtime);
				sqlfirstdate =new SimpleDateFormat("yyyy-MM-dd").parse(strfirstdate);
			} catch (ParseException e) {
				e.printStackTrace();
			}	
			
			//类型转换
	        int basedetailId1 = Integer.parseInt(strbasedetailId1);	        
	        int LxbasedetailId = Integer.parseInt(strlxbasedetailId);			
			int userId = Integer.parseInt(struserId);				
			int KsbasedetailId = Integer.parseInt(strksbasedetailId);	
			int jzbasedetailId = Integer.parseInt(strjzbasedetailId);
			double strRegfee =Double.parseDouble(regfee);			
			double strPay =Double.parseDouble(pay);
	        //病人信息表
			Patient pa =new Patient();			
			pa.setPatientname(patientname);
			pa.setBasedetailId1(basedetailId1);
			pa.setAge(age);			
			pa.setCertificateid(certificateid);
			pa.setCardno(cardno);
			pa.setSocialsecurityno(socialsecurityno);
			//查询SQL语句			
			boolean bols= patientService.InsertPatient(pa);				
			if(bols){
				//病人挂号表	
				Ouhosinfo ou = new Ouhosinfo();	
				ou.setMzregno(mzregno);				
				ou.setRegtime(sqlData);
				ou.setLxbasedetailId(LxbasedetailId);
				ou.setRegisterno(registerno);	
				ou.setUserId(userId);
				ou.setKsbasedetailId(KsbasedetailId);
				ou.setRegfee(strRegfee);
				ou.setPay(strPay);
				ou.setPatientId(pa.getPatientId());
				ou.setFirstdate(sqlfirstdate);
				ou.setJzbasedetailId(jzbasedetailId);
				
				//查询SQL语句
				boolean bol = ouhosinfoService.InsertOuhosinfo(ou);								
				if (bol) {
					jsonReturn.setState(true);
					jsonReturn.setMsg("恭喜您，挂号成功");
				} else {
					jsonReturn.setState(false);
					jsonReturn.setMsg("不好意思，挂号失败");
				}
			} else {
				jsonReturn.setState(false);
				jsonReturn.setMsg("请您先填写完整信息");
			}
		}
		return JSONSerializer.toJSON(jsonReturn);
	}	
			
}
