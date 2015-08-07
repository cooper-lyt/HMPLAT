package com.dgsoft.house.model;
// Generated Jul 12, 2013 11:32:23 AM by Hibernate Tools 4.0.0

import com.dgsoft.common.utils.persistence.UniqueVerify;
import com.dgsoft.house.BuildInfo;
import org.jboss.seam.international.StatusMessage;

import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;
import javax.swing.tree.TreeNode;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Build generated by hbm2java
 */
@Entity
@Table(name = "BUILD", catalog = "HOUSE_INFO",uniqueConstraints = {@UniqueConstraint(columnNames = {"MAP_NUMBER","BLOCK_NO", "BUILD_NO"})})
@UniqueVerify(name = "name", severity = StatusMessage.Severity.ERROR, field = {"name"})
public class Build implements java.io.Serializable,TreeNode, BuildInfo {

	private String id;
	private Integer version;


	private String mapNumber;
	private String blockNo;
	private String buildNo;
    private String completeYear;
    private String streetCode;
	private String name;
	private String doorNo;
	private Integer unintCount;
    private String devBuildNumber;

	private Integer houseCount;
	private BigDecimal area;
	private BigDecimal lng;
	private BigDecimal lat;
	private Integer zoom;
	private String buildType;
	private String structure;
	private String memo;
    private Date mapTime;



    private int nextHouseOrder;

    private int upFloorCount;
    private int downFloorCount;

    private Project project;

    private Set<House> houses = new HashSet<House>(0);
    private Set<BuildGridMap> buildGridMaps = new HashSet<BuildGridMap>(0);

	public Build() {
	}

    public Build(Project project) {
        this.project = project;
    }

	public Build(String id, Project project, String mapNumber, String blockNo,
			String buildNo, String name) {
		this.id = id;
		this.project = project;
		this.mapNumber = mapNumber;
		this.blockNo = blockNo;
		this.buildNo = buildNo;
		this.name = name;
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

	@Version
	@Column(name = "VERSION")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

    @Override
    @Transient
    public String getDeveloperName() {
        return getProject().getDeveloperName();
    }

    @Override
    @Transient
    public String getDeveloperCode() {
        return getProject().getDeveloperCode();
    }

    @Override
    @Transient
    public String getProjectName() {
        return getProject().getProjectName();
    }

    @Override
    @Transient
    public String getProjectCode() {
        return getProject().getProjectCode();
    }


    @Column(name = "COMPLETE_DATE",length = 6)
    @Size(max = 6)
    public String getCompleteYear() {
        return completeYear;
    }

    public void setCompleteYear(String completeDate) {
        this.completeYear = completeDate;
    }


    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID", nullable = false)
	@NotNull
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
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
	@Size(max = 10)
    @NotNull
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
    @Column(name="DEVELOPER_NUMBER", nullable = true, length = 20)
    @Size(max = 20)
    public String getBuildDevNumber() {
        return devBuildNumber;
    }

    public void setBuildDevNumber(String developerNumber) {
        this.devBuildNumber = developerNumber;
    }


    @Column(name = "NAME", unique = true ,nullable = false, length = 100)
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

	@Transient
	public int getFloorCount() {
		return getUpFloorCount() + getDownFloorCount();
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

	@Column(name = "LNG", precision = 18, scale = 14)
	public BigDecimal getLng() {
		return this.lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	@Column(name = "LAT", precision = 18, scale = 14)
	public BigDecimal getLat() {
		return this.lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	@Column(name = "ZOOM")
	public Integer getZoom() {
		return this.zoom;
	}

	public void setZoom(Integer zoom) {
		this.zoom = zoom;
	}

	@Column(name = "BUILD_TYPE", length = 32)
	@Size(max = 32)
	public String getBuildType() {
		return this.buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
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

	@Column(name = "MEMO", length = 200)
	@Size(max = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "build", orphanRemoval = true,cascade = {CascadeType.ALL})
	public Set<House> getHouses() {
		return this.houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "build",orphanRemoval = true, cascade = {CascadeType.ALL})
    public Set<BuildGridMap> getBuildGridMaps() {
        return buildGridMaps;
    }

    public void setBuildGridMaps(Set<BuildGridMap> buildGridMaps) {
        this.buildGridMaps = buildGridMaps;
    }

    @Override
    @Transient
    public String getBuildName() {
        return getName();
    }

    @Override
    @Transient
    public String getBuildCode() {
        return getId();
    }

    @Column(name = "STREET_CODE",length = 4)
    @Size(max = 4)
    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    @Column(name = "NEXT_HOUSE_ORDER",nullable = false)
    public int getNextHouseOrder() {
        return nextHouseOrder;
    }

    public void setNextHouseOrder(int nextHouseOrder) {
        this.nextHouseOrder = nextHouseOrder;
    }


    @Column(name = "UP_FLOOR_COUNT", nullable = false)
    public int getUpFloorCount() {
        return upFloorCount;
    }

    public void setUpFloorCount(int upFloorCount) {
        this.upFloorCount = upFloorCount;
    }

    @Column(name = "DOWN_FLOOR_COUNT", nullable = false)
    public int getDownFloorCount() {
        return downFloorCount;
    }

    public void setDownFloorCount(int downFloorCount) {
        this.downFloorCount = downFloorCount;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MAP_TIME", nullable = true, length = 19)
    public Date getMapTime() {
        return this.mapTime;
    }

    public void setMapTime(Date mapTime) {
        this.mapTime = mapTime;
    }

    @Override
    @Transient
    public TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    @Transient
    public int getChildCount() {
        return 0;
    }

    @Override
    @Transient
    public TreeNode getParent() {
        return getProject();
    }

    @Override
    @Transient
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    @Transient
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    @Transient
    public boolean isLeaf() {
        return true;
    }

    @Override
    @Transient
    public Enumeration children() {
        return new Enumeration() {
            @Override
            public boolean hasMoreElements() {
                return false;
            }

            @Override
            public Object nextElement() {
                return null;
            }
        };
    }

    @Override
    @Transient
    public String getDistrictName() {
        return getProject().getDistrictName();
    }

    @Override
    @Transient
    public String getDistrictCode() {
        return getProject().getDistrictCode();
    }

    @Override
    @Transient
    public String getSectionName() {
        return getProject().getSectionName();
    }

    @Override
    @Transient
    public String getSectionCode() {
        return getProject().getSectionCode();
    }
}
