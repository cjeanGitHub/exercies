package com.cjean.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/str")
public class HelloControllerStr {
	@RequestMapping("/hello1")
	public String getHello11() {
		return "modelAndView";
	}

}
