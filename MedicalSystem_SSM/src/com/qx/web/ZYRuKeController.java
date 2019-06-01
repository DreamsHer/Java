package com.qx.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ZYRuKeController")
public class ZYRuKeController {
	
	@RequestMapping("/RuKeZhuanKe")
	public String RuKeZhuanKe(HttpServletRequest request){
		return "/ZhuYuan/RuKeZhuanKe";
	}
	
}
