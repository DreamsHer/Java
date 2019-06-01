package com.qx.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ZYJiaoFeiController")
public class ZYJiaoFeiController {
	
	@RequestMapping("/YuJiaoFeiYong")
	public String YuJiaoFeiYong(HttpServletRequest request){
		return "/ZhuYuan/YuJiaoFeiYong";
	}	
	
}
