package com.dgsoft.house.model;
// Generated Jul 12, 2013 11:32:23 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * HouseOwner generated by hbm2java
 */
@Entity
@Table(name = "HOUSE_OWNER", catalog = "HOUSE_INFO")
public class HouseOwner implements java.io.Serializable {

	private String id;
	private String credentialsNumber;
	private Integer credentialsType;
	private String name;
	private String personId;
	private Set<HouseContract> houseContracts = new HashSet<HouseContract>(0);
	private Set<House> housesForRecordId = new HashSet<House>(0);
	private Set<PoolOwner> poolOwners = new HashSet<PoolOwner>(0);
	private Set<House> housesForOwnerId = new HashSet<House>(0);
	private Set<ContractAttachOwner> contractAttachOwners = new HashSet<ContractAttachOwner>(
			0);

	public HouseOwner() {
	}

	public HouseOwner(String id) {
		this.id = id;
	}
	public HouseOwner(String id, String credentialsNumber,
			Integer credentialsType, String name, String personId,
			Set<HouseContract> houseContracts, Set<House> housesForRecordId,
			Set<PoolOwner> poolOwners, Set<House> housesForOwnerId,
			Set<ContractAttachOwner> contractAttachOwners) {
		this.id = id;
		this.credentialsNumber = credentialsNumber;
		this.credentialsType = credentialsType;
		this.name = name;
		this.personId = personId;
		this.houseContracts = houseContracts;
		this.housesForRecordId = housesForRecordId;
		this.poolOwners = poolOwners;
		this.housesForOwnerId = housesForOwnerId;
		this.contractAttachOwners = contractAttachOwners;
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

	@Column(name = "CREDENTIALS_NUMBER", length = 100)
	@Size(max = 100)
	public String getCredentialsNumber() {
		return this.credentialsNumber;
	}

	public void setCredentialsNumber(String credentialsNumber) {
		this.credentialsNumber = credentialsNumber;
	}

	@Column(name = "CREDENTIALS_TYPE")
	public Integer getCredentialsType() {
		return this.credentialsType;
	}

	public void setCredentialsType(Integer credentialsType) {
		this.credentialsType = credentialsType;
	}

	@Column(name = "NAME", length = 50)
	@Size(max = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PERSON_ID", length = 32)
	@Size(max = 32)
	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "houseOwner")
	public Set<HouseContract> getHouseContracts() {
		return this.houseContracts;
	}

	public void setHouseContracts(Set<HouseContract> houseContracts) {
		this.houseContracts = houseContracts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "houseOwnerByRecordId")
	public Set<House> getHousesForRecordId() {
		return this.housesForRecordId;
	}

	public void setHousesForRecordId(Set<House> housesForRecordId) {
		this.housesForRecordId = housesForRecordId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "houseOwner")
	public Set<PoolOwner> getPoolOwners() {
		return this.poolOwners;
	}

	public void setPoolOwners(Set<PoolOwner> poolOwners) {
		this.poolOwners = poolOwners;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "houseOwnerByOwnerId")
	public Set<House> getHousesForOwnerId() {
		return this.housesForOwnerId;
	}

	public void setHousesForOwnerId(Set<House> housesForOwnerId) {
		this.housesForOwnerId = housesForOwnerId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "houseOwner")
	public Set<ContractAttachOwner> getContractAttachOwners() {
		return this.contractAttachOwners;
	}

	public void setContractAttachOwners(
			Set<ContractAttachOwner> contractAttachOwners) {
		this.contractAttachOwners = contractAttachOwners;
	}

}