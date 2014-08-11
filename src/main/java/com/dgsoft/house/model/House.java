package com.dgsoft.house.model;
// Generated Jul 12, 2013 11:32:23 AM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * House generated by hbm2java
 */
@Entity
@Table(name = "HOUSE", catalog = "HOUSE_INFO")
public class House implements java.io.Serializable {

	private String id;
	private Integer version;
	private LandInfo landInfo;
	private Build build;
	private HouseOwner houseOwnerByRecordId;
	private HouseOwner houseOwnerByOwnerId;
	private String houseNumber;
	private String houseOrder;
	private String houseUnitName;
	private String inFloorName;
	private BigDecimal houseArea;
	private BigDecimal prepareArea;
	private BigDecimal tempArea;
	private BigDecimal useArea;
	private BigDecimal commArea;
	private BigDecimal shineArea;
	private BigDecimal loftArea;
	private BigDecimal commParam;
	private BigDecimal privateArea;
    private BigDecimal buildCost;
	private int houseState;
	private String doorNo;
	private String houseType;
	private String useType;
	private String housePorperty;
	private String structure;
	private String knotSize;
	private String houseFrom;
	private String address;
	private String dataSource;
	private String eastWall;
	private String westWall;
	private String southWall;
	private String northWall;
	private Date mapTime;
	private String direction;
	private boolean initRegister;
	private String initRegisterBusinessCode;
	private boolean firmlyPower;
	private String firmlyPowerBusinessCode;
	private boolean outPlan;
	private BigDecimal sumPrice;
	private String payType;
	private String memo;
	private Set<HouseContract> houseContracts = new HashSet<HouseContract>(0);
	private Set<HouseState> houseStates = new HashSet<HouseState>(0);
	private Set<PoolOwner> poolOwners = new HashSet<PoolOwner>(0);

	public House() {
	}

    public House(String houseOrder){
        this.houseOrder = houseOrder;
    }

