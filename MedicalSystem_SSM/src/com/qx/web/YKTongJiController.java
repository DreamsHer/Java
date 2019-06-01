package com.qx.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/YKTongJiController")
public class YKTongJiController {

	@RequestMapping("/ZongHeTongJi")
	public String ZongHeTongJi(HttpServletRequest request){				
				
		return "/YaoKu/ZongHeTongJi"; 
		
	}
	
	
}
