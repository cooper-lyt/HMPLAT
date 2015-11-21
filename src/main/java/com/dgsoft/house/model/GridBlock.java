package com.dgsoft.house.model;
// Generated Jul 12, 2013 11:32:23 AM by Hibernate Tools 4.0.0

import com.dgsoft.house.HouseInfo;
import com.dgsoft.house.HouseStatus;
import com.dgsoft.house.owner.model.LockedHouse;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * GridBlock generated by hbm2java
 */
@Entity
@Table(name = "GRID_BLOCK", catalog = "HOUSE_INFO")
public class GridBlock implements java.io.Serializable {

    private String id;
    private GridRow gridRow;
    private int order;
    private int colspan;
    private int rowspan;
    private int unitIndex;
    private String unitName;
    private BigDecimal area;
    private BigDecimal useArea;
    private BigDecimal commArea;
    private BigDecimal shineArea;
    private BigDecimal loftArea;
    private BigDecimal commParam;
    private String useType;
    private String structure;
    private String houseType;
    private String houseOrder;

    private String direction;
    private String eastWall;
    private String westWall;
    private String southWall;
    private String northWall;
    private String knotSize;

    private String houseCode;
    private String floorName;

    private boolean haveDownRoom;

    public GridBlock() {
    }

    public GridBlock(HouseInfo house, int colspan, int rowspan) {
        this.colspan = colspan;
        this.rowspan = rowspan;
        setHouse(house);
    }

    public GridBlock(int colspan, int rowspan) {
        this.colspan = colspan;
        this.rowspan = rowspan;
    }

