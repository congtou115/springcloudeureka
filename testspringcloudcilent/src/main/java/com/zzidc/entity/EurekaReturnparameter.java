package com.zzidc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="eureka_returnparameter")
public class EurekaReturnparameter implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rparnamesID",nullable=false)
	private Integer rparnamesID;
	
	@Column(name="rparameterName",length = 225 ,nullable = false)
	private String rparameterName;
	
	@Column(name="rparameterType",length = 225 ,nullable = false)
	private String rparameterType;
	
	@Column(name="rExplain",length = 225 ,nullable = false)
	private String rExplain;
	
	@ManyToOne(cascade = {CascadeType.REMOVE})
	private EurekaApi api;

	public Integer getRparnamesID() {
		return rparnamesID;
	}

	public void setRparnamesID(Integer rparnamesID) {
		this.rparnamesID = rparnamesID;
	}

	public String getRparameterName() {
		return rparameterName;
	}

	public void setRparameterName(String rparameterName) {
		this.rparameterName = rparameterName;
	}

	public String getRparameterType() {
		return rparameterType;
	}

	public void setRparameterType(String rparameterType) {
		this.rparameterType = rparameterType;
	}

	public String getrExplain() {
		return rExplain;
	}

	public void setrExplain(String rExplain) {
		this.rExplain = rExplain;
	}

	public EurekaApi getApi() {
		return api;
	}

	public void setApi(EurekaApi api) {
		this.api = api;
	}

	@Override
	public String toString() {
		return "EurekaReturnparameter [rparnamesID=" + rparnamesID + ", rparameterName=" + rparameterName
				+ ", rparameterType=" + rparameterType + ", rExplain=" + rExplain + ", api=" + api + "]";
	}

	public EurekaReturnparameter(Integer rparnamesID, String rparameterName, String rparameterType, String rExplain,
			EurekaApi api) {
		super();
		this.rparnamesID = rparnamesID;
		this.rparameterName = rparameterName;
		this.rparameterType = rparameterType;
		this.rExplain = rExplain;
		this.api = api;
	}
	
	
}
