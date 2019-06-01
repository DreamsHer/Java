package com.qx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ZYChuYuanController")
public class ZYChuYuanController {
	
	@RequestMapping("/ChuYuanGuanLi")
	public String ChuYuanGuanLi() {
		return "/ZhuYuan/ChuYuanGuanLi";
	}
	
}