    public GridBlock(String id, GridRow gridRow, int order, int colspan,
                     int rowspan, int unitIndex, String unitName, BigDecimal area,
                     BigDecimal useArea, BigDecimal commArea, BigDecimal shineArea,
                     BigDecimal loftArea, BigDecimal commParam, String useType,
                     String structure, String houseType, String houseOrder,
                     String direction, String eastWall, String westWall,
                     String southWall, String northWall, String knotSize,boolean haveDownRoom,String floorName) {
        this.gridRow = gridRow;
        this.order = order;
        this.colspan = colspan;
        this.rowspan = rowspan;
        this.unitIndex = unitIndex;
        this.unitName = unitName;
        this.area = area;
        this.useArea = useArea;
        this.commArea = commArea;
        this.shineArea = shineArea;
        this.loftArea = loftArea;
        this.commParam = commParam;
        this.useType = useType;
        this.structure = structure;
        this.houseType = houseType;
        this.id = id;
        this.houseOrder = houseOrder;
        this.direction = direction;
        this.eastWall = eastWall;
        this.westWall = westWall;
        this.southWall = southWall;
        this.northWall = northWall;
        this.knotSize = knotSize;
        this.haveDownRoom = haveDownRoom;
        this.floorName = floorName;
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
    @JoinColumn(name = "ROW_ID", nullable = false)
    @NotNull
    public GridRow getGridRow() {
        return this.gridRow;
    }

    public void setGridRow(GridRow gridRow) {
        this.gridRow = gridRow;
    }

    @Column(name = "_ORDER", nullable = false)
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Column(name = "COLSPAN", nullable = false)
    public int getColspan() {
        return this.colspan;
    }

    public void setColspan(int colspan) {
        this.colspan = colspan;
    }

    @Column(name = "ROWSPAN", nullable = false)
    public int getRowspan() {
        return this.rowspan;
    }

    public void setRowspan(int rowspan) {
        this.rowspan = rowspan;
    }

    @Column(name = "UNIT_INDEX")
    @NotNull
    public int getUnitIndex() {
        return unitIndex;
    }

    public void setUnitIndex(int unitIndex) {
        this.unitIndex = unitIndex;
    }

    @Column(name = "UNIT_NAME", length = 32)
    @NotNull
    @Size(max = 32)
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Column(name = "AREA", precision = 18, scale = 3)
    public BigDecimal getArea() {
        return this.area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
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

    @Column(name = "SHINE_AREA", precision = 18, scale = 3)
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

    @Column(name = "USE_TYPE", length = 32)
    @Size(max = 32)
    public String getUseType() {
        return this.useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    @Column(name = "STRUCTURE", length = 32)
    @Size(max = 32)
    public String getStructure() {
        return this.structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Column(name = "HOUSE_TYPE", length = 32)
    @Size(max = 32)
    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    @Column(name = "HOUSE_ORDER", nullable = true)
    @Size(max = 20)
    public String getHouseOrder() {
        return houseOrder;
    }

    public void setHouseOrder(String houseOrder) {
        this.houseOrder = houseOrder;
    }

    @Column(name = "DIRECTION",nullable = true, length = 32)
    @Size(max = 32)
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Column(name = "EAST_WALL",nullable = true, length = 32)
    @Size(max = 32)
    public String getEastWall() {
        return eastWall;
    }

    public void setEastWall(String eastWall) {
        this.eastWall = eastWall;
    }

    @Column(name = "WEST_WALL",nullable = true, length = 32)
    @Size(max = 32)
    public String getWestWall() {
        return westWall;
    }

    public void setWestWall(String westWall) {
        this.westWall = westWall;
    }

    @Column(name = "SOUTH_WALL",nullable = true, length = 32)
    @Size(max = 32)
    public String getSouthWall() {
        return southWall;
    }

    public void setSouthWall(String southWall) {
        this.southWall = southWall;
    }

    @Column(name = "NORTH_WALL",nullable = true, length = 32)
    @Size(max = 32)
    public String getNorthWall() {
        return northWall;
    }

    public void setNorthWall(String northWall) {
        this.northWall = northWall;
    }

    @Column(name = "KNOT_SIZE",nullable = true, length = 32)
    @Size(max = 32)
    public String getKnotSize() {
        return knotSize;
    }

    public void setKnotSize(String knotSize) {
        this.knotSize = knotSize;
    }

    @Column(name = "HAVE_DOWN_ROOM",nullable = false)
    public boolean isHaveDownRoom() {
        return haveDownRoom;
    }

    public void setHaveDownRoom(boolean haveDownRoom) {
        this.haveDownRoom = haveDownRoom;
    }

    @Column(name = "HOUSE_CODE",nullable = true, length = 32)
    @Size(max = 32)
    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    @Column(name="FLOOR_NAME",nullable = true , length = 32)
    @Size(max = 32)
    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    @Transient
    private HouseInfo house;
    @Transient
    public HouseInfo getHouse() {
        return house;
    }
    @Transient
    public void setHouse(HouseInfo house) {
        this.house = house;
        if (house == null){
            this.houseCode = null;
        }else
            this.houseCode = house.getHouseCode();
    }

    @Transient
    private String OwnerName;

    @Transient
    private HouseStatus houseStatus;

    @Transient
    private List<LockedHouse> lockedHouseList = new ArrayList<LockedHouse>(0);

    @Transient
    private boolean selected;

    @Transient
    private String inBizName;

    @Transient
    public boolean isSelected() {
        return selected;
    }

    @Transient
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Transient
    public List<LockedHouse> getLockedHouseList() {
        return lockedHouseList;
    }

    @Transient
    public void setLockedHouseList(List<LockedHouse> lockedHouseList) {
        if (lockedHouseList == null){
            this.lockedHouseList = new ArrayList<LockedHouse>(0);
        }else
            this.lockedHouseList = lockedHouseList;
    }
    @Transient
    public String getInBizName() {
        return inBizName;
    }
    @Transient
    public void setInBizName(String inBizName) {
        this.inBizName = inBizName;
    }

    @Transient
    public String getOwnerName() {
        return OwnerName;
    }
    @Transient
    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }
    @Transient
    public HouseStatus getHouseStatus() {
        return houseStatus;
    }
    @Transient
    public void setHouseStatus(HouseStatus houseStatus) {
        this.houseStatus = houseStatus;
    }

    @Transient
    @Deprecated
    private boolean locked = false;

    @Transient
    @Deprecated
    public boolean isLocked() {
        return locked;
    }
    @Transient
    @Deprecated
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