	public House(String id, Build build, HouseOwner houseOwnerByRecordId,
			HouseOwner houseOwnerByOwnerId, String houseOrder,
			BigDecimal houseArea, int houseState, Date mapTime,
			boolean initRegister, boolean firmlyPower, boolean outPlan) {
		this.id = id;
		this.build = build;
		this.houseOwnerByRecordId = houseOwnerByRecordId;
		this.houseOwnerByOwnerId = houseOwnerByOwnerId;
		this.houseOrder = houseOrder;
		this.houseArea = houseArea;
		this.houseState = houseState;
		this.mapTime = mapTime;
		this.initRegister = initRegister;
		this.firmlyPower = firmlyPower;
		this.outPlan = outPlan;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LAND_INFO")
	public LandInfo getLandInfo() {
		return this.landInfo;
	}

	public void setLandInfo(LandInfo landInfo) {
		this.landInfo = landInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUILDID", nullable = false)
	@NotNull
	public Build getBuild() {
		return this.build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RECORD_ID", nullable = false)
	@NotNull
	public HouseOwner getHouseOwnerByRecordId() {
		return this.houseOwnerByRecordId;
	}

	public void setHouseOwnerByRecordId(HouseOwner houseOwnerByRecordId) {
		this.houseOwnerByRecordId = houseOwnerByRecordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OWNER_ID", nullable = false)
	@NotNull
	public HouseOwner getHouseOwnerByOwnerId() {
		return this.houseOwnerByOwnerId;
	}

	public void setHouseOwnerByOwnerId(HouseOwner houseOwnerByOwnerId) {
		this.houseOwnerByOwnerId = houseOwnerByOwnerId;
	}

	@Column(name = "HOUSE_NUMBER", length = 50)
	@Size(max = 50)
	public String getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	@Column(name = "HOUSE_ORDER", nullable = false, length = 20)
	@NotNull
	@Size(max = 20)
	public String getHouseOrder() {
		return this.houseOrder;
	}

	public void setHouseOrder(String houseOrder) {
		this.houseOrder = houseOrder;
	}

	@Column(name = "HOUSE_UNIT_NAME", length = 20)
	@Size(max = 20)
	public String getHouseUnitName() {
		return this.houseUnitName;
	}

	public void setHouseUnitName(String houseUnitName) {
		this.houseUnitName = houseUnitName;
	}

	@Column(name = "IN_FLOOR_NAME", length = 50)
	@Size(max = 50)
	public String getInFloorName() {
		return this.inFloorName;
	}

	public void setInFloorName(String inFloorName) {
		this.inFloorName = inFloorName;
	}

	@Column(name = "HOUSE_AREA", nullable = false, precision = 18, scale = 3)
	@NotNull
	public BigDecimal getHouseArea() {
		return this.houseArea;
	}

	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
	}

	@Column(name = "PREPARE_AREA", precision = 18, scale = 3)
	public BigDecimal getPrepareArea() {
		return this.prepareArea;
	}

	public void setPrepareArea(BigDecimal prepareArea) {
		this.prepareArea = prepareArea;
	}

	@Column(name = "TEMP_AREA", precision = 18, scale = 3)
	public BigDecimal getTempArea() {
		return this.tempArea;
	}

	public void setTempArea(BigDecimal tempArea) {
		this.tempArea = tempArea;
	}

	@Column(name = "USE_AREA", precision = 18, scale = 3)
	public BigDecimal getUseArea() {
		return this.useArea;
	}

	public void setUseArea(BigDecimal useArea) {
		this.useArea = useArea;
	}

	@Column(name = "COMM_AREA", precision = 18, scale = 3)
	public BigDecimal getCommArea() {
		return this.commArea;
	}

	public void setCommArea(BigDecimal commArea) {
		this.commArea = commArea;
	}

	@Column(name = "SHINE_AREA", precision = 18, scale = 10)
	public BigDecimal getShineArea() {
		return this.shineArea;
	}

	public void setShineArea(BigDecimal shineArea) {
		this.shineArea = shineArea;
	}

	@Column(name = "LOFT_AREA", precision = 18, scale = 3)
	public BigDecimal getLoftArea() {
		return this.loftArea;
	}

	public void setLoftArea(BigDecimal loftArea) {
		this.loftArea = loftArea;
	}

	@Column(name = "COMM_PARAM", precision = 18, scale = 3)
	public BigDecimal getCommParam() {
		return this.commParam;
	}

	public void setCommParam(BigDecimal commParam) {
		this.commParam = commParam;
	}

	@Column(name = "PRIVATE_AREA", precision = 18, scale = 3)
	public BigDecimal getPrivateArea() {
		return this.privateArea;
	}

	public void setPrivateArea(BigDecimal privateArea) {
		this.privateArea = privateArea;
	}

	@Column(name = "HOUSE_STATE", nullable = false)
	public int getHouseState() {
		return this.houseState;
	}

	public void setHouseState(int houseState) {
		this.houseState = houseState;
	}

	@Column(name = "DOOR_NO", length = 20)
	@Size(max = 20)
	public String getDoorNo() {
		return this.doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	@Column(name = "HOUSE_TYPE", length = 32)
	@Size(max = 32)
	public String getHouseType() {
		return this.houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	@Column(name = "USE_TYPE", length = 32)
	@Size(max = 32)
	public String getUseType() {
		return this.useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	@Column(name = "HOUSE_PORPERTY", length = 32)
	@Size(max = 32)
	public String getHousePorperty() {
		return this.housePorperty;
	}

	public void setHousePorperty(String housePorperty) {
		this.housePorperty = housePorperty;
	}

	@Column(name = "STRUCTURE", length = 32)
	@Size(max = 32)
	public String getStructure() {
		return this.structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	@Column(name = "KNOT_SIZE", length = 32)
	@Size(max = 32)
	public String getKnotSize() {
		return this.knotSize;
	}

	public void setKnotSize(String knotSize) {
		this.knotSize = knotSize;
	}

	@Column(name = "HOUSE_FROM", length = 32)
	@Size(max = 32)
	public String getHouseFrom() {
		return this.houseFrom;
	}

	public void setHouseFrom(String houseFrom) {
		this.houseFrom = houseFrom;
	}

	@Column(name = "ADDRESS", length = 200)
	@Size(max = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String houseStation) {
		this.address = houseStation;
	}


	@Column(name = "DATA_SOURCE", length = 32)
	@Size(max = 32)
	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	@Column(name = "EAST_WALL", length = 32)
	@Size(max = 32)
	public String getEastWall() {
		return this.eastWall;
	}

	public void setEastWall(String eastWall) {
		this.eastWall = eastWall;
	}

	@Column(name = "WEST_WALL", length = 32)
	@Size(max = 32)
	public String getWestWall() {
		return this.westWall;
	}

	public void setWestWall(String westWall) {
		this.westWall = westWall;
	}

	@Column(name = "SOUTH_WALL", length = 32)
	@Size(max = 32)
	public String getSouthWall() {
		return this.southWall;
	}

	public void setSouthWall(String southWall) {
		this.southWall = southWall;
	}

	@Column(name = "NORTH_WALL", length = 32)
	@Size(max = 32)
	public String getNorthWall() {
		return this.northWall;
	}

	public void setNorthWall(String northWall) {
		this.northWall = northWall;
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

	@Column(name = "DIRECTION", length = 32)
	@Size(max = 32)
	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Column(name = "INIT_REGISTER", nullable = false)
	public boolean isInitRegister() {
		return this.initRegister;
	}

	public void setInitRegister(boolean initRegister) {
		this.initRegister = initRegister;
	}

	@Column(name = "INIT_REGISTER_BUSINESS_CODE", length = 32)
	@Size(max = 32)
	public String getInitRegisterBusinessCode() {
		return this.initRegisterBusinessCode;
	}

	public void setInitRegisterBusinessCode(String initRegisterBusinessCode) {
		this.initRegisterBusinessCode = initRegisterBusinessCode;
	}

	@Column(name = "FIRMLY_POWER", nullable = false)
	public boolean isFirmlyPower() {
		return this.firmlyPower;
	}

	public void setFirmlyPower(boolean firmlyPower) {
		this.firmlyPower = firmlyPower;
	}

	@Column(name = "FIRMLY_POWER_BUSINESS_CODE", length = 32)
	@Size(max = 32)
	public String getFirmlyPowerBusinessCode() {
		return this.firmlyPowerBusinessCode;
	}

	public void setFirmlyPowerBusinessCode(String firmlyPowerBusinessCode) {
		this.firmlyPowerBusinessCode = firmlyPowerBusinessCode;
	}

	@Column(name = "OUT_PLAN", nullable = false)
	public boolean isOutPlan() {
		return this.outPlan;
	}

	public void setOutPlan(boolean outPlan) {
		this.outPlan = outPlan;
	}

	@Column(name = "SUM_PRICE", precision = 18, scale = 3)
	public BigDecimal getSumPrice() {
		return this.sumPrice;
	}

	public void setSumPrice(BigDecimal sumPrice) {
		this.sumPrice = sumPrice;
	}

	@Column(name = "PAY_TYPE", length = 32)
	@Size(max = 32)
	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	@Column(name = "MEMO", length = 200)
	@Size(max = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "house")
	public Set<HouseContract> getHouseContracts() {
		return this.houseContracts;
	}

	public void setHouseContracts(Set<HouseContract> houseContracts) {
		this.houseContracts = houseContracts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "house")
	public Set<HouseState> getHouseStates() {
		return this.houseStates;
	}

	public void setHouseStates(Set<HouseState> houseStates) {
		this.houseStates = houseStates;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "house")
	public Set<PoolOwner> getPoolOwners() {
		return this.poolOwners;
	}

	public void setPoolOwners(Set<PoolOwner> poolOwners) {
		this.poolOwners = poolOwners;
	}


    @Column(name = "BUILD_COST", precision = 18, scale = 3)
    public BigDecimal getBuildCost() {
        return buildCost;
    }

    public void setBuildCost(BigDecimal buildCost) {
        this.buildCost = buildCost;
    }
}
