package com.qx.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ZYDengJiController")
public class ZYDengJiController {
	
	@RequestMapping("/ZhuYuanDengJi")
	public String ZongHeTongJi(HttpServletRequest request){				
				
		return "/ZhuYuan/ZhuYuanDengJi"; 
		
	}
	
}
