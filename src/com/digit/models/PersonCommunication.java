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
@Table(name = "t_person_communication")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PersonCommunication {
	@Id
	@Column(name = "person_communication_id", nullable = false)
	private long personCommunicationId;
	@Column(name = "person_id", nullable = false)
	long personId;
	@Column(name = "communication_type", nullable = false)
	private long communicationType;
	@Column(name = "sub_type", nullable = false)
	private long subType;
	@Column(name = "communication_value", nullable = false)
	private String communicationValue;
	@Column(name = "active", nullable = false)
	private boolean active;
	@Column(name = "created_date", nullable = false)
	Timestamp createdDate;
	@Column(name = "created_user", nullable = false)
	private long createdUserId;
	@Column(name = "last_modified_date", nullable = false)
	Timestamp lastModifiedDate;
	@Column(name = "last_modified_user", nullable = false)
	private long lastModifiedUserId;
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

	public long getPersonCommunicationId() {
		return personCommunicationId;
	}

	public void setPersonCommunicationId(long personCommunicationId) {
		this.personCommunicationId = personCommunicationId;
	}

	 public long getPersonId() {
	 return personId;
	 }
	 public void setPersonId(long personId) {
	 this.personId = personId;
	 }
	public long getCommunicationType() {
		return communicationType;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setCommunicationType(long communicationType) {
		this.communicationType = communicationType;
	}

	public long getSubType() {
		return subType;
	}

	public void setSubType(long subType) {
		this.subType = subType;
	}

	public String getCommunicationValue() {
		return communicationValue;
	}

	public void setCommunicationValue(String communicationValue) {
		this.communicationValue = communicationValue;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
	 public void setCreatedUser(long createdUserId) {
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
	 public void setLastModifiedUser(long lastModifiedUserId) {
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
