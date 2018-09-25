package com.zzidc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "eureka_parameter")
public class EurekaParameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7089324049668411841L;
	
	private int parameterId;
	private String parameterName;//名称
	private String parameterValue;//值
	private String remark;//备注描述
	private int parameterType;//0参数1返回值
	private int isNecessary;//1必须0非必须
	private int status;//1有效 0无效
	@ManyToOne(cascade = CascadeType.REMOVE)
	private EurekaApi api;
	
	
	
	public EurekaParameter(String parameterName, String parameterValue, String remark, int parameterType,
			int isNecessary, int status) {
		super();
		this.parameterName = parameterName;
		this.parameterValue = parameterValue;
		this.remark = remark;
		this.parameterType = parameterType;
		this.isNecessary = isNecessary;
		this.status = status;
	}
	
	
	public EurekaParameter() {
		super();
	}

	

	@Override
	public String toString() {
		return "EurekaParameter [parameterId=" + parameterId + ", parameterName=" + parameterName + ", parameterValue="
				+ parameterValue + ", remark=" + remark + ", parameterType=" + parameterType + ", isNecessary="
				+ isNecessary + ", status=" + status + "]";
	}


	public int getParameterId() {
		return parameterId;
	}
	public void setParameterId(int parameterId) {
		this.parameterId = parameterId;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public String getParameterValue() {
		return parameterValue;
	}
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getParameterType() {
		return parameterType;
	}
	public void setParameterType(int parameterType) {
		this.parameterType = parameterType;
	}
	public int getIsNecessary() {
		return isNecessary;
	}
	public void setIsNecessary(int isNecessary) {
		this.isNecessary = isNecessary;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
