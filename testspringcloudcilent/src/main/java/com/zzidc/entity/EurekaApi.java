package com.zzidc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zzidc.entity.jsonserializer.EurekaServiceProviderSerializer;
@Entity
@Table(name="eureka_api")
public class EurekaApi implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apiId;
	
	@JsonSerialize(using = EurekaServiceProviderSerializer.class )
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private EurekaServiceProvider service;
	
	@Column(name="acompany",length = 225 ,nullable = false)
	private String affiliatedCompany;
	
	@Column(name="entryName",length = 225 ,nullable = false)
	private String entryName;
	
	@Column(name="interfaceName",length = 225 ,nullable = false)
	private String interFaceName;
	
	@Column(length=225,nullable=false)
	private String apiUrl;
	
	@Column(name="requestMethod",length = 225 ,nullable = false)
	private String requestMethod;
	
	@Column(length=225,nullable=false)
	private String consumes;
	
	@Column(name="returnExplain",length = 225 ,nullable = false)
	private String returnExplain;	
	
	@Column(length=225,nullable=false)
	private String produces;
	
	@Column(length = 15)
	private String charset = "utf-8";
	
	@Column
	private int status = 1;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "api",cascade= CascadeType.ALL)
	private List<EurekaRequestrarameter> apr;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "api",cascade = CascadeType.ALL)
	private List<EurekaReturnparameter> returnParameter;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	@Column(name="creatTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creatTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	@Column(name="updateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "api",cascade = CascadeType.ALL)
	private List<EurekaDataTransformationProtocol> protocols;
	
	@JsonIgnore
	@OneToMany(mappedBy = "protocolApi",cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY)
	private List<EurekaDataTransformationProtocolDetail> protocolDetails;
	

	@Override
	public String toString() {
		return "EurekaApi [apiId=" + apiId + ", service="+service.getServiceId()+", affiliatedCompany=" + affiliatedCompany
				+ ", entryName=" + entryName + ", interFaceName=" + interFaceName + ", apiUrl=" + apiUrl
				+ ", requestMethod=" + requestMethod + ", consumes=" + consumes + ", returnExplain=" + returnExplain
				+ ", produces=" + produces + ", charset=" + charset + ", status=" + status + ", creatTime=" + creatTime
				+ ", updateTime=" + updateTime + "]";
	}

	public EurekaApi() {
		super();
	}

	public int getApiId() {
		return apiId;
	}

	public void setApiId(int apiId) {
		this.apiId = apiId;
	}

	public EurekaServiceProvider getService() {
		return service;
	}

	public void setService(EurekaServiceProvider service) {
		this.service = service;
	}

	public String getAffiliatedCompany() {
		return affiliatedCompany;
	}

	public void setAffiliatedCompany(String affiliatedCompany) {
		this.affiliatedCompany = affiliatedCompany;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public String getInterFaceName() {
		return interFaceName;
	}

	public void setInterFaceName(String interFaceName) {
		this.interFaceName = interFaceName;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getConsumes() {
		return consumes;
	}

	public void setConsumes(String consumes) {
		this.consumes = consumes;
	}

	public String getProduces() {
		return produces;
	}

	public void setProduces(String produces) {
		this.produces = produces;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<EurekaRequestrarameter> getApr() {
		return apr;
	}

	public void setApr(List<EurekaRequestrarameter> apr) {
		this.apr = apr;
	}


	public List<EurekaReturnparameter> getReturnParameter() {
		return returnParameter;
	}

	public void setReturnParameter(List<EurekaReturnparameter> returnParameter) {
		this.returnParameter = returnParameter;
	}

	public List<EurekaDataTransformationProtocol> getProtocols() {
		return protocols;
	}

	public void setProtocols(List<EurekaDataTransformationProtocol> protocols) {
		this.protocols = protocols;
	}

	public List<EurekaDataTransformationProtocolDetail> getProtocolDetails() {
		return protocolDetails;
	}

	public void setProtocolDetails(List<EurekaDataTransformationProtocolDetail> protocolDetails) {
		this.protocolDetails = protocolDetails;
	}

	public String getReturnExplain() {
		return returnExplain;
	}

	public void setReturnExplain(String returnExplain) {
		this.returnExplain = returnExplain;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public EurekaApi(EurekaServiceProvider service, String affiliatedCompany, String entryName, String interFaceName,
			String apiUrl, String requestMethod, String consumes, String returnExplain, String produces, String charset,
			int status, List<EurekaRequestrarameter> apr, List<EurekaReturnparameter> returnParameter, Date creatTime,
			Date updateTime, List<EurekaDataTransformationProtocol> protocols,
			List<EurekaDataTransformationProtocolDetail> protocolDetails) {
		super();
		this.service = service;
		this.affiliatedCompany = affiliatedCompany;
		this.entryName = entryName;
		this.interFaceName = interFaceName;
		this.apiUrl = apiUrl;
		this.requestMethod = requestMethod;
		this.consumes = consumes;
		this.returnExplain = returnExplain;
		this.produces = produces;
		this.charset = charset;
		this.status = status;
		this.apr = apr;
		this.returnParameter = returnParameter;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
		this.protocols = protocols;
		this.protocolDetails = protocolDetails;
	}





	
	
	
}
