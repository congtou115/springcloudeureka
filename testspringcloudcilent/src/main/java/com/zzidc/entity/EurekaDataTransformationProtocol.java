package com.zzidc.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "eureka_datatransformation_protocol")
@Entity
public class EurekaDataTransformationProtocol implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7188608041023412093L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	private EurekaApi api;
	
	@Column
	private int status = 1;
	
	@Column
	private Timestamp createTime;
	
	@Column
	private Timestamp updateTime;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "protocol")
	private List<EurekaDataTransformationProtocolDetail> protocolDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EurekaApi getApi() {
		return api;
	}

	public void setApi(EurekaApi api) {
		this.api = api;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public List<EurekaDataTransformationProtocolDetail> getProtocolDetails() {
		return protocolDetails;
	}

	public void setProtocolDetails(List<EurekaDataTransformationProtocolDetail> protocolDetails) {
		this.protocolDetails = protocolDetails;
	}

	public EurekaDataTransformationProtocol(EurekaApi api, int status, Timestamp createTime, Timestamp updateTime,
			List<EurekaDataTransformationProtocolDetail> protocolDetails) {
		super();
		this.api = api;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.protocolDetails = protocolDetails;
	}

	public EurekaDataTransformationProtocol() {
		super();
	}

	@Override
	public String toString() {
		return "EurekaDataTransformationProtocol [id=" + id + ", api=" + api + ", status=" + status + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", protocolDetails=" + protocolDetails + "]";
	}
	
	
}
