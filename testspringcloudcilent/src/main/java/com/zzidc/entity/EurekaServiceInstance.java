package com.zzidc.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eureka_service_instance")
public class EurekaServiceInstance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6559053999175813574L;

	@Id
	@Column(name = "instance_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instanceId;
	
	@ManyToOne(targetEntity = EurekaServiceProvider.class,
			fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id",referencedColumnName = "service_id")
	private EurekaServiceProvider service;
	
	@Column(name = "instance_name",nullable = false, length = 100)
	private String instanceName;
	
	@Column(name = "instance_host",nullable = false, length = 100)
	private String instanceHost;
	
	@Column(name = "instance_port",nullable = false, length = 10)
	private String instancePort;
	
	@Column(name = "meta_data",length = 500)
	private String metaData;
	
	@Column(name = "register_status",nullable = false, length = 10)
	private String registerStatus = "UP";
	
	@Column(length = 225)
	private String statusPageUrl;
	
	@Column(name = "register_time")
	private Timestamp registerTime;
	
	@Column(name = "update_time")
	private Timestamp updateTime;

	public EurekaServiceInstance() {
		super();
	}


	public EurekaServiceProvider getService() {
		return service;
	}


	public void setService(EurekaServiceProvider service) {
		this.service = service;
	}


	public String getStatusPageUrl() {
		return statusPageUrl;
	}


	public void setStatusPageUrl(String statusPageUrl) {
		this.statusPageUrl = statusPageUrl;
	}


	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getInstanceHost() {
		return instanceHost;
	}

	public void setInstanceHost(String instanceHost) {
		this.instanceHost = instanceHost;
	}

	public String getInstancePort() {
		return instancePort;
	}

	public void setInstancePort(String instancePort) {
		this.instancePort = instancePort;
	}

	public String getMetaData() {
		return metaData;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}

	public String getRegisterStatus() {
		return registerStatus;
	}

	public void setRegisterStatus(String registerStatus) {
		this.registerStatus = registerStatus;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}


	@Override
	public String toString() {
		return "EurekaServiceInstance [instanceId=" + instanceId + ", service=" + service + ", instanceName="
				+ instanceName + ", instanceHost=" + instanceHost + ", instancePort=" + instancePort + ", metaData="
				+ metaData + ", registerStatus=" + registerStatus + ", registerTime=" + registerTime + ", updateTime="
				+ updateTime + "]";
	}


	public EurekaServiceInstance(EurekaServiceProvider service, String instanceName, String instanceHost,
			String instancePort, String metaData, String registerStatus, Timestamp registerTime, Timestamp updateTime) {
		super();
		this.service = service;
		this.instanceName = instanceName;
		this.instanceHost = instanceHost;
		this.instancePort = instancePort;
		this.metaData = metaData;
		this.registerStatus = registerStatus;
		this.registerTime = registerTime;
		this.updateTime = updateTime;
	}
	
	
}
