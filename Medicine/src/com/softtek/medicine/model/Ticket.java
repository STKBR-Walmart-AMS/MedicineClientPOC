package com.softtek.medicine.model;

import java.util.Date;

public class Ticket {

	
	private String incidentId;
	private Date createDate;
	private String priority;
	private String status;
	private Long acknowledgeSla;
	private Long resolutionSla;
	private Long acknowledge25Percent;
	private Long acknowledge50Percent;
	private Long resolution25Percent;
	private Long resolution50Percent;
	
	
	public Long getAcknowledge25Percent() {
		return acknowledge25Percent;
	}
	public void setAcknowledge25Percent(Long acknowledge25Percent) {
		this.acknowledge25Percent = acknowledge25Percent;
	}
	public Long getAcknowledge50Percent() {
		return acknowledge50Percent;
	}
	public void setAcknowledge50Percent(Long acknowledge50Percent) {
		this.acknowledge50Percent = acknowledge50Percent;
	}
	public Long getResolution25Percent() {
		return resolution25Percent;
	}
	public void setResolution25Percent(Long resolution25Percent) {
		this.resolution25Percent = resolution25Percent;
	}
	public Long getResolution50Percent() {
		return resolution50Percent;
	}
	public void setResolution50Percent(Long resolution50Percent) {
		this.resolution50Percent = resolution50Percent;
	}
	public Long getAcknowledgeSla() {
		return acknowledgeSla;
	}
	public void setAcknowledgeSla(Long acknowledgeSla) {
		this.acknowledgeSla = acknowledgeSla;
	}
	public Long getResolutionSla() {
		return resolutionSla;
	}
	public void setResolutionSla(Long resolutionSla) {
		this.resolutionSla = resolutionSla;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
	
	
}
