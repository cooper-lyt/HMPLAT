package com.dgsoft.house.model;
// Generated Jul 12, 2013 11:32:23 AM by Hibernate Tools 4.0.0

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * PoolBuild generated by hbm2java
 */
@Entity
@Table(name = "POOL_BUILD", catalog = "HOUSE_INFO")
public class PoolBuild implements java.io.Serializable {

	private String id;
	private String mapNumber;
	private String blockNo;
	private String buildNo;
	private String houseNumber;
	private String buildName;
	private String structure;
	private String address;
	private BigDecimal area;
	private String memo;
    private Date regTime;
    private int floorCount;
    private Section section;

	public PoolBuild() {
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 32)
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@NotNull
	@Size(max = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "SECTION_ID", nullable = false)
    @NotNull
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Column(name = "MAP_NUMBER", length = 50,nullable = false)
	@Size(max = 50)
    @NotNull
	public String getMapNumber() {
		return this.mapNumber;
	}

	public void setMapNumber(String mapNumber) {
		this.mapNumber = mapNumber;
	}

	@Column(name = "BLOCK_NO", length = 50,nullable = false)
	@Size(max = 50)
    @NotNull
	public String getBlockNo() {
		return this.blockNo;
	}

	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	@Column(name = "BUILD_NO", length = 50,nullable = false)
	@Size(max = 50)
    @NotNull
	public String getBuildNo() {
		return this.buildNo;
	}

	public void setBuildNo(String buildNo) {
		this.buildNo = buildNo;
	}

	@Column(name = "HOUSE_NUMBER", length = 50,nullable = false)
	@Size(max = 50)
    @NotNull
	public String getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	@Column(name = "BUILD_NAME", length = 50,nullable = false)
	@Size(max = 50)
    @NotNull
	public String getBuildName() {
		return this.buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	@Column(name = "STRUCTURE", length = 32, nullable = false)
	@Size(max = 32)
    @NotNull
	public String getStructure() {
		return this.structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	@Column(name = "ADDRESS", length = 200)
	@Size(max = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "AREA", precision = 18, scale = 3,nullable = false)
    @NotNull
	public BigDecimal getArea() {
		return this.area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	@Column(name = "MEMO", length = 200)
	@Size(max = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REG_TIME",length = 19)
    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    @Column(name = "FLOOR_COUNT",nullable = false)
    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }


}
