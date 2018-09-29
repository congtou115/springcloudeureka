package com.zzidc.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzidc.entity.EurekaApi;
import com.zzidc.entity.EurekaServiceProvider;
import com.zzidc.manage.service.DataMappingManagerService;
import com.zzidc.util.ResultInfo;

@Controller
@RequestMapping("/data-mapping")
public class DataMappingManagerController {
	
	@Autowired
	private DataMappingManagerService dataMappingService;
	/**
	 * 
	 * [获取所有映射列表]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月29日  上午9:36:29 <br>
	 * @param model
	 * @return <br>
	 */
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list", dataMappingService.findAllProtocol());
		return "bootstrap/datamapping/index";
	}
	
	/**
	 * 
	 * [获取特定接口的映射列表]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月29日  上午9:36:29 <br>
	 * @param model
	 * @return <br>
	 * @throws Exception 
	 */
	@RequestMapping(value = "/list/{apiId}",method = RequestMethod.GET)
	public String getProtocolListByApiId(Model model,@PathVariable int apiId) throws Exception {
		ResultInfo result = dataMappingService.findProtocolByApi(apiId);
		if( result.getCode() != 0 ) {
			throw new Exception(result.getInfo().toString());
		}
		model.addAttribute("list",result.getInfo() );
		return "bootstrap/datamapping/index";
	}
	
	
	/**
	 * 
	 * [跳转添加映射页面，携带有接口的id]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月29日  下午5:31:22 <br>
	 * @param model
	 * @param apiId
	 * @return <br>
	 */
	@RequestMapping(value = "/toAdd/{serviceId}",method = RequestMethod.GET)
	public String toAddDMProtocol(Model model,@PathVariable int serviceId) {
		model.addAttribute("services", dataMappingService.findAllService());
		EurekaServiceProvider service = dataMappingService.findServiceById(serviceId);
		
		/*List<EurekaApi> apis = dataMappingService.findApiByServiceId(serviceId);
		if(!ObjectUtils.isEmpty(apis)) {
			model.addAttribute("service", service);
			model.addAttribute("apis", dataMappingService.findApiByServiceId(serviceId));
		}*/
		return "bootstrap/datamapping/addProtocol";
	}
	
	/**
	 * 
	 * [跳转添加映射页面，携带有接口的id]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月29日  下午5:31:22 <br>
	 * @param model
	 * @param apiId
	 * @return <br>
	 */
	@RequestMapping(value = "/toAdd/{serviceId}/{apiId}",method = RequestMethod.GET)
	public String toAddProtocol(Model model,@PathVariable int apiId,@PathVariable int serviceId) {
		model.addAttribute("services", dataMappingService.findAllService());
		
		return "bootstrap/datamapping/addProtocol";
	}
	
	/**
	 * 
	 * [跳转添加映射页面]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月29日  下午5:31:22 <br>
	 * @param model
	 * @param apiId
	 * @return <br>
	 */
	@RequestMapping(value = "/toAdd",method = RequestMethod.GET)
	public String toAddProtocol(Model model) {
		model.addAttribute("services", dataMappingService.findAllService());
		return "bootstrap/datamapping/addProtocol";
	}
	
}
