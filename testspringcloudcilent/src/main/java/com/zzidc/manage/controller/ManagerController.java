package com.zzidc.manage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zzidc.dao.EurekaIpDao;
import com.zzidc.dao.EurekaServiceIpAssociateDao;
import com.zzidc.dao.EurekaServiceProviderDao;
import com.zzidc.entity.EurekaIp;
import com.zzidc.entity.EurekaServiceIpAssociate;
import com.zzidc.entity.EurekaServiceProvider;
import com.zzidc.manage.service.ManagerService;
import com.zzidc.util.ObjectUtils;
import com.zzidc.util.ResultInfo;


@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	/**
	 * 
	 * [获取所有注册到Eureka注册中心服务列表]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月10日  下午6:03:30 <br>
	 * @return <br>
	 */
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView index() {
		List<EurekaServiceProvider> serviceList = managerService.findAllService();
		ModelAndView mv = new ModelAndView();
		mv.addObject("services", serviceList);
		mv.setViewName("bootstrap/index");
		return mv;
	}
	
	/**
	 * 
	 * [根据服务名获取服务设置的IP白名单]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月10日  下午6:04:03 <br>
	 * @param service
	 * @return <br>
	 */
	@RequestMapping(value="/whiteIpList/{serviceId}",method = RequestMethod.GET)
	public String whiteIpList(@PathVariable int serviceId,Model model) {
		EurekaServiceProvider service = managerService.findServiceById(serviceId);
		List<EurekaServiceIpAssociate> ips = managerService.findIpAssociateByService(service);
		model.addAttribute("service", service);
		model.addAttribute("ipList", ips);
		return "bootstrap/ipList";
	}
	
	/**
	 * 
	 * [获取全部IP白名单信息]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月18日  下午4:54:23 <br>
	 * @param serviceId
	 * @param model
	 * @return <br>
	 */
	@RequestMapping(value="/whiteIpList",method = RequestMethod.GET)
	public String allWhiteIpList(Model model) {
		List<EurekaServiceIpAssociate> ips = managerService.findAllAssociate();
		model.addAttribute("ipList", ips);
		return "bootstrap/ipList";
	}
	
	/**
	 * 
	 * [删除IP白名单]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月17日  上午10:19:50 <br>
	 * @param serviceId
	 * @param associateId
	 * @return <br>
	 */
	@RequestMapping(value = "/deleteIp/{serviceId}/{associateId}",method = RequestMethod.DELETE)
	@ResponseBody
	public ResultInfo deleteIp(@PathVariable int serviceId, @PathVariable int associateId) {
		return managerService.deleteIp(serviceId,associateId);
	}
	
	/**
	 * 
	 * [跳转添加IP白名单页面]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月17日  上午10:23:31 <br>
	 * @param serviceId
	 * @return <br>
	 */
	@RequestMapping(value = "/toAddIp/{serviceId}",method = RequestMethod.GET)
	public String toAddIp(@PathVariable int serviceId,Model model) {
		EurekaServiceProvider service = managerService.findServiceById(serviceId);
		if(service != null) {
			model.addAttribute("service", service);
		}
		model.addAttribute("services", managerService.findAllService());
		return "bootstrap/addIp";
	}
	
	/**
	 * 
	 * [跳转添加IP白名单页面]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月18日  下午7:08:03 <br>
	 * @return <br>
	 */
	@RequestMapping(value = "/toAddIp",method = RequestMethod.GET)
	public String toAddIpWithoutService(Model model) {
		model.addAttribute("services", managerService.findAllService());
		return "bootstrap/addIp";
	}
	
	/**
	 * 
	 * [添加IP白名单]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月17日  上午11:16:10 <br>
	 * @param serviceId
	 * @param ip
	 * @return <br>
	 */
	@RequestMapping(value = "/ip",method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo createIp(@RequestParam("status") int status,@RequestParam("ip") String ip,@RequestParam("serviceIds") int[] serviceIds) {
		return managerService.createIp(serviceIds,ip,status);
	}
	
	
	/**
	 * 
	 * [修改IP白名单]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月17日  下午4:12:23 <br>
	 * @param serviceId
	 * @param ip
	 * @param associateId
	 * @return <br>
	 */
	@RequestMapping(value = "/ip/{associateId}",method = RequestMethod.PUT)
	@ResponseBody
	public ResultInfo updateIp(@PathVariable int associateId,@RequestParam("status") int status,@RequestParam("ip") String ip,@RequestParam("serviceIds") int[] serviceIds) {
		return managerService.updateIp(associateId,serviceIds,ip,status);
	}
	/**
	 * 
	 * [跳转修改ip白名单页面]
	 *
	 * @author ZhangBinbin <br>
	 * @date   2018年9月19日  下午3:40:25 <br>
	 * @param associateId
	 * @param model
	 * @return <br>
	 */
	@RequestMapping(value = "/ip/{associateId}",method = RequestMethod.GET)
	public String updateIp(@PathVariable int associateId,Model model) {
		EurekaServiceIpAssociate associate = managerService.findIpAssociateById(associateId);
		if(associate == null) {
			return "redirect:/error";
		}
		model.addAttribute("associate", associate);
		model.addAttribute("services", managerService.findAllService());
		//再查下，有多少服务也添加了这个ip
		model.addAttribute("relationServices",managerService.findServiceByIp(associate));
		return "bootstrap/updateIp";
	}
}
