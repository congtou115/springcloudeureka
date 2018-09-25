package com.zzidc.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "eureka_service_provider")
public class EurekaServiceProvider implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7813722749690293649L;

	@Id
	@Column(name = "service_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId;
	
	@Column(name = "service_name",unique = true,nullable = false,length = 100)
	private String serviceName;
	
	@Column(name = "remark",nullable = true,length = 250)
	private String remark;
	
	@Column(name = "create_time")
	private Timestamp createTime;
	
	@Column(name = "update_time")
	private Timestamp updateTime;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "service",cascade= {CascadeType.REMOVE})
	private List<EurekaServiceIpAssociate> associtate;
	
	@OneToMany(mappedBy = "service",cascade= {CascadeType.REMOVE})
	private List<EurekaServiceInstance> instances;
	
	@OneToMany(mappedBy = "service",cascade= {CascadeType.REMOVE})
	private List<EurekaApi> apis;
	
	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public EurekaServiceProvider(String serviceName, String remark) {
		super();
		this.serviceName = serviceName;
		this.remark = remark;
		Timestamp now = new Timestamp(System.currentTimeMillis());
		this.createTime = now;
		this.updateTime = now;
		now = null;
	}
	

	public EurekaServiceProvider(String serviceName, String remark, Timestamp createTime, Timestamp updateTime,
			List<EurekaServiceIpAssociate> associtate, List<EurekaServiceInstance> instances, List<EurekaApi> apis) {
		super();
		this.serviceName = serviceName;
		this.remark = remark;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.associtate = associtate;
		this.instances = instances;
		this.apis = apis;
	}

	@Override
	public String toString() {
		return "EurekaServiceProvider [serviceId=" + serviceId + ", serviceName=" + serviceName + ", remark=" + remark
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

	public EurekaServiceProvider() {
		super();
	}

	public List<EurekaServiceIpAssociate> getAssocitate() {
		return associtate;
	}

	public void setAssocitate(List<EurekaServiceIpAssociate> associtate) {
		this.associtate = associtate;
	}

	public List<EurekaServiceInstance> getInstances() {
		return instances;
	}

	public void setInstances(List<EurekaServiceInstance> instances) {
		this.instances = instances;
	}

	public List<EurekaApi> getApis() {
		return apis;
	}

	public void setApis(List<EurekaApi> apis) {
		this.apis = apis;
	}
	
	
	
	
}
