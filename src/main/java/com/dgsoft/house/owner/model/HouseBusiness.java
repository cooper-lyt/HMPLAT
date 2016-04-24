package com.dgsoft.house.owner.model;
// Generated Oct 11, 2014 3:13:15 PM by Hibernate Tools 4.0.0

import org.hibernate.annotations.GenericGenerator;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * BusinessHouse generated by hbm2java
 */
@Entity
@Table(name = "BUSINESS_HOUSE", catalog = "HOUSE_OWNER_RECORD")
public class HouseBusiness implements java.io.Serializable {

    private String id;
    private OwnerBusiness ownerBusiness;
    private BusinessHouse startBusinessHouse;
    private BusinessHouse afterBusinessHouse;
    private String houseCode;
    private Set<AddHouseStatus> addHouseStatuses = new HashSet<AddHouseStatus>(0);
    private Set<RecordStore> recordStores = new HashSet<RecordStore>(0);
    private boolean canceled;


    public HouseBusiness() {
    }

    public HouseBusiness(OwnerBusiness ownerBusiness) {
        this.ownerBusiness = ownerBusiness;
    }

    public HouseBusiness(OwnerBusiness ownerBusiness, BusinessHouse startBusinessHouse) {
        this.ownerBusiness = ownerBusiness;
        this.houseCode = startBusinessHouse.getHouseCode();
        this.startBusinessHouse = startBusinessHouse;
        this.afterBusinessHouse = new BusinessHouse(startBusinessHouse);

    }

    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BUSINESS_ID", nullable = false)
    @NotNull
    public OwnerBusiness getOwnerBusiness() {
        return this.ownerBusiness;
    }

    public void setOwnerBusiness(OwnerBusiness ownerBusiness) {
        this.ownerBusiness = ownerBusiness;
    }


    /*
     * 有中止的业务时 StartHouse 可能有多个 不可以@OneToOne
     *
     * @return
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "START_HOUSE", nullable = false)
    public BusinessHouse getStartBusinessHouse() {
        return startBusinessHouse;
    }

    public void setStartBusinessHouse(BusinessHouse startBusinessHouse) {
        this.startBusinessHouse = startBusinessHouse;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = true, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "AFTER_HOUSE", nullable = true)
    public BusinessHouse getAfterBusinessHouse() {
        return afterBusinessHouse;
    }

    public void setAfterBusinessHouse(BusinessHouse afterBusinessHouse) {
        this.afterBusinessHouse = afterBusinessHouse;
    }


    @Column(name = "HOUSE_CODE", nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    public String getHouseCode() {
        return this.houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "houseBusiness", cascade = CascadeType.ALL)
    public Set<AddHouseStatus> getAddHouseStatuses() {
        return addHouseStatuses;
    }

    public void setAddHouseStatuses(Set<AddHouseStatus> addHouseStatuses) {
        this.addHouseStatuses = addHouseStatuses;
    }

    @Column(name = "CANCELED", nullable = false)
    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }


    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "houseBusinesses")
    public Set<RecordStore> getRecordStores() {
        return recordStores;
    }

    public void setRecordStores(Set<RecordStore> recordStores) {
        this.recordStores = recordStores;
    }
}
