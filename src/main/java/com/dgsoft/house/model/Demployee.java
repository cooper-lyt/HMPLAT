package com.dgsoft.house.model;
// Generated Jul 12, 2013 11:32:23 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Demployee generated by hbm2java
 */
@Entity
@Table(name = "DEMPLOYEE", catalog = "HOUSE_INFO")
public class Demployee implements java.io.Serializable {

	private String id;
	private Developer developer;
	private AttachEmployee attachEmployee;
	private String memo;
	private Set<NewHouseContract> newHouseContracts = new HashSet<NewHouseContract>(
			0);

	public Demployee() {
	}

	public Demployee(String id, Developer developer,
			AttachEmployee attachEmployee) {
		this.id = id;
		this.developer = developer;
		this.attachEmployee = attachEmployee;
	}
	public Demployee(String id, Developer developer,
			AttachEmployee attachEmployee, String memo,
			Set<NewHouseContract> newHouseContracts) {
		this.id = id;
		this.developer = developer;
		this.attachEmployee = attachEmployee;
		this.memo = memo;
		this.newHouseContracts = newHouseContracts;
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
	@JoinColumn(name = "DEVELOPER", nullable = false)
	@NotNull
	public Developer getDeveloper() {
		return this.developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ATTACH_EMPLOYEE_ID", nullable = false)
	@NotNull
	public AttachEmployee getAttachEmployee() {
		return this.attachEmployee;
	}

	public void setAttachEmployee(AttachEmployee attachEmployee) {
		this.attachEmployee = attachEmployee;
	}

	@Column(name = "MEMO", length = 200)
	@Size(max = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "demployee")
	public Set<NewHouseContract> getNewHouseContracts() {
		return this.newHouseContracts;
	}

	public void setNewHouseContracts(Set<NewHouseContract> newHouseContracts) {
		this.newHouseContracts = newHouseContracts;
	}

}