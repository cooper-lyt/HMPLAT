package com.dgsoft.house.owner.model;
// Generated Oct 11, 2014 3:13:15 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * HouseRecord generated by hbm2java
 */
@Entity
@Table(name = "HOUSE_RECORD", catalog = "HOUSE_OWNER_RECORD", uniqueConstraints = {
		@UniqueConstraint(columnNames = "HOUSE_CODE"),
		@UniqueConstraint(columnNames = "HOUSE")})
public class HouseRecord implements java.io.Serializable {

	private String id;
	private BusinessHouse businessHouse;
	private LandInfo landInfo;
	private BusinessHouseOwner businessHouseOwner;
	private String houseCode;
	private Set<MakeCard> recordAndCards = new HashSet<MakeCard>(0);
	private Set<RecordStore> recordStores = new HashSet<RecordStore>(0);
	private Set<BusinessPool> recordAndPoolowners = new HashSet<BusinessPool>(0);
    private OwnerBusiness lastBusiness;

	public HouseRecord() {
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
	@JoinColumn(name = "HOUSE", unique = true, nullable = false)
	@NotNull
	public BusinessHouse getBusinessHouse() {
		return this.businessHouse;
	}

	public void setBusinessHouse(BusinessHouse businessHouse) {
		this.businessHouse = businessHouse;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LAND_INFO")
	public LandInfo getLandInfo() {
		return this.landInfo;
	}

	public void setLandInfo(LandInfo landInfo) {
		this.landInfo = landInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MASTER_OWNER")
	public BusinessHouseOwner getBusinessHouseOwner() {
		return this.businessHouseOwner;
	}

	public void setBusinessHouseOwner(BusinessHouseOwner businessHouseOwner) {
		this.businessHouseOwner = businessHouseOwner;
	}

	@Column(name = "HOUSE_CODE", unique = true, nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getHouseCode() {
		return this.houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "houseRecord")
	public Set<RecordStore> getRecordStores() {
		return this.recordStores;
	}

	public void setRecordStores(Set<RecordStore> recordStores) {
		this.recordStores = recordStores;
	}


    @ManyToMany(fetch = FetchType.LAZY, targetEntity = MakeCard.class)
    @JoinTable(name = "RECORD_AND_CARD", joinColumns = @JoinColumn(name = "RECORD"), inverseJoinColumns = @JoinColumn(name = "CARD"))
    public Set<MakeCard> getRecordAndCards() {
        return recordAndCards;
    }

    public void setRecordAndCards(Set<MakeCard> recordAndCards) {
        this.recordAndCards = recordAndCards;
    }

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = BusinessPool.class)
    @JoinTable(name = "RECORD_AND_POOLOWNER", joinColumns = @JoinColumn(name = "RECORD_ID"), inverseJoinColumns = @JoinColumn(name = "POOL_OWNER"))
    public Set<BusinessPool> getRecordAndPoolowners() {
        return recordAndPoolowners;
    }

    public void setRecordAndPoolowners(Set<BusinessPool> recordAndPoolowners) {
        this.recordAndPoolowners = recordAndPoolowners;
    }

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "LAST_BUSINESS",nullable = false)
    @NotNull
    public OwnerBusiness getLastBusiness() {
        return lastBusiness;
    }

    public void setLastBusiness(OwnerBusiness lastBusiness) {
        this.lastBusiness = lastBusiness;
    }
}
