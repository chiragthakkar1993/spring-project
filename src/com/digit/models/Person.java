package com.digit.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name = "t_person")
public class Person {

	@Id
	@Column(name = "person_id", nullable = false)
	long personId;
	@Column(name = "abs_person_id", nullable = false)
	long absPersonId;
	@Column(name = "last_name", nullable = false)
	String lastName;
	@Column(name = "first_name", nullable = false)
	String firstName;
	@Column(name = "created_date", nullable = false)
	Timestamp createdDate;
	@Column(name = "created_user", nullable = false)
	long createdUserId;
	@Column(name = "last_modified_date", nullable = false)
	Timestamp lastModifiedDate;
	@Column(name = "last_modified_user", nullable = false)
	long lastModifiedUserId;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
	@JsonManagedReference
	private List<Activity> activities;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
	@JsonManagedReference
	private List<PersonCommunication> personCommunications;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "last_modified_user", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	private User lastModifiedUser;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "created_user", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	private User createdUser;

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @PrimaryKeyJoinColumn List<PersonCommunication> communications=new
	 * ArrayList<PersonCommunication>();
	 * 
	 */ /*
		 * @OneToMany(cascade = CascadeType.ALL)
		 * 
		 * @JoinTable(name = "t_person_communication", joinColumns =
		 * { @JoinColumn(name = "person_id") }, inverseJoinColumns =
		 * { @JoinColumn(name = "person_communication_id") }) List<Activity>
		 * activities=new ArrayList<Activity>();
		 */

	public List<PersonCommunication> getPersonCommunications() {
		return personCommunications;
	}

	public void setPersonCommunications(List<PersonCommunication> personCommunications) {
		this.personCommunications = personCommunications;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public long getAbsPersonId() {
		return absPersonId;
	}

	public void setAbsPersonId(long absPersonId) {
		this.absPersonId = absPersonId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	/*
	 * public List<Activity> getActivities() { return activities; } public void
	 * setActivities(List<Activity> activities) { this.activities = activities;
	 * }
	 */
	/*
	 * public List<PersonCommunication> getCommunications() { return
	 * communications; } public void setCommunications(List<PersonCommunication>
	 * communications) { this.communications = communications;
	 * 
	 * }
	 *//*
		 * public String toString() {
		 * 
		 * return
		 * "[PersonId:\""+personId+"\",AbsPersonId"+absPersonId+",LastName:"+
		 * lastName+
		 * ",FirstName:"+firstName+",CreatedDate:"+createdDate+",CreatedUser:"+
		 * createdUser+",LastModifiedDate:"+lastModifiedDate+
		 * ",LastModifiedUser:"+lastModifiedUser+"]"; }
		 */

}
