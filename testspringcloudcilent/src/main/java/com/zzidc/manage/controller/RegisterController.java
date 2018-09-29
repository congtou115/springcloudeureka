package com.zzidc.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zzidc.entity.EurekaApi;
import com.zzidc.manage.service.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	
	@RequestMapping(value = "/toAddJk",method = RequestMethod.GET)
	public String toAddJk() {
		return "bootstrap/service_zc";
	}
	
	@RequestMapping(value = "/jk")
	public ModelAndView findAll() {
		//List<EurekaApi> rglist = registerService.findAll();
		ModelAndView mv = new ModelAndView();
		//mv.addObject("", rglist);
		mv.setViewName("bootstrap/service_list");
		return mv;
	}
	
}