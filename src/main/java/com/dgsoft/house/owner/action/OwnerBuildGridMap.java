package com.dgsoft.house.owner.action;

import com.dgsoft.house.HouseEntityLoader;
import com.dgsoft.house.action.BuildHome;
import com.dgsoft.house.model.*;
import com.dgsoft.house.owner.OwnerEntityLoader;
import com.dgsoft.house.owner.model.BusinessHouse;
import com.dgsoft.house.owner.model.HouseBusiness;
import com.dgsoft.house.owner.model.HouseRecord;
import com.dgsoft.house.owner.model.OwnerBusiness;
import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.log.Logging;

import javax.persistence.NoResultException;
import java.util.*;

/**
 * Created by cooper on 6/12/15.
 */

@Name("ownerBuildGridMap")
@Scope(ScopeType.CONVERSATION)
public class OwnerBuildGridMap {

    @In(required = false)
    private BuildHome buildHome;


    @In(create = true)
    private OwnerEntityLoader ownerEntityLoader;

    @In(create = true)
    private HouseEntityLoader houseEntityLoader;

    private BuildGridMap curMap;

    private List<BuildGridMap> buildGridMaps = new ArrayList<BuildGridMap>(0);

    private BusinessHouse selectBizHouse;

    private boolean dataTableList;

    private String mapNumber;

    private String blockNumber;

    private String buildNumber;

    private String houseOrder;

    private List<BusinessHouse> resultBusinessHouse = new ArrayList<BusinessHouse>();

    public String getMapNumber() {
        return mapNumber;
    }

    public void setMapNumber(String mapNumber) {
        this.mapNumber = mapNumber;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public BusinessHouse getSelectBizHouse() {
        return selectBizHouse;
    }

    public void setSelectBizHouse(BusinessHouse selectBizHouse) {
        this.selectBizHouse = selectBizHouse;
    }

    public boolean isDataTableList() {
        return dataTableList;
    }

    public void setDataTableList(boolean dataTableList) {
        this.dataTableList = dataTableList;
    }

    public String getHouseOrder() {
        return houseOrder;
    }

    public void setHouseOrder(String houseOrder) {
        this.houseOrder = houseOrder;
    }

    public String getSelectBizHouseId(){
        if (selectBizHouse == null){
            return null;
        }
        return selectBizHouse.getHouseCode();
    }

    public void setSelectBizHouseId(String id){
        if ((id == null) || id.trim().equals("")){
            selectBizHouse = null;
        }


        for(BusinessHouse businessHouse: resultBusinessHouse){
            if (businessHouse.getHouseCode().equals(id)){
                selectBizHouse = businessHouse;
                return;
            }
        }

        Logging.getLog(getClass()).warn("houseCode not found in map");
        selectBizHouse = null;
    }

    public void setId(String buildId){
        if ((buildId == null) || buildId.trim().equals("")){
           curMap = null;
        }
        for(BuildGridMap map: buildGridMaps){
            if (map.getId().equals(buildId)){
                curMap = map;
                return;
            }
        }
    }

    public String getId(){
        if (curMap == null){
            return null;
        }
        return curMap.getId();
    }

    public BuildGridMap getCurMap() {
        return curMap;
    }

    public List<BusinessHouse> getResultBusinessHouse() {
        return resultBusinessHouse;
    }

    public List<BuildGridMap> getBuildGridMaps() {
        return buildGridMaps;
    }

    public void findBuildBySection(){

        mapNumber = buildHome.getInstance().getMapNumber();
        blockNumber = buildHome.getInstance().getBlockNo();
        buildNumber = buildHome.getInstance().getBuildNo();
        initBuildMap();
    }

    public void findBuildByNumber() {
        try {
            buildHome.setId(
                    houseEntityLoader.getEntityManager().createQuery("select build.id from Build build where build.mapNumber = :mapNumber and build.blockNo = :blockNumber and build.buildNo = :buildNumber", String.class)
                            .setParameter("mapNumber", mapNumber).setParameter("blockNumber", blockNumber).setParameter("buildNumber", buildNumber).getSingleResult());

            initBuildMap();
        } catch (NoResultException e) {
            buildHome.clearInstance();
            dataTableList = false;
        }
    }

    private List<BusinessHouse> unionHouse(Collection<House> houses, List<BusinessHouse> businessHouses){
        Map<String,BusinessHouse> businessHouseMap = new HashMap<String, BusinessHouse>();
        for (BusinessHouse businessHouse: businessHouses){
            businessHouseMap.put(businessHouse.getHouseCode(),businessHouse);
        }
        List<BusinessHouse> result = new ArrayList<BusinessHouse>();
        for(House house: houses){

            BusinessHouse businessHouse = businessHouseMap.get(house.getHouseCode());
            if(businessHouse == null){
                result.add(new BusinessHouse(house));
            }else{
                result.add(businessHouse);
                businessHouseMap.remove(businessHouse.getHouseCode());
            }
        }
        result.addAll(businessHouseMap.values());
        return result;
    }


    private void findHouseByOrder(List<House> houses, List<BusinessHouse> businessHouses){

        resultBusinessHouse = unionHouse(houses,businessHouses);


        if (resultBusinessHouse.size() == 1){
            selectBizHouse = resultBusinessHouse.get(0);
        }else{
            selectBizHouse = null;
        }


        buildHome.clearInstance();
        buildGridMaps = new ArrayList<BuildGridMap>(0);
        dataTableList = true;
    }

    public void findHouseBySection(){


        findHouseByOrder(houseEntityLoader.getEntityManager().createQuery("select house from House house where house.build.id = :buildCode  and house.houseOrder = :houseOrder", House.class)
                        .setParameter("buildCode",buildHome.getInstance().getId())
                        .setParameter("houseOrder", houseOrder). getResultList(),
                ownerEntityLoader.getEntityManager().createQuery("select houseRecord.businessHouse from HouseRecord houseRecord left join fetch houseRecord.businessHouse.businessHouseOwner where houseRecord.businessHouse.buildCode = :buildCode and houseRecord.businessHouse.houseOrder = :houseOrder", BusinessHouse.class)
                        .setParameter("buildCode",buildHome.getInstance().getId())
                        .setParameter("houseOrder",houseOrder).getResultList());


    }

    public void findHouseByNumber(){

        findHouseByOrder(houseEntityLoader.getEntityManager().createQuery("select house from House house where house.build.mapNumber = :mapNumber and house.build.blockNo = :blockNumber and house.build.buildNo =:buildNumber and house.houseOrder = :houseOrder", House.class)
                .setParameter("mapNumber",mapNumber)
                .setParameter("blockNumber", blockNumber)
                .setParameter("buildNumber", buildNumber)
                .setParameter("houseOrder", houseOrder). getResultList(),
                ownerEntityLoader.getEntityManager().createQuery("select houseRecord.businessHouse from HouseRecord houseRecord left join fetch houseRecord.businessHouse.businessHouseOwner where houseRecord.businessHouse.mapNumber = :mapNumber and houseRecord.businessHouse.blockNo = :blockNumber and houseRecord.businessHouse.buildNo = :buildNumber and houseRecord.businessHouse.houseOrder = :houseOrder", BusinessHouse.class)
                .setParameter("mapNumber",mapNumber)
                .setParameter("blockNumber",blockNumber)
                .setParameter("buildNumber",buildNumber)
                .setParameter("houseOrder",houseOrder).getResultList());

    }


    public void initBuildMap(){


        resultBusinessHouse.clear();
        buildGridMaps = new ArrayList<BuildGridMap>(buildHome.getInstance().getBuildGridMaps());
        Collections.sort(buildGridMaps, new Comparator<BuildGridMap>() {
            @Override
            public int compare(BuildGridMap o1, BuildGridMap o2) {
                return (new Integer(o1.getOrder())).compareTo(o2.getOrder());
            }
        });



        Map<String,House> houseMap = new HashMap<String, House>();
        for (House house: buildHome.getInstance().getHouses()){
            houseMap.put(house.getHouseCode(),house);
        }

        List<BusinessHouse> houseRecords = ownerEntityLoader.getEntityManager().createQuery("select houseRecord.businessHouse from HouseRecord houseRecord left join fetch houseRecord.businessHouse.businessHouseOwner where (houseRecord.businessHouse.buildCode = :buildCode) or (houseRecord.businessHouse.mapNumber =:mapNumber and  houseRecord.businessHouse.blockNo =:blockNumber and houseRecord.businessHouse.buildNo =:buildNumber)", BusinessHouse.class)
                .setParameter("buildCode", buildHome.getInstance().getId())
                .setParameter("mapNumber", buildHome.getInstance().getMapNumber())
                .setParameter("blockNumber",buildHome.getInstance().getBlockNo())
                .setParameter("buildNumber",buildHome.getInstance().getBuildNo())
                .getResultList();


        resultBusinessHouse = unionHouse(buildHome.getInstance().getHouses(),houseRecords);

        Map<String,BusinessHouse> businessHouseMap = new HashMap<String, BusinessHouse>();
        for (BusinessHouse house: resultBusinessHouse){
            businessHouseMap.put(house.getHouseCode(),house);
        }

        List<String> houseCodes = new ArrayList<String>();
        for (BusinessHouse house: resultBusinessHouse){
            houseCodes.add(house.getHouseCode());
        }

        List<String> lockedHouseCode = ownerEntityLoader.getEntityManager().createQuery("select lockedHouse.houseCode from LockedHouse lockedHouse where lockedHouse.houseCode in (:houseCodes)", String.class)
                .setParameter("houseCodes", houseCodes).getResultList();

        List<String> inBusinessHouseCode = ownerEntityLoader.getEntityManager().createQuery("select houseBusiness.houseCode from HouseBusiness houseBusiness where (houseBusiness.ownerBusiness.status in (:runingStatus)) and houseBusiness.startBusinessHouse.houseCode in (:houseCodes)")
                .setParameter("houseCodes", houseCodes).setParameter("runingStatus", OwnerBusiness.BusinessStatus.runningStatus()).getResultList();

        lockedHouseCode.addAll(inBusinessHouseCode);
        for(BuildGridMap map: buildGridMaps){
            for(GridRow row: map.getGridRows()){
                for(GridBlock block: row.getGridBlocks()){
                    BusinessHouse house = null;
                    if ((block.getHouseCode() != null) && !block.getHouseCode().trim().equals(""))
                        house = businessHouseMap.get(block.getHouseCode());
                    if (house != null){
                        block.setHouse(house);
                        block.setLocked(lockedHouseCode.contains(house.getHouseCode()));
                        houseMap.remove(house.getHouseCode());
                    }
                }
            }

        }

        if (! houseMap.isEmpty()){
            List<BusinessHouse> idleHouses = new ArrayList<BusinessHouse>(houseMap.size());

            for (House house: houseMap.values()){
                BusinessHouse businessHouse = businessHouseMap.get(house.getHouseCode());
                idleHouses.add(businessHouse);
            }

            BuildGridMap idleMap = BuildHome.genIdleHouseGridMap(idleHouses,lockedHouseCode);
            idleMap.setId("idleHouse");
            buildGridMaps.add(idleMap);

        }

        if (!buildGridMaps.isEmpty()){
            curMap = buildGridMaps.get(0);
            dataTableList = false;
        }else{
            dataTableList = true;
        }
    }

}
