package com.zzidc.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eureka_operation_log")
public class EurekaOperationLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8742011155496755721L;

	@Id
	@Column(name = "log_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long logId; 
	
	@Column(name = "operation_userId")
	private int operationUserId;
	
	@Column(name = "create_time")
	private Timestamp createTime;
	
	@Column(name = "operation_type")
	private int operationType;
	
	@Column(name = "operation_detail",length = 500)
	private String operationDetail;
	
	@Column(name = "operation_ip",length = 16)
	private String operationIp;
	
	@Column(name = "operation_result")
	private String operationResult;
	
	@Column(name = "param_detail",length = 500)
	private String paramDetail;
	
	@Column(name = "failure_reason",length = 200)
	private String failureReason;

	@Override
	public String toString() {
		return "EurekaOperationLog [logId=" + logId + ", operationUserId=" + operationUserId + ", createTime="
				+ createTime + ", operationType=" + operationType + ", operationDetail=" + operationDetail
				+ ", operationIp=" + operationIp + ", operationResult=" + operationResult + ", paramDetail="
				+ paramDetail + ", failureReason=" + failureReason + "]";
	}

	public EurekaOperationLog(int operationUserId, Timestamp createTime, int operationType, String operationDetail,
			String operationIp, String operationResult, String paramDetail, String failureReason) {
		super();
		this.operationUserId = operationUserId;
		this.createTime = createTime;
		this.operationType = operationType;
		this.operationDetail = operationDetail;
		this.operationIp = operationIp;
		this.operationResult = operationResult;
		this.paramDetail = paramDetail;
		this.failureReason = failureReason;
	}

	public EurekaOperationLog() {
		super();
	}

	public long getLogId() {
		return logId;
	}

	public void setLogId(long logId) {
		this.logId = logId;
	}

	public int getOperationUserId() {
		return operationUserId;
	}

	public void setOperationUserId(int operationUserId) {
		this.operationUserId = operationUserId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getOperationType() {
		return operationType;
	}

	public void setOperationType(int operationType) {
		this.operationType = operationType;
	}

	public String getOperationDetail() {
		return operationDetail;
	}

	public void setOperationDetail(String operationDetail) {
		this.operationDetail = operationDetail;
	}

	public String getOperationIp() {
		return operationIp;
	}

	public void setOperationIp(String operationIp) {
		this.operationIp = operationIp;
	}

	public String getOperationResult() {
		return operationResult;
	}

	public void setOperationResult(String operationResult) {
		this.operationResult = operationResult;
	}

	public String getParamDetail() {
		return paramDetail;
	}

	public void setParamDetail(String paramDetail) {
		this.paramDetail = paramDetail;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}
	
	
}
