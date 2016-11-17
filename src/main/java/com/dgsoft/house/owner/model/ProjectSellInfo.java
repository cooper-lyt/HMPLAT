package com.dgsoft.house.owner.model;
// Generated Oct 11, 2014 3:13:15 PM by Hibernate Tools 4.0.0

import com.dgsoft.house.SaleType;
import org.hibernate.annotations.*;
import org.jboss.seam.log.Logging;

import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ProjectSellCard generated by hbm2java
 */
@Entity
@Table(name = "PROJECT_SELL_INFO", catalog = "HOUSE_OWNER_RECORD")
public class ProjectSellInfo implements java.io.Serializable {


	private String id;
	private BusinessProject businessProject;



	private String useType;
	private String sellObject;

	private SaleType type;

    private String landCardNo;
    private String landCardType;

    private String number;
    private String landProperty;

    private Date beginUseTime;
    private Date endUseTime;
    private BigDecimal landArea;
    private String landGetMode;
    private String landUseType;
    private String proofMaterial;


    private String landAddress;

    private String buildSize;

    private ProjectCard projectCard;

    private String createCardNumber;
    private String createPrepareCardNumber;

    private Integer houseCount;
    private Integer buildCount;
    private BigDecimal area;
    private String licenseNumber;
    private String createLandCardNumber;

    private Set<ProjectLandEndTime> projectLandEndTimes = new HashSet<ProjectLandEndTime>(0);

	public ProjectSellInfo() {
	}

    public ProjectSellInfo(BusinessProject businessProject) {
        this.businessProject = businessProject;
    }

    public ProjectSellInfo(BusinessProject businessProject, ProjectSellInfo other) {
        this.businessProject = businessProject;

        this.useType = other.getUseType();
        this.sellObject = other.getSellObject();
        this.type = other.getType();
        this.landCardNo = other.getLandCardNo();
        this.landCardType = other.getLandCardType();
        this.number = other.getNumber();
        this.landProperty = other.getLandProperty();
        this.beginUseTime = other.getBeginUseTime();
        this.endUseTime = other.getEndUseTime();
        this.landArea = other.getLandArea();
        this.landGetMode = other.getLandGetMode();
        this.landUseType = other.getLandUseType();
        this.landAddress = other.getLandAddress();
        this.buildSize = other.getBuildSize();
        this.createCardNumber = other.getCreateCardNumber();
        this.createPrepareCardNumber = other.getCreatePrepareCardNumber();
        this.licenseNumber = other.getLicenseNumber();
        this.createLandCardNumber = other.getCreateLandCardNumber();
        this.proofMaterial = other.getProofMaterial();
        if (!other.getProjectLandEndTimes().isEmpty()){
            for (ProjectLandEndTime projectLandEndTime:other.getProjectLandEndTimes()){
                ProjectLandEndTime newP = new ProjectLandEndTime(projectLandEndTime,this);
                this.projectLandEndTimes.add(newP);

            }
        }
    }

    @Id
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
    @GenericGenerator(name = "pkGenerator",
            strategy = "foreign",
            parameters = { @org.hibernate.annotations.Parameter(name = "property", value = "businessProject") })
    @GeneratedValue(generator = "pkGenerator")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
	public BusinessProject getBusinessProject() {
		return this.businessProject;
	}

	public void setBusinessProject(BusinessProject businessProject) {
		this.businessProject = businessProject;
	}

	@Column(name = "HOUSE_COUNT")
	public Integer getHouseCount() {
		return this.houseCount;
	}

	public void setHouseCount(Integer houseCount) {
		this.houseCount = houseCount;
	}

	@Column(name = "BUILD_COUNT")
	public Integer getBuildCount() {
		return this.buildCount;
	}

	public void setBuildCount(Integer buildCount) {
		this.buildCount = buildCount;
	}

	@Column(name = "AREA", precision = 18, scale = 3)
	public BigDecimal getArea() {
		return this.area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}



	@Column(name = "USE_TYPE", length = 512)
    @Size(max = 512)
	public String getUseType() {
		return this.useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	@Column(name = "SELL_OBJECT", length = 50)
	@Size(max = 50)
	public String getSellObject() {
		return this.sellObject;
	}

	public void setSellObject(String sellObject) {
		this.sellObject = sellObject;
	}



    @Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false, length = 20)
	@NotNull
	public SaleType getType() {
		return this.type;
	}

	public void setType(SaleType type) {
		this.type = type;
	}


