package com.dgsoft.house.owner.model;
// Generated Oct 11, 2014 3:13:15 PM by Hibernate Tools 4.0.0

import com.dgsoft.house.BuildInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Build generated by hbm2java
 */
@Entity
@Table(name = "BUILD", catalog = "HOUSE_OWNER_RECORD")
public class BusinessBuild implements java.io.Serializable, BuildInfo {

	private String id;
	private BusinessProject businessProject;
	private String mapNumber;
	private String blockNo;
	private String buildNo;
	private String buildCode;
	private String streetCode;
	private String name;
	private String doorNo;
	private Integer unintCount;
	private int floorCount;
	private int upFloorCount;
	private int downFloorCount;
	private String address;
	private Integer houseCount;
	private BigDecimal area;
	private String buildType;
	private String structure;
	private Integer homeCount;
	private BigDecimal homeArea;
	private Integer unhomeCount;
	private BigDecimal unhomeArea;
	private Integer shopCount;
	private BigDecimal shopArea;
	private String completeYear;
    private String buildDevNumber;
    private Set<ProjectExceptHouse> projectExceptHouses = new HashSet<ProjectExceptHouse>(0);

	public BusinessBuild() {
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
	@JoinColumn(name = "PROJECT", nullable = false)
	@NotNull
	public BusinessProject getBusinessProject() {
		return this.businessProject;
	}

	public void setBusinessProject(BusinessProject businessProject) {
		this.businessProject = businessProject;
	}

	@Column(name = "MAP_NUMBER", length = 4)
	@Size(max = 4)
	public String getMapNumber() {
		return this.mapNumber;
	}

	public void setMapNumber(String mapNumber) {
		this.mapNumber = mapNumber;
	}

	@Column(name = "BLOCK_NO", nullable = false, length = 10)
	@NotNull
	@Size(max = 10)
	public String getBlockNo() {
		return this.blockNo;
	}

	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	@Column(name = "BUILD_NO", nullable = false, length = 4)
	@NotNull
	@Size(max = 4)
	public String getBuildNo() {
		return this.buildNo;
	}

	public void setBuildNo(String buildNo) {
		this.buildNo = buildNo;
	}

    @Override
    @Transient
    public String getBuildName() {
        return getName();
    }

    @Column(name = "BUILD_CODE", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getBuildCode() {
		return this.buildCode;
	}

	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode;
	}

	@Column(name = "STREET_CODE", length = 4)
	@Size(max = 4)
	public String getStreetCode() {
		return this.streetCode;
	}

	public void setStreetCode(String streetCode) {
		this.streetCode = streetCode;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	@NotNull
	@Size(max = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DOOR_NO", length = 10)
	@Size(max = 10)
	public String getDoorNo() {
		return this.doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	@Column(name = "UNINT_COUNT")
	public Integer getUnintCount() {
		return this.unintCount;
	}

	public void setUnintCount(Integer unintCount) {
		this.unintCount = unintCount;
	}

	@Column(name = "FLOOR_COUNT", nullable = false)
	public int getFloorCount() {
		return this.floorCount;
	}

	public void setFloorCount(int floorCount) {
		this.floorCount = floorCount;
	}

	@Column(name = "UP_FLOOR_COUNT", nullable = false)
	public int getUpFloorCount() {
		return this.upFloorCount;
	}

	public void setUpFloorCount(int upFloorCount) {
		this.upFloorCount = upFloorCount;
	}

	@Column(name = "DOWN_FLOOR_COUNT", nullable = false)
	public int getDownFloorCount() {
		return this.downFloorCount;
	}

	public void setDownFloorCount(int downFloorCount) {
		this.downFloorCount = downFloorCount;
	}

	@Column(name = "ADDRESS", length = 50)
	@Size(max = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "HOUSE_COUNT")
	public Integer getHouseCount() {
		return this.houseCount;
	}

	public void setHouseCount(Integer houseCount) {
		this.houseCount = houseCount;
	}

	@Column(name = "AREA", precision = 18, scale = 3)
	public BigDecimal getArea() {
		return this.area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}


	@Column(name = "BUILD_TYPE", length = 32)
	@Size(max = 32)
	public String getBuildType() {
		return this.buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	@Column(name = "STRUCTURE", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getStructure() {
		return this.structure;
	}

    @Override
    @Column(name = "BUILD_DEVELOPER_NUMBER",length = 20, nullable = true)
    @Size(max = 20)
    public String getBuildDevNumber() {
        return this.buildDevNumber;
    }

    public void setBuildDevNumber(String number){
        this.buildDevNumber = number;
    }

    public void setStructure(String structure) {
		this.structure = structure;
	}

	@Column(name = "HOME_COUNT")
	public Integer getHomeCount() {
		return this.homeCount;
	}

	public void setHomeCount(Integer homeCount) {
		this.homeCount = homeCount;
	}

	@Column(name = "HOME_AREA", precision = 18, scale = 3)
	public BigDecimal getHomeArea() {
		return this.homeArea;
	}

	public void setHomeArea(BigDecimal homeArea) {
		this.homeArea = homeArea;
	}

	@Column(name = "UNHOME_COUNT")
	public Integer getUnhomeCount() {
		return this.unhomeCount;
	}

	public void setUnhomeCount(Integer unhomeCount) {
		this.unhomeCount = unhomeCount;
	}

	@Column(name = "UNHOME_AREA", precision = 18, scale = 3)
	public BigDecimal getUnhomeArea() {
		return this.unhomeArea;
	}

	public void setUnhomeArea(BigDecimal unhomeArea) {
		this.unhomeArea = unhomeArea;
	}

	@Column(name = "SHOP_COUNT")
	public Integer getShopCount() {
		return this.shopCount;
	}

	public void setShopCount(Integer shopCount) {
		this.shopCount = shopCount;
	}

	@Column(name = "SHOP_AREA", precision = 18, scale = 3)
	public BigDecimal getShopArea() {
		return this.shopArea;
	}

	public void setShopArea(BigDecimal shopArea) {
		this.shopArea = shopArea;
	}

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "businessBuild")
    public Set<ProjectExceptHouse> getProjectExceptHouses() {
        return projectExceptHouses;
    }

    public void setProjectExceptHouses(Set<ProjectExceptHouse> projectExceptHouses) {
        this.projectExceptHouses = projectExceptHouses;
    }

    @Override
    @Transient
    public String getDeveloperName() {
        return getBusinessProject().getDeveloperName();
    }

    @Override
    @Transient
    public String getDeveloperCode() {
        return getBusinessProject().getDeveloperCode();
    }

    @Override
    @Transient
    public String getProjectName() {
        return getBusinessProject().getProjectName();
    }

    @Override
    @Transient
    public String getProjectCode() {
        return getBusinessProject().getProjectCode();
    }


    @Column(name = "COMPLETE_DATE", length = 6)
	@Size(max = 6)
	public String getCompleteYear() {
		return this.completeYear;
	}

    public void setCompleteYear(String completeDate) {
		this.completeYear = completeDate;
	}

    @Override
    @Transient
    public String getDistrictName() {
        return getBusinessProject().getDistrictName();
    }

    @Override
    @Transient
    public String getDistrictCode() {
        return getBusinessProject().getDistrictCode();
    }

    @Override
    @Transient
    public String getSectionName() {
        return getBusinessProject().getSectionName();
    }

    @Override
    @Transient
    public String getSectionCode() {
        return getBusinessProject().getSectionCode();
    }
}
