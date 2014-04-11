package com.dgsoft.common.system.model;
// Generated May 7, 2013 11:49:56 AM by Hibernate Tools 4.0.0

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * BusinessTask generated by hbm2java
 */
@Entity
@Table(name = "BUSINESS_TASK", catalog = "DG_SYSTEM")
public class BusinessTask implements java.io.Serializable {

	private String id;
	private Employee employee;
	private BusinessInstance businessInstance;
	private Date beginTime;
	private Date completeTime;
	private String stage;
	private String stageId;
	private boolean fallbackOper;
	private boolean errorOper;

	public BusinessTask() {
	}

	public BusinessTask(String id, Employee employee,
			BusinessInstance businessInstance, Date beginTime,
			Date completeTime, String stage, String stageId,
			boolean fallbackOper, boolean errorOper) {
		this.id = id;
		this.employee = employee;
		this.businessInstance = businessInstance;
		this.beginTime = beginTime;
		this.completeTime = completeTime;
		this.stage = stage;
		this.stageId = stageId;
		this.fallbackOper = fallbackOper;
		this.errorOper = errorOper;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID", nullable = false)
	@NotNull
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUSSINESS_INSTNACE_ID", nullable = false)
	@NotNull
	public BusinessInstance getBusinessInstance() {
		return this.businessInstance;
	}

	public void setBusinessInstance(BusinessInstance businessInstance) {
		this.businessInstance = businessInstance;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BEGIN_TIME", nullable = false, length = 19, columnDefinition = "DATETIME")
	@NotNull
	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMPLETE_TIME", nullable = false, length = 19,columnDefinition = "DATETIME")
	@NotNull
	public Date getCompleteTime() {
		return this.completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	@Column(name = "STAGE", nullable = false, length = 100)
	@NotNull
	@Size(max = 100)
	public String getStage() {
		return this.stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	@Column(name = "STAGE_ID", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getStageId() {
		return this.stageId;
	}

	public void setStageId(String stageId) {
		this.stageId = stageId;
	}

	@Column(name = "FALLBACK_OPER", nullable = false)
	public boolean isFallbackOper() {
		return this.fallbackOper;
	}

	public void setFallbackOper(boolean fallbackOper) {
		this.fallbackOper = fallbackOper;
	}

	@Column(name = "ERROR_OPER", nullable = false)
	public boolean isErrorOper() {
		return this.errorOper;
	}

	public void setErrorOper(boolean errorOper) {
		this.errorOper = errorOper;
	}

}
