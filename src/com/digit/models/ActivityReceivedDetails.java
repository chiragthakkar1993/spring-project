package com.digit.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "t_activity_received_details")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ActivityReceivedDetails {
	@Id
	@Column(name = "act_recd_details_id", nullable = false)
	long actRecdDetailsId;
	@Column(name = "activity_id", nullable = false)
	long activityId;
	@Column(name = "key", nullable = false)
	String key;
	@Column(name = "value", nullable = false)
	String value;
	@Column(name = "created_date", nullable = false)
	Timestamp createdDate;
	@Column(name = "created_user", nullable = false)
	long createdUserId;
	@Column(name = "last_modified_date", nullable = false)
	Timestamp lastModifiedDate;
	@Column(name = "last_modified_user", nullable = false)
	long lastModifiedUserId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "activity_id", referencedColumnName = "activity_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	private Activity activity;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "last_modified_user", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	private User lastModifiedUser;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "created_user", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	private User createdUser;

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public long getActRecdDetailsId() {
		return actRecdDetailsId;
	}

	public void setActRecdDetailsId(long actRecdDetailsId) {
		this.actRecdDetailsId = actRecdDetailsId;
	}

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public long getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(long createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public long getLastModifiedUserId() {
		return lastModifiedUserId;
	}

	public void setLastModifiedUserId(long lastModifiedUserId) {
		this.lastModifiedUserId = lastModifiedUserId;
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

}
