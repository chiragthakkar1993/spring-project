package com.digit.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.deser.std.TimestampDeserializer;

@Entity
@Table(name = "t_user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User {

	@Id
	@Column(name = "user_id", nullable = false)
	private long userId;
	@Column(name = "user_name", nullable = false)
	private String userName;
	@Column(name = "type", nullable = false)
	private long type;
	@Column(name = "login", nullable = false)
	private String login;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "api_key", nullable = false)
	private String apiKey;
	@Column(name = "active", nullable = false)
	private boolean active;
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date", nullable = false)
	private Date createdDate;
	@Column(name = "created_user", nullable = false)
	private long createdUserId;
	@Temporal(TemporalType.DATE)
	@Column(name = "last_modified_date", nullable = false)
	private Date lastModifiedDate;
	@Column(name = "last_modified_user", nullable = false)
	private long lastModifiedUserId;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lastModifiedUser")
	@JsonManagedReference
	private List<Activity> LastModifiedActivities;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "createdUser")
	@JsonManagedReference
	private List<Activity> CreatedActivities;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lastModifiedUser")
	@JsonManagedReference
	private List<ActivityAdditionalDetails> LastModifiedActivityAdditonalDetail;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "createdUser")
	@JsonManagedReference
	private List<ActivityAdditionalDetails> CreatedActivitiesAdditinalDetails;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lastModifiedUser")
	@JsonManagedReference
	private List<ActivityReceivedDetails> LastModifiedReceivedActivities;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "createdUser")
	@JsonManagedReference
	private List<ActivityReceivedDetails> CreatedReceivedActivities;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lastModifiedUser")
	@JsonManagedReference
	private List<ActivityStatusChange> LastModifiedStatusActivities;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "createdUser")
	@JsonManagedReference
	private List<ActivityStatusChange> CreatedStatusActivities;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lastModifiedUser")
	@JsonManagedReference
	private List<Person> LastModifiedPersons;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "createdUser")
	@JsonManagedReference
	private List<Person> CreatedPerons;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lastModifiedUser")
	@JsonManagedReference
	private List<PersonCommunication> LastModifiedPersonCommunications;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "createdUser")
	@JsonManagedReference
	private List<PersonCommunication> CreatedPersonCommunications;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lastModifiedUser")
	@JsonManagedReference
	private List<User> LastModifiedUserList;

	public List<User> getLastModifiedUserList() {
		return LastModifiedUserList;
	}

	public void setLastModifiedUserList(List<User> lastModifiedUserList) {
		LastModifiedUserList = lastModifiedUserList;
	}

	public List<User> getCreatedUserList() {
		return CreatedUserList;
	}

	public void setCreatedUserList(List<User> createdUserList) {
		CreatedUserList = createdUserList;
	}

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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "createdUser")
	@JsonManagedReference
	private List<User> CreatedUserList;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "last_modified_user", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	private User lastModifiedUser;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "created_user", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	private User createdUser;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<Activity> getLastModifiedActivities() {
		return LastModifiedActivities;
	}

	public void setLastModifiedActivities(List<Activity> lastModifiedActivities) {
		LastModifiedActivities = lastModifiedActivities;
	}

	public List<Activity> getCreatedActivities() {
		return CreatedActivities;
	}

	public void setCreatedActivities(List<Activity> createdActivities) {
		CreatedActivities = createdActivities;
	}

	public List<ActivityAdditionalDetails> getLastModifiedActivityAdditonalDetail() {
		return LastModifiedActivityAdditonalDetail;
	}

	public void setLastModifiedActivityAdditonalDetail(
			List<ActivityAdditionalDetails> lastModifiedActivityAdditonalDetail) {
		LastModifiedActivityAdditonalDetail = lastModifiedActivityAdditonalDetail;
	}

	public List<ActivityAdditionalDetails> getCreatedActivitiesAdditinalDetails() {
		return CreatedActivitiesAdditinalDetails;
	}

	public void setCreatedActivitiesAdditinalDetails(
			List<ActivityAdditionalDetails> createdActivitiesAdditinalDetails) {
		CreatedActivitiesAdditinalDetails = createdActivitiesAdditinalDetails;
	}

	public List<ActivityReceivedDetails> getLastModifiedReceivedActivities() {
		return LastModifiedReceivedActivities;
	}

	public void setLastModifiedReceivedActivities(List<ActivityReceivedDetails> lastModifiedReceivedActivities) {
		LastModifiedReceivedActivities = lastModifiedReceivedActivities;
	}

	public List<ActivityReceivedDetails> getCreatedReceivedActivities() {
		return CreatedReceivedActivities;
	}

	public void setCreatedReceivedActivities(List<ActivityReceivedDetails> createdReceivedActivities) {
		CreatedReceivedActivities = createdReceivedActivities;
	}

	public List<ActivityStatusChange> getLastModifiedStatusActivities() {
		return LastModifiedStatusActivities;
	}

	public void setLastModifiedStatusActivities(List<ActivityStatusChange> lastModifiedStatusActivities) {
		LastModifiedStatusActivities = lastModifiedStatusActivities;
	}

	public List<ActivityStatusChange> getCreatedStatusActivities() {
		return CreatedStatusActivities;
	}

	public void setCreatedStatusActivities(List<ActivityStatusChange> createdStatusActivities) {
		CreatedStatusActivities = createdStatusActivities;
	}

	public List<Person> getLastModifiedPersons() {
		return LastModifiedPersons;
	}

	public void setLastModifiedPersons(List<Person> lastModifiedPersons) {
		LastModifiedPersons = lastModifiedPersons;
	}

	public List<Person> getCreatedPerons() {
		return CreatedPerons;
	}

	public void setCreatedPerons(List<Person> createdPerons) {
		CreatedPerons = createdPerons;
	}

	public List<PersonCommunication> getLastModifiedPersonCommunications() {
		return LastModifiedPersonCommunications;
	}

	public void setLastModifiedPersonCommunications(List<PersonCommunication> lastModifiedPersonCommunications) {
		LastModifiedPersonCommunications = lastModifiedPersonCommunications;
	}

	public List<PersonCommunication> getCreatedPersonCommunications() {
		return CreatedPersonCommunications;
	}

	public void setCreatedPersonCommunications(List<PersonCommunication> createdPersonCommunications) {
		CreatedPersonCommunications = createdPersonCommunications;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public void setCreatedUserId(long createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Long getLastModifiedUserId() {
		return lastModifiedUserId;
	}

	public void setLastModifiedUserId(long lastModifiedUserId) {
		this.lastModifiedUserId = lastModifiedUserId;
	}

}
