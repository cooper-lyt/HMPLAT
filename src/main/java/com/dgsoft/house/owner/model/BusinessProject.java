package com.dgsoft.house.owner.model;
// Generated Oct 11, 2014 3:13:15 PM by Hibernate Tools 4.0.0


import com.dgsoft.house.ProjectInfo;
import com.dgsoft.house.model.Project;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Project generated by hbm2java
 */
@Entity
@Table(name = "PROJECT", catalog = "HOUSE_OWNER_RECORD")
public class BusinessProject implements java.io.Serializable, ProjectInfo {


    private String id;
    private OwnerBusiness ownerBusiness;
    private String name;
    private String address;
    private String developerName;
    private String developerCode;
    private String sectionName;
    private String sectionCode;
    private String districtCode;
    private String districtName;
    private String projectCode;

    private RecordStore recordStore;
    private Set<BusinessBuild> businessBuilds = new HashSet<BusinessBuild>(0);
    private ProjectSellInfo projectSellInfo;

    public BusinessProject() {
    }

    public BusinessProject(OwnerBusiness ownerBusiness, Project project){
        this.ownerBusiness = ownerBusiness;
        this.name = project.getProjectName();
        this.address = project.getAddress();
        this.developerName = project.getDeveloperName();
        this.developerCode = project.getDeveloperCode();
        this.sectionName = project.getSectionName();
        this.sectionCode = project.getSectionCode();
        this.districtCode = project.getDistrictCode();
        this.districtName = project.getDistrictName();
        this.projectCode = project.getProjectCode();
    }

    public BusinessProject(OwnerBusiness ownerBusiness, BusinessProject other) {
        this.ownerBusiness = ownerBusiness;
        this.name = other.getName();
        this.address = other.getAddress();
        this.developerName = other.getDeveloperName();
        this.developerCode = other.getDeveloperCode();
        this.sectionName = other.getSectionName();
        this.sectionCode = other.getSectionCode();
        this.districtCode = other.getDistrictCode();
        this.districtName = other.getDistrictName();
        this.projectCode = other.getProjectCode();
        this.projectSellInfo = new ProjectSellInfo(this,other.getProjectSellInfo());
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSINESS", nullable = false)
    @NotNull
    public OwnerBusiness getOwnerBusiness() {
        return this.ownerBusiness;
    }

    public void setOwnerBusiness(OwnerBusiness ownerBusiness) {
        this.ownerBusiness = ownerBusiness;
    }


    @Column(name = "NAME", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "ADDRESS", length = 200)
    @Size(max = 200)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "DEVELOPER_NAME", length = 100)
    @Size(max = 100)
    public String getDeveloperName() {
        return this.developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }


    @Column(name = "DEVELOPER_CODE", length = 32)
    @Size(max = 32)
    public String getDeveloperCode() {
        return this.developerCode;
    }

    @Override
    @Transient
    public String getProjectName() {
        return getName();
    }

    public void setDeveloperCode(String developerCode) {
        this.developerCode = developerCode;
    }


    @Column(name = "SECTION_NAME", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    public String getSectionName() {
        return this.sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }


    @Column(name = "SECTION_CODE", nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    public String getSectionCode() {
        return this.sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }


    @Column(name = "DISTRICT_CODE", nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    public String getDistrictCode() {
        return this.districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }


    @Column(name = "DISTRICT_NAME", nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    public String getDistrictName() {
        return this.districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }


    @Column(name = "PROJECT_CODE", nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    public String getProjectCode() {
        return this.projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "businessProject")
    public Set<BusinessBuild> getBusinessBuilds() {
        return this.businessBuilds;
    }

    public void setBusinessBuilds(Set<BusinessBuild> businessBuilds) {
        this.businessBuilds = businessBuilds;
    }

    @Transient
    public List<BusinessBuild> getBusinessBuildList(){
        List<BusinessBuild> result = new ArrayList<BusinessBuild>(getBusinessBuilds());
        Collections.sort(result, new Comparator<BusinessBuild>() {
            @Override
            public int compare(BusinessBuild o1, BusinessBuild o2) {
                if (o1.getId() == null && o2.getId() == null){
                    return 0;
                }else if (o1.getId() == null){
                    return -1;
                }else if (o2.getId() == null){
                    return 1;
                }else
                    return o1.getId().compareTo(o2.getId());
            }
        });
        return result;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public ProjectSellInfo getProjectSellInfo() {
        return projectSellInfo;
    }

    public void setProjectSellInfo(ProjectSellInfo projectSellInfo) {
        this.projectSellInfo = projectSellInfo;
    }


}


