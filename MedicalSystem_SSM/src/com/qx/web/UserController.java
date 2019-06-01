package com.qx.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qx.util.ValidateImage.GifCaptcha;
import com.qx.po.Basedetail;
import com.qx.po.Userrole;
import com.qx.po.Users;
import com.qx.service.UserService;
import com.qx.vo.JsonReturn;

@Controller
@RequestMapping("/userss")
public class UserController  {
		
	@Autowired
	private UserService userService;		
		
	/*
	 *获取用户信息登录
	 */
	@ResponseBody
	@RequestMapping("/login")
	public Object login(Users usersone,HttpServletRequest request){
		
		JsonReturn jsonReturn =new JsonReturn();	
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String identityKey = request.getParameter("identityKey");
		
		HttpSession session =request.getSession();		
		try {
			String sessionKey = session.getAttribute("identityKey").toString();
			if (sessionKey.equalsIgnoreCase(identityKey)) {								
				Users users = userService.selectByMC(userName,password);													
				if (users != null) {// 登录成功
					//将user放入session
					session.setAttribute("RecordSession", users);
					jsonReturn.setState(true);
					jsonReturn.setMsg("登录成功");
				} else {
					jsonReturn.setState(false);
					jsonReturn.setMsg("用户名或者密码错误");
				}
			} else {
				jsonReturn.setState(false);
				jsonReturn.setMsg("请输入正确的验证码");
			}
		} catch (Exception e) {
			
		}		
		return JSONSerializer.toJSON(jsonReturn);
		
	}
	
	/*
	 * 登录跳转主页面
	 */
	@RequestMapping("/main")
	public String main(HttpServletRequest request){
		
		HttpSession session = request.getSession();	
	    Users us = (Users) session.getAttribute("RecordSession");				
		request.setAttribute("name", us.getUsername());
		
		return "/main";								
	}		
	
	/*
	 * 生成验证码图片
	 */
	@RequestMapping("/identity")
	public void identity(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 根据宽、高、验证码的个数生成验证码图片
		GifCaptcha captcha = new GifCaptcha(98, 46, 4);
		// 定义一个字节输出流变量
		ServletOutputStream out = response.getOutputStream();
		// 获取验证码的值
		String identityKey = captcha.out(out);
		// 设置验证码图片的值保存到session中
		request.getSession().setAttribute("identityKey", identityKey);
		System.out.println(identityKey);
		// 刷新流
		out.flush();
		// 关闭流
		out.close();
	}					
	
	/*
	 * 用户注册
	 */	
	@ResponseBody
	@RequestMapping(value="/register")
	public Object register(Users user, HttpServletRequest request){
		
		JsonReturn jsonReturn =new JsonReturn();
		
		List<Users> us= userService.findBycertificateidcs(user.getCertificateid()); 
		
		if(us.size() <=0){
			
			Users strUsers =new Users();
			
			strUsers.setUsername(user.getUsername());
			strUsers.setPassword(user.getPassword());
			strUsers.setUsercode(user.getUsercode());
			strUsers.setBasedetailId1(user.getBasedetailId1());
			strUsers.setCertificateid(user.getCertificateid());
			strUsers.setAge(user.getAge());
			strUsers.setPhone(user.getPhone());
			strUsers.setEmail(user.getEmail());
			strUsers.setBasedetailId2(user.getBasedetailId2());
			strUsers.setUserroleId(user.getUserroleId());
			strUsers.setMemo(user.getMemo());
			strUsers.setUserreviewno(user.getUserreviewno());
			strUsers.setLocation(user.getLocation());
			
			//查询SQL语句	
			boolean bol= userService.register(strUsers);
			if (bol) {
				jsonReturn.setState(true);
				jsonReturn.setMsg("注册成功");
			}else {
				jsonReturn.setState(false);
				jsonReturn.setMsg("注册失败");
			}			
		}
		else {			
			jsonReturn.setState(false);
			jsonReturn.setMsg("你已经注册过一次");			
		}
		
		return JSONSerializer.toJSON(jsonReturn);
						
	}
       
    /*
	 * 查询性别、科室类型、角色类型
	 */
	@RequestMapping("/loginjsp")
	public String loginjsp(HttpServletRequest request){
	
	  //性别
	  List<Basedetail> BasedetailList=userService.findByBaseId(2);  	
      request.setAttribute("BasedetailList",BasedetailList);
      
      //科室类型
      List<Basedetail> BasedetailListt=userService.findByBaseId1(4);	
      request.setAttribute("BasedetailListt",BasedetailListt);
      
      //角色类型
      List<Userrole> UserroleList=userService.findByUserrole();	
      request.setAttribute("UserroleList",UserroleList);     
      
      return  "/login";
	}
	
	/*
	 * 自动生成编号格式：GH+yyyyMMdd+四位流水号 
	 */
    @ResponseBody
	@RequestMapping(value="/usercode",produces="application/json")	
	public Object usercode(Users users,HttpServletRequest request) {
    	
    	//实例化输出Json格式
    	JsonReturn jsonReturn=new JsonReturn(); 
    	//查询数据库字段
		List<Users> list=userService.findByUsercode(users.getUsercode());
		
		String max_code = ""; //定义装获取数据的信息
		String comment_code = ""; //定义装拼接好的信息						
		if (list.size() > 0) {
			max_code = (String) list.get(0).getUsercode();
		} 
		//时间字符串产生方式
		SimpleDateFormat format = new SimpleDateFormat("yyyy"); 
		//组合流水号前一部分，时间字符串，如：2018
		String uid_pfix = format.format(new Date()); 
		//判断数据库是否有数据
		if (max_code != null && max_code.contains(uid_pfix)) {			
			//从20180001截取字符串最后四位，结果:0001
			String uid_end = max_code.substring(4, 8); 
			//把String类型的0001转化为int类型的1
			int endNum = Integer.parseInt(uid_end); 
			//结果10002
			int tmpNum = 10000 + endNum + 1; 			
			//把10002首位的1去掉，再拼成GH201812110002字符串
			comment_code = uid_pfix + UserController.subStr("" + tmpNum, 1);			
		} else {
			//当数据库没有数据时，输出GH201812110001
			comment_code = uid_pfix + "0001";
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
	 * 退出当前用户
	 */
	@RequestMapping("/Outlogin")
	public String Outlogin(HttpServletRequest request){
		HttpSession session = request.getSession();	
		Users us = (Users) session.getAttribute("Usersws");			
		request.setAttribute("userid", us);
		return "/login";							
	}	
     	
}
