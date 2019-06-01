package com.qx.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/YKYaoFangController")
public class YKYaoFangController {
	
	@RequestMapping("/LingLiaoDan")
	public String LingLiaoDan(HttpServletRequest request){				
				
		return "/YaoKu/LingLiaoDan";
		
	}
		
	@RequestMapping("/JieShouKuFang")
	public String JieShouKuFang(HttpServletRequest request){				
				
		return "/YaoKu/JieShouKuFang";
		
	}
	
}
