package com.dgsoft.house.owner.model;
// Generated Aug 19, 2014 4:32:06 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Project generated by hbm2java
 */
@Entity
@Table(name = "PROJECT", catalog = "HOUSE_OWNER_RECORD", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class BusinessProject implements java.io.Serializable {

	private String id;
	private String name;
	private String address;
	private String buildSize;
	private Integer buildCount;
	private BigDecimal area;
	private BigDecimal sumArea;
	private Date mapTime;
	private String completeDate;
	private String developerName;
	private String developerCode;
	private String sectionName;
	private String sectionCode;
	private String districtCode;
	private String districtName;
	private String projectCode;
	private Set<BusinessBuild> businessBuilds = new HashSet<BusinessBuild>(0);
	private Set<ProjectSellCard> projectSellCards = new HashSet<ProjectSellCard>(0);

	public BusinessProject() {
	}

	public BusinessProject(String id, String name, Date mapTime, String districtCode,
                           String districtName, String projectCode) {
		this.id = id;
		this.name = name;
		this.mapTime = mapTime;
		this.districtCode = districtCode;
		this.districtName = districtName;
		this.projectCode = projectCode;
	}
	public BusinessProject(String id, String name, String address, String buildSize,
                           Integer buildCount, BigDecimal area, BigDecimal sumArea,
                           Date mapTime, String completeDate, String developerName,
                           String developerCode, String sectionName, String sectionCode,
                           String districtCode, String districtName, String projectCode,
                           Set<BusinessBuild> businessBuilds, Set<ProjectSellCard> projectSellCards) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.buildSize = buildSize;
		this.buildCount = buildCount;
		this.area = area;
		this.sumArea = sumArea;
		this.mapTime = mapTime;
		this.completeDate = completeDate;
		this.developerName = developerName;
		this.developerCode = developerCode;
		this.sectionName = sectionName;
		this.sectionCode = sectionCode;
		this.districtCode = districtCode;
		this.districtName = districtName;
		this.projectCode = projectCode;
		this.businessBuilds = businessBuilds;
		this.projectSellCards = projectSellCards;
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

	@Column(name = "NAME", unique = true, nullable = false, length = 50)
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

	@Column(name = "BUILD_SIZE", length = 32)
	@Size(max = 32)
	public String getBuildSize() {
		return this.buildSize;
	}

	public void setBuildSize(String buildSize) {
		this.buildSize = buildSize;
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

	@Column(name = "SUM_AREA", precision = 18, scale = 3)
	public BigDecimal getSumArea() {
		return this.sumArea;
	}

	public void setSumArea(BigDecimal sumArea) {
		this.sumArea = sumArea;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MAP_TIME", nullable = false, length = 19)
	@NotNull
	public Date getMapTime() {
		return this.mapTime;
	}

	public void setMapTime(Date mapTime) {
		this.mapTime = mapTime;
	}

	@Column(name = "COMPLETE_DATE", length = 6)
	@Size(max = 6)
	public String getCompleteDate() {
		return this.completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
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

	public void setDeveloperCode(String developerCode) {
		this.developerCode = developerCode;
	}

	@Column(name = "SECTION_NAME", length = 50)
	@Size(max = 50)
	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	@Column(name = "SECTION_CODE", length = 32)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessProject")
	public Set<BusinessBuild> getBusinessBuilds() {
		return this.businessBuilds;
	}

	public void setBusinessBuilds(Set<BusinessBuild> businessBuilds) {
		this.businessBuilds = businessBuilds;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessProject")
	public Set<ProjectSellCard> getProjectSellCards() {
		return this.projectSellCards;
	}

	public void setProjectSellCards(Set<ProjectSellCard> projectSellCards) {
		this.projectSellCards = projectSellCards;
	}

}