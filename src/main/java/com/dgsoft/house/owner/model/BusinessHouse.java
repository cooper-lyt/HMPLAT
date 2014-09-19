package com.dgsoft.house.owner.model;
// Generated Aug 19, 2014 4:32:06 PM by Hibernate Tools 4.0.0

import com.dgsoft.house.model.House;
import com.dgsoft.house.model.HouseState;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * BusinessHouse generated by hbm2java
 */
@Entity
@Table(name = "BUSINESS_HOUSE", catalog = "HOUSE_OWNER_RECORD")
public class BusinessHouse implements java.io.Serializable {

    private String id;
    private OwnerBusiness ownerBusiness;
    private BusinessLandInfo businessLandInfo;
    private BusinessBuild businessBuild;
    private String houseOrder;
    private String houseUnitName;
    private String inFloorName;
    private BigDecimal houseArea;
    private BigDecimal prepareArea;
    private BigDecimal useArea;
    private BigDecimal commArea;
    private BigDecimal shineArea;
    private BigDecimal loftArea;
    private BigDecimal commParam;
    private int houseState;
    private String houseType;
    private String useType;
    private String structure;
    private String knotSize;
    private String address;
    private String eastWall;
    private String westWall;
    private String southWall;
    private String northWall;
    private Date mapTime;
    private String direction;
    private boolean initRegister;
    private boolean firmlyPower;
    private String houseCode;
    private Set<BusinessHouseState> businessHouseStates = new HashSet<BusinessHouseState>(0);
    private Set<NewHouseContract> newHouseContracts = new HashSet<NewHouseContract>(0);
    private Set<BusinessHouseOwner> businessHouseOwners = new HashSet<BusinessHouseOwner>(0);
    private Set<BusinessPool> businessPools = new HashSet<BusinessPool>(0);

    public BusinessHouse() {
    }

    public BusinessHouse(OwnerBusiness ownerBusiness, House house) {
        this.ownerBusiness = ownerBusiness;
        this.houseOrder = house.getHouseOrder();
        this.houseUnitName = house.getHouseUnitName();
        this.inFloorName = house.getInFloorName();
        this.houseArea = house.getHouseArea();
        this.prepareArea = house.getPrepareArea();
        this.useArea = house.getUseArea();
        this.commArea = house.getCommArea();
        this.shineArea = house.getShineArea();
        this.loftArea = house.getLoftArea();
        this.commParam = house.getCommParam();
        this.houseState = house.getHouseState();
        this.houseType = house.getHouseType();
        this.useType = house.getUseType();
        this.structure = house.getStructure();
        this.knotSize = house.getKnotSize();
        this.address = house.getAddress();
        this.eastWall = house.getEastWall();
        this.westWall = house.getWestWall();
        this.southWall = house.getSouthWall();
        this.northWall = house.getNorthWall();
        this.mapTime = house.getMapTime();
        this.direction = house.getDirection();
        this.initRegister = house.isInitRegister();
        this.firmlyPower = house.isFirmlyPower();
        this.houseCode = house.getId();
        for (HouseState state : house.getHouseStates()) {
            businessHouseStates.add(new BusinessHouseState(this, state.getState()));
        }

        if (house.getLandInfo() != null) {
            this.setBusinessLandInfo(new BusinessLandInfo(house.getLandInfo()));
        }

        this.setBusinessBuild(new BusinessBuild(house.getBuild()));

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
    @JoinColumn(name = "BUSINESS_ID", nullable = false)
    @NotNull
    public OwnerBusiness getOwnerBusiness() {
        return this.ownerBusiness;
    }

    public void setOwnerBusiness(OwnerBusiness ownerBusiness) {
        this.ownerBusiness = ownerBusiness;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "LAND_INFO")
    public BusinessLandInfo getBusinessLandInfo() {
        return this.businessLandInfo;
    }

    public void setBusinessLandInfo(BusinessLandInfo businessLandInfo) {
        this.businessLandInfo = businessLandInfo;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, optional = false)
    @JoinColumn(name = "BUILD_ID", nullable = false)
    @NotNull
    public BusinessBuild getBusinessBuild() {
        return this.businessBuild;
    }

    public void setBusinessBuild(BusinessBuild businessBuild) {
        this.businessBuild = businessBuild;
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

    @Column(name = "IN_FLOOR_NAME", nullable = false, length = 50)
    @NotNull
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

    @Column(name = "HOUSE_STATE", nullable = false)
    public int getHouseState() {
        return this.houseState;
    }

    public void setHouseState(int houseState) {
        this.houseState = houseState;
    }

    @Column(name = "HOUSE_TYPE", length = 32)
    @Size(max = 32)
    public String getHouseType() {
        return this.houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    @Column(name = "USE_TYPE", nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    public String getUseType() {
        return this.useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    @Column(name = "STRUCTURE", nullable = false, length = 32)
    @NotNull
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

    @Column(name = "ADDRESS", nullable = false, length = 200)
    @NotNull
    @Size(max = 200)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Column(name = "FIRMLY_POWER", nullable = false)
    public boolean isFirmlyPower() {
        return this.firmlyPower;
    }

    public void setFirmlyPower(boolean firmlyPower) {
        this.firmlyPower = firmlyPower;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessHouse", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<BusinessHouseState> getBusinessHouseStates() {
        return this.businessHouseStates;
    }

    public void setBusinessHouseStates(Set<BusinessHouseState> businessHouseStates) {
        this.businessHouseStates = businessHouseStates;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessHouse", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<NewHouseContract> getNewHouseContracts() {
        return this.newHouseContracts;
    }

    public void setNewHouseContracts(Set<NewHouseContract> newHouseContracts) {
        this.newHouseContracts = newHouseContracts;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessHouse", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<BusinessHouseOwner> getBusinessHouseOwners() {
        return businessHouseOwners;
    }

    public void setBusinessHouseOwners(Set<BusinessHouseOwner> businessHouseOwners) {
        this.businessHouseOwners = businessHouseOwners;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessHouse", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<BusinessPool> getBusinessPools() {
        return businessPools;
    }

    public void setBusinessPools(Set<BusinessPool> businessPools) {
        this.businessPools = businessPools;
    }


    @Transient
    private List<BusinessPool> getPoolsByType(BusinessPool.BusinessPoolType type) {
        List<BusinessPool> result = new ArrayList<BusinessPool>();
        for (BusinessPool pool : getBusinessPools()) {
            if (type.equals(pool.getType())) {
                result.add(pool);
            }
        }

        Collections.sort(result, new Comparator<BusinessPool>() {
            @Override
            public int compare(BusinessPool o1, BusinessPool o2) {
                if ((o1.getPoolArea() == null) && (o2.getPoolArea() == null)) {
                    return 0;
                } else if (o1.getPoolArea() == null) {
                    return 1;
                } else if (o2.getPoolArea() == null) {
                    return -1;
                } else
                    return o1.getPoolArea().compareTo(o2.getPoolArea());

            }
        });

        return result;
    }


    @Transient
    public List<BusinessPool> getNowPools() {
        return getPoolsByType(BusinessPool.BusinessPoolType.NOW_POOL);
    }

    @Transient
    public List<BusinessPool> getNewPools() {
        return getPoolsByType(BusinessPool.BusinessPoolType.NEW_POOL);
    }

}
