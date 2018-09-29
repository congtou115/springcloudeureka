package com.zzidc.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data-mapping")
public class DataMappingManagerController {
	
	/**
	 * 
	 * [获取所有映射列表]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月29日  上午9:36:29 <br>
	 * @param model
	 * @return <br>
	 */
	public String list(Model model) {
		
		return "bootstrap/datamapping/list";
	}
	
}
