package com.qx.web;

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
import com.qx.po.Drugroom;
import com.qx.po.Outstock;
import com.qx.service.OutstockService;
import com.qx.service.UserService;
import com.qx.vo.JsonReturn;

@Controller
@RequestMapping("/YKChuKuController")
public class YKChuKuController {
	
	@Autowired
	private OutstockService outstockService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/ChuKuShenHe")
	public String ChuKuShenHe(HttpServletRequest request){				
				
		//查询登记人
		List<Drugroom> drugroomList =outstockService.findDrugRoom_ID();
		request.setAttribute("drugroomList", drugroomList);
		
		//项目单价
		List<Basedetail> BasedetailList = userService.findByBaseId(11);
		request.setAttribute("BasedetailList", BasedetailList);
		
		return "/YaoKu/ChuKuShenHe";
		
	}
	
	/*
	 * 药库-出库单号
	 */
	@ResponseBody
	@RequestMapping(value="/getOutstockcode",produces="application/json")	
	public Object getOutstockcode(Outstock outstock,HttpServletRequest request) {
    	    	
    	JsonReturn jsonReturn=new JsonReturn();
    	
    	//查询数据库表字段
		List<Outstock> list=outstockService.findChuKuDanHao(outstock.getOutstockcode());
		
		String max_code = ""; //定义装获取数据的信息
		String comment_code = ""; //定义装拼接好的信息					
		if (list.size() > 0) {
			max_code = (String) list.get(0).getOutstockcode();
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
			comment_code = uid_pfix + YKChuKuController.subStr("" + tmpNum, 1);
		} else {
			// 当数据库没有数据时，输出201812110001
			comment_code = uid_pfix + "0001";
		}

		jsonReturn.setMsg(comment_code);
		return JSONSerializer.toJSON(jsonReturn);		

	}
	
	/*
	 * 出库单号—把10002首位的1去掉的实现方法
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
