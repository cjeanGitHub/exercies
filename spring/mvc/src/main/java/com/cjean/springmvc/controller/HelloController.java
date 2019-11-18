package com.cjean.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class HelloController {
	
	@RequestMapping("/mvc")
	public ModelAndView getHello() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("msg", "springmvc of cjean");

		modelAndView.addObject("msg2", "褚栋梁的springmvc测试");

		modelAndView.setViewName("hello");
		return modelAndView;
	}

	@RequestMapping("/say")
	public String getJsp() {
		return "say";
	}
}
