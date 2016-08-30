package com.softtek.medicine.model;


import java.io.Serializable;
import java.util.Date;

public class CopyOfIncident implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5658712043010075352L;
	
	private String entryId; // 1
	private String submitter; // 2
	private Date submitDate; // 3
	
	/* mandatory fields */
	private Integer priority; // 1000000164
	private Integer impact; // 1000000163
	private Integer urgency; // 1000000162
	private String incidentNumber; //  1000000161
	private Integer serviceType; // 1000000099
	private String contactCompany; // 1000000082
	private String categorizationTier1; // 1000000063
	private String categorizationTier2; // 1000000064
	private String phoneNumber; // 1000000056
	private String firstName; // 1000000019
	private String lastName; // 1000000018
	private String description; // 1000000000
	private String ProductCategorizationTier1; // 200000003
	private String ProductCategorizationTier2; // 200000004
	private String productCategorizationTier3; // 200000005
	/* mandatory fields */

	private String assigneeLoginId; // 4
	private String lastModifiedBy; // 5
	private Date lastModifiedDate; // 6
	private Integer status; // 7
	private String shortDescription; // 8
	private String department; // 200000006
	private String siteGroup; // 200000007
	private String region; // 200000012
	private Integer escalated; // 250000023
	private String reasonCode; // 300270800
	private String reasonDescription; // 300270900
	private String returnCode; // 300271000
	private String assigneeId; // 300271200
	private String createdBy; // 300617700
	private Integer ticketType; // 301626500
	private String customer; // 303530000
	private String ci; // 303544200
	private String customerLoginID; // 304309540
	private String company; // 1000000001
	private String fullName; // 1000000017
	private Integer statusReason; // 1000000150
	private String detailedDescription; // 1000000151
	private String resolution; // 1000000156
	private String assignedGroup; // 1000000217
	private String assignee; // 1000000218
	private Date reportedDate; // 1000000560
	private Date respondedDate; // 1000000561
	private Date lastAcknowledgedDate; // 1000000562
	private Date lastResolvedDate; // 1000000563
	private Date closedDate; // 1000000564
	private Date reOpenedDate; // 1000000566
	private Integer category; // 1000000984
	private Date acknowledgmentStartDate; // 1000001317
	private Date resolutionStartDate; // 1000001319
	private Date requiredResolutionDateTime; // 1000005661
	private Date estimatedResolutionDate; // 1000005261
	private String attachment; // 1000005954
	private String text; // 1000005959	
	
	
	public String getEntryId() {
		return entryId;
	}
	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}
	public String getSubmitter() {
		return submitter;
	}
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getImpact() {
		return impact;
	}
	public void setImpact(Integer impact) {
		this.impact = impact;
	}
	public Integer getUrgency() {
		return urgency;
	}
	public void setUrgency(Integer urgency) {
		this.urgency = urgency;
	}
	public String getIncidentNumber() {
		return incidentNumber;
	}
	public void setIncidentNumber(String incidentNumber) {
		this.incidentNumber = incidentNumber;
	}
	public Integer getServiceType() {
		return serviceType;
	}
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}
	public String getContactCompany() {
		return contactCompany;
	}
	public void setContactCompany(String contactCompany) {
		this.contactCompany = contactCompany;
	}
	public String getCategorizationTier1() {
		return categorizationTier1;
	}
	public void setCategorizationTier1(String categorizationTier1) {
		this.categorizationTier1 = categorizationTier1;
	}
	public String getCategorizationTier2() {
		return categorizationTier2;
	}
	public void setCategorizationTier2(String categorizationTier2) {
		this.categorizationTier2 = categorizationTier2;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductCategorizationTier1() {
		return ProductCategorizationTier1;
	}
	public void setProductCategorizationTier1(String productCategorizationTier1) {
		ProductCategorizationTier1 = productCategorizationTier1;
	}
	public String getProductCategorizationTier2() {
		return ProductCategorizationTier2;
	}
	public void setProductCategorizationTier2(String productCategorizationTier2) {
		ProductCategorizationTier2 = productCategorizationTier2;
	}
	public String getProductCategorizationTier3() {
		return productCategorizationTier3;
	}
	public void setProductCategorizationTier3(String productCategorizationTier3) {
		this.productCategorizationTier3 = productCategorizationTier3;
	}
	public String getAssigneeLoginId() {
		return assigneeLoginId;
	}
	public void setAssigneeLoginId(String assigneeLoginId) {
		this.assigneeLoginId = assigneeLoginId;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSiteGroup() {
		return siteGroup;
	}
	public void setSiteGroup(String siteGroup) {
		this.siteGroup = siteGroup;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Integer getEscalated() {
		return escalated;
	}
	public void setEscalated(Integer escalated) {
		this.escalated = escalated;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getReasonDescription() {
		return reasonDescription;
	}
	public void setReasonDescription(String reasonDescription) {
		this.reasonDescription = reasonDescription;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getAssigneeId() {
		return assigneeId;
	}
	public void setAssigneeId(String assigneeId) {
		this.assigneeId = assigneeId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getTicketType() {
		return ticketType;
	}
	public void setTicketType(Integer ticketType) {
		this.ticketType = ticketType;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getCustomerLoginID() {
		return customerLoginID;
	}
	public void setCustomerLoginID(String customerLoginID) {
		this.customerLoginID = customerLoginID;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getStatusReason() {
		return statusReason;
	}
	public void setStatusReason(Integer statusReason) {
		this.statusReason = statusReason;
	}
	public String getDetailedDescription() {
		return detailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getAssignedGroup() {
		return assignedGroup;
	}
	public void setAssignedGroup(String assignedGroup) {
		this.assignedGroup = assignedGroup;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public Date getReportedDate() {
		return reportedDate;
	}
	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}
	public Date getRespondedDate() {
		return respondedDate;
	}
	public void setRespondedDate(Date respondedDate) {
		this.respondedDate = respondedDate;
	}
	public Date getLastAcknowledgedDate() {
		return lastAcknowledgedDate;
	}
	public void setLastAcknowledgedDate(Date lastAcknowledgedDate) {
		this.lastAcknowledgedDate = lastAcknowledgedDate;
	}
	public Date getLastResolvedDate() {
		return lastResolvedDate;
	}
	public void setLastResolvedDate(Date lastResolvedDate) {
		this.lastResolvedDate = lastResolvedDate;
	}
	public Date getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}
	public Date getReOpenedDate() {
		return reOpenedDate;
	}
	public void setReOpenedDate(Date reOpenedDate) {
		this.reOpenedDate = reOpenedDate;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Date getAcknowledgmentStartDate() {
		return acknowledgmentStartDate;
	}
	public void setAcknowledgmentStartDate(Date acknowledgmentStartDate) {
		this.acknowledgmentStartDate = acknowledgmentStartDate;
	}
	public Date getResolutionStartDate() {
		return resolutionStartDate;
	}
	public void setResolutionStartDate(Date resolutionStartDate) {
		this.resolutionStartDate = resolutionStartDate;
	}
	public Date getRequiredResolutionDateTime() {
		return requiredResolutionDateTime;
	}
	public void setRequiredResolutionDateTime(Date requiredResolutionDateTime) {
		this.requiredResolutionDateTime = requiredResolutionDateTime;
	}
	public Date getEstimatedResolutionDate() {
		return estimatedResolutionDate;
	}
	public void setEstimatedResolutionDate(Date estimatedResolutionDate) {
		this.estimatedResolutionDate = estimatedResolutionDate;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