    @Column(name = "LAND_CARD_TYPE", nullable = false, length = 32)
    @Size(max = 32)
    @NotNull
    public String getLandCardType() {
        return landCardType;
    }

    public void setLandCardType(String landCardType) {
        this.landCardType = landCardType;
    }

    @Column(name = "LAND_USE_TYPE",nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    public String getLandUseType() {
        return landUseType;
    }

    public void setLandUseType(String landUseType) {
        this.landUseType = landUseType;
    }

    @Column(name = "CREATE_CARD_CODE", nullable = false, length = 50)
    @Size(max = 50)
    @NotNull
    public String getCreateCardNumber() {
        return createCardNumber;
    }

    public void setCreateCardNumber(String createCardNumber) {
        this.createCardNumber = createCardNumber;
    }

    @Column(name = "CREATE_PREPARE_CARD_CODE", nullable = false, length = 50)
    @Size(max = 50)
    @NotNull
    public String getCreatePrepareCardNumber() {
        return createPrepareCardNumber;
    }

    public void setCreatePrepareCardNumber(String createPrepareCardNumber) {
        this.createPrepareCardNumber = createPrepareCardNumber;
    }

    @Column(name = "LAND_CARD_NO", length = 50)
    @Size(max = 50)
    public String getLandCardNo() {
        return this.landCardNo;
    }

    public void setLandCardNo(String landCardNo) {
        this.landCardNo = landCardNo;
    }


    @Column(name = "NUMBER", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Column(name = "LAND_PROPERTY", length = 32)
    @Size(max = 32)
    public String getLandProperty() {
        return this.landProperty;
    }

    public void setLandProperty(String landProperty) {
        this.landProperty = landProperty;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BEGIN_USE_TIME", nullable = false, length = 19)
    @NotNull
    public Date getBeginUseTime() {
        return this.beginUseTime;
    }

    public void setBeginUseTime(Date beginUseTime) {
        this.beginUseTime = beginUseTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_USE_TIME", nullable = false, length = 19)
    @NotNull
    public Date getEndUseTime() {
        return this.endUseTime;
    }

    public void setEndUseTime(Date endUseTime) {
        this.endUseTime = endUseTime;
    }


    @Column(name = "LAND_AREA", precision = 18, scale = 3)
    public BigDecimal getLandArea() {
        return this.landArea;
    }

    public void setLandArea(BigDecimal landArea) {
        this.landArea = landArea;
    }


    @Column(name = "LAND_GET_MODE", nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    public String getLandGetMode() {
        return this.landGetMode;
    }

    public void setLandGetMode(String landGetMode) {
        this.landGetMode = landGetMode;
    }

    @Column(name = "BUILD_SIZE", length = 32)
    @Size(max = 32)
    public String getBuildSize() {
        return this.buildSize;
    }

    public void setBuildSize(String buildSize) {
        this.buildSize = buildSize;
    }

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "projectSellInfo")
    public ProjectCard getProjectCard() {
        return projectCard;
    }

    public void setProjectCard(ProjectCard projectCard) {
        this.projectCard = projectCard;
    }

    @Column(name = "LAND_ADDRESS", length = 255)
    @Size(max = 255)
    public String getLandAddress() {
        return landAddress;
    }

    public void setLandAddress(String landAddress) {
        this.landAddress = landAddress;
    }


    @Column(name = "LICENSE_NUMBER", length = 50)
    @Size(max = 50)
    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Column(name = "CREATE_LAND_CARD_CODE", length = 50)
    @Size(max = 50)
    public String getCreateLandCardNumber() {
        return createLandCardNumber;
    }

    public void setCreateLandCardNumber(String createLandCardNumber) {
        this.createLandCardNumber = createLandCardNumber;
    }

    @Column(name = "PROOF_MATERIAL", length = 50)
    @Size(max = 50)
    public String getProofMaterial() {
        return proofMaterial;
    }

    public void setProofMaterial(String proofMaterial) {
        this.proofMaterial = proofMaterial;
    }


    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true, cascade = CascadeType.ALL,mappedBy = "projectSellInfo")
    public Set<ProjectLandEndTime> getProjectLandEndTimes() {
        return projectLandEndTimes;
    }

    public void setProjectLandEndTimes(Set<ProjectLandEndTime> projectLandEndTimes) {
        this.projectLandEndTimes = projectLandEndTimes;
    }
    @Transient
    public List<ProjectLandEndTime> getProjectLandEndTimeList(){
        List<ProjectLandEndTime> result = new ArrayList<ProjectLandEndTime>(getProjectLandEndTimes());
        return result;
    }
}
