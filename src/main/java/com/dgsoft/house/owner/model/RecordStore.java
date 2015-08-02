package com.dgsoft.house.owner.model;
// Generated Oct 11, 2014 3:13:15 PM by Hibernate Tools 4.0.0

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * RecordStore generated by hbm2java
 */
@Entity
@Table(name = "RECORD_STORE", catalog = "HOUSE_OWNER_RECORD")
public class RecordStore implements java.io.Serializable {

    private String id;
    private HouseBusiness houseBusiness;
    private HouseRecord houseRecord;
    private String frame;
    private String cabinet;
    private String box;
    private String recordCode;

    public RecordStore() {
    }

    public RecordStore(String id, HouseBusiness houseBusiness){
        this.houseBusiness = houseBusiness;
        this.id = id;
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
    @JoinColumn(name = "BUSINESS_HOUSE", nullable = false)
    @NotNull
    public HouseBusiness getHouseBusiness() {
        return this.houseBusiness;
    }

    public void setHouseBusiness(HouseBusiness houseBusiness) {
        this.houseBusiness = houseBusiness;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "HOUSE_CODE", nullable = false)
    @NotNull
    public HouseRecord getHouseRecord() {
        return this.houseRecord;
    }

    public void setHouseRecord(HouseRecord houseRecord) {
        this.houseRecord = houseRecord;
    }

    @Column(name = "FRAME", nullable = true, length = 10)
    @Size(max = 10)
    public String getFrame() {
        return this.frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    @Column(name = "CABINET", nullable = true, length = 20)
    @Size(max = 20)
    public String getCabinet() {
        return this.cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    @Column(name = "BOX", nullable = true, length = 50)
    @Size(max = 50)
    public String getBox() {
        return this.box;
    }

    public void setBox(String box) {
        this.box = box;
    }



    @Column(name = "RECORD_CODE", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }


}
