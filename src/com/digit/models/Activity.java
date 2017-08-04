package com.digit.models;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@Table(name = "t_activity")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Activity {
	@Id
	@Column(name = "activity_id", nullable = false)
	private long activityID;
	@Temporal(TemporalType.DATE)
	@Column(name = "activity_date", nullable = false)
	private Date activityDate;
	@Column(name = "agent_id", nullable = false)
	private long agentId;
	@Column(name = "product_id", nullable = false)
	private long productId;
	@Column(name = "activity_type_id", nullable = false)
	private long activityTypeId;
	@Column(name = "policy_number", nullable = false)
	private String policyNumber;
	@Column(name = "claim_number", nullable = false)
	private String claimNumber;
	@Column(name = "person_id", nullable = false)
	private long personId;
	@Column(name = "version_number", nullable = false)
	private long versionNumber;
	@Column(name = "status", nullable = false)
	private long status;
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@Column(name = "last_modified_user", nullable = false)
	private long lastModifiedUserId;

	public long getLastModifiedUserId() {
		return lastModifiedUserId;
	}

	public void setLastModifiedUserId(long lastModifiedUserId) {
		this.lastModifiedUserId = lastModifiedUserId;
	}

	public void setCreatedUserId(long createdUserId) {
		this.createdUserId = createdUserId;
	}

	@Column(name = "created_user", nullable = false)
	private long createdUserId;

	@Temporal(TemporalType.DATE)
	@Column(name = "last_modified_date", nullable = false)
	private Date lastModifiedDate;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "activity")
	@JsonManagedReference
	private List<ActivityAdditionalDetails> additionalActivitiesList;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "activity")
	@JsonManagedReference
	private List<ActivityReceivedDetails> receivedActivities;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "activity")
	@JsonManagedReference
	private List<ActivityStatusChange> statusActivities;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	private Person person;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "last_modified_user", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	private User lastModifiedUser;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "created_user", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	private User createdUser;

	public User getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(User lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}

	public List<ActivityReceivedDetails> getReceivedActivities() {
		return receivedActivities;
	}

	public void setReceivedActivities(List<ActivityReceivedDetails> receivedActivities) {
		this.receivedActivities = receivedActivities;
	}

	public List<ActivityStatusChange> getStatusActivities() {
		return statusActivities;
	}

	public void setStatusActivities(List<ActivityStatusChange> statusActivities) {
		this.statusActivities = statusActivities;
	}

	/*
	 * List<ActivityAdditionalDetails> activityAdditionalDetails=new
	 * ArrayList<ActivityAdditionalDetails>(); List<ActivityReceivedDetails>
	 * activityReceivedDetails=new ArrayList<ActivityReceivedDetails>();
	 * List<ActivityStatusChange> activityStatusChanges=new
	 * ArrayList<ActivityStatusChange>();
	 */

	public Person getPerson() {
		return person;
	}

	public List<ActivityAdditionalDetails> getAdditionalActivitiesList() {
		return additionalActivitiesList;
	}

	public void setAdditionalActivitiesList(List<ActivityAdditionalDetails> additionalActivitiesList) {
		this.additionalActivitiesList = additionalActivitiesList;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getActivityID() {
		return activityID;
	}

	public void setActivityID(long activityID) {
		this.activityID = activityID;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getActivityTypeId() {
		return activityTypeId;
	}

	public void setActivityTypeId(long activityTypeId) {
		this.activityTypeId = activityTypeId;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long person) {
		this.personId = person;
	}

	public long getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(long versionNumber) {
		this.versionNumber = versionNumber;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUser(long createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public long getAgentId() {
		return agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "t_activity", joinColumns = { @JoinColumn(name =
	 * "activity_id") }, inverseJoinColumns = { @JoinColumn(name =
	 * "act_add_details_id") }) public List<ActivityAdditionalDetails>
	 * getActivityAdditionalDetails() { return activityAdditionalDetails; }
	 * public void setActivityAdditionalDetails(List<ActivityAdditionalDetails>
	 * activityAdditionalDetails) { this.activityAdditionalDetails =
	 * activityAdditionalDetails; }
	 * 
	 * 
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "t_activity", joinColumns = { @JoinColumn(name =
	 * "activity_id") }, inverseJoinColumns = { @JoinColumn(name =
	 * "act_recd_details_id") }) public List<ActivityReceivedDetails>
	 * getActivityReceivedDetails() { return activityReceivedDetails; } public
	 * void setActivityReceivedDetails(List<ActivityReceivedDetails>
	 * activityReceivedDetails) { this.activityReceivedDetails =
	 * activityReceivedDetails; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "t_activity", joinColumns = { @JoinColumn(name =
	 * "activity_id") }, inverseJoinColumns = { @JoinColumn(name =
	 * "act_status_change_id") }) public List<ActivityStatusChange>
	 * getActivityStatusChanges() { return activityStatusChanges; } public void
	 * setActivityStatusChanges(List<ActivityStatusChange>
	 * activityStatusChanges) { this.activityStatusChanges =
	 * activityStatusChanges; }
	 */
}
