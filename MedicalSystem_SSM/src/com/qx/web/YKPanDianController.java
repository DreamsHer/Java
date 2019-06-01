package com.qx.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/YKPanDianController")
public class YKPanDianController {

	@RequestMapping("/YaoPinPanDian")
	public String YaoPinPanDian(HttpServletRequest request){				
				
		return "/YaoKu/YaoPinPanDian";
		
	}
	
}
