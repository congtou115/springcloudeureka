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
@Entity
@Table(name="eureka_api")
public class EurekaApi implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apiId;
	
	@ManyToOne(cascade = {CascadeType.REMOVE})
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
	
	@Column(name="returnExample",length = 225 ,nullable = false)
	private String returnExample;	
	
	@Column(length=225,nullable=false)
	private String produces;
	
	@Column(length = 15)
	private String charset = "utf-8";
	
	@OneToMany(mappedBy = "api")
	private List<EurekaParameter> parameters ;
	
	@Column
	private int status = 1;
	
	@OneToMany(mappedBy = "api",cascade= {CascadeType.REMOVE})
	private List<EurekaRequestrarameter> apr;
	
	@Column(name="creationTime")
	@Temporal(TemporalType.TIME)
	private Date creationTime;
	
	@Column(name="modifiedTime")
	@Temporal(TemporalType.TIME)
	private Date modifiedTime;

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

	public String getReturnExample() {
		return returnExample;
	}

	public void setReturnExample(String returnExample) {
		this.returnExample = returnExample;
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

	public List<EurekaParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<EurekaParameter> parameters) {
		this.parameters = parameters;
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

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public EurekaApi(int apiId, EurekaServiceProvider service, String affiliatedCompany, String entryName,
			String interFaceName, String apiUrl, String requestMethod, String consumes, String returnExample,
			String produces, String charset, List<EurekaParameter> parameters, int status,
			List<EurekaRequestrarameter> apr, Date creationTime, Date modifiedTime) {
		super();
		this.apiId = apiId;
		this.service = service;
		this.affiliatedCompany = affiliatedCompany;
		this.entryName = entryName;
		this.interFaceName = interFaceName;
		this.apiUrl = apiUrl;
		this.requestMethod = requestMethod;
		this.consumes = consumes;
		this.returnExample = returnExample;
		this.produces = produces;
		this.charset = charset;
		this.parameters = parameters;
		this.status = status;
		this.apr = apr;
		this.creationTime = creationTime;
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "EurekaApi [apiId=" + apiId + ", service=" + service + ", affiliatedCompany=" + affiliatedCompany
				+ ", entryName=" + entryName + ", interFaceName=" + interFaceName + ", apiUrl=" + apiUrl
				+ ", requestMethod=" + requestMethod + ", consumes=" + consumes + ", returnExample=" + returnExample
				+ ", produces=" + produces + ", charset=" + charset + ", parameters=" + parameters + ", status="
				+ status + ", apr=" + apr + ", creationTime=" + creationTime + ", modifiedTime=" + modifiedTime + "]";
	}

	
	
	
}
