package com.dgsoft.house.action;

import com.dgsoft.common.DataFormat;
import com.dgsoft.common.GBT;
import com.dgsoft.common.SetLinkList;
import com.dgsoft.common.system.DictionaryWord;
import com.dgsoft.common.system.model.Word;
import com.dgsoft.house.HouseEntityHome;
import com.dgsoft.house.HouseInfo;
import com.dgsoft.house.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage;
import org.jboss.seam.log.Logging;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by cooper on 7/29/14.
 */
@Name("buildHome")
public class BuildHome extends HouseEntityHome<Build> {

    @In
    private FacesMessages facesMessages;

    @In
    private Map<String, String> messages;

    @In
    private HouseCodeHelper houseCodeHelper;

    @In(required = false)
    private ProjectHome projectHome;

//    private SetLinkList<House> houses;
//
//    public SetLinkList<House> getHouses() {
//        if (houses == null) {
//            houses = new SetLinkList<House>(getInstance().getHouses());
//        }
//        return houses;
//    }

    private void addBuildMBBConflictMessages() {
        facesMessages.addFromResourceBundle(StatusMessage.Severity.ERROR, "ConflictMBB");
    }

    private void addBuildPBConflictMessages() {
        facesMessages.addFromResourceBundle(StatusMessage.Severity.ERROR, "ConfilicPB");
    }

    @Override
    protected boolean verifyUpdateAvailable() {


        if (getEntityManager().createQuery("select count(build.id) from Build build " +
                "where build.project.id = :projectId and build.devBuildNumber <> null and " +
                "build.devBuildNumber = :devBuildNumber and build.id <> :buildId", Long.class)
                .setParameter("projectId", getInstance().getProject().getId())
                .setParameter("devBuildNumber", getInstance().getDevBuildNumber())
                .setParameter("buildId", getInstance().getId()).getSingleResult() > 0) {
            addBuildPBConflictMessages();
            return false;
        }


        if (getEntityManager().createQuery("select count(build.id) from Build build " +
                "where build.mapNumber = :mapNumber and build.blockNo = :blockNumber and " +
                "build.buildNo = :buildNumber and build.id <> :buildId", Long.class)
                .setParameter("mapNumber", getInstance().getMapNumber())
                .setParameter("blockNumber", getInstance().getBlockNo())
                .setParameter("buildNumber", getInstance().getBuildNo())
                .setParameter("buildId", getInstance().getId()).getSingleResult() > 0) {
            addBuildMBBConflictMessages();
            return false;
        }

        if (getInstance().getFloorCount() <= 0){
            facesMessages.addFromResourceBundle(StatusMessage.Severity.ERROR, "FloorCountIsZeroError");
            return false;
        }

        return true;
    }

    @Override
    protected boolean verifyPersistAvailable() {

        if (getEntityManager().createQuery("select count(build.id) from Build build " +
                "where build.project.id = :projectId and build.devBuildNumber <> null and " +
                "build.devBuildNumber = :devBuildNumber", Long.class)
                .setParameter("projectId", projectHome.getInstance().getId())
                .setParameter("devBuildNumber", getInstance().getDevBuildNumber())
                .getSingleResult() > 0) {
            addBuildPBConflictMessages();
            return false;
        }


        if (getEntityManager().createQuery("select count(build.id) from Build build " +
                "where build.mapNumber = :mapNumber and build.blockNo = :blockNumber and " +
                "build.buildNo = :buildNumber", Long.class)
                .setParameter("mapNumber", getInstance().getMapNumber())
                .setParameter("blockNumber", getInstance().getBlockNo())
                .setParameter("buildNumber", getInstance().getBuildNo())
                .getSingleResult() > 0) {
            addBuildMBBConflictMessages();
            return false;
        }

        if (getInstance().getFloorCount() <= 0){
            facesMessages.addFromResourceBundle(StatusMessage.Severity.ERROR, "FloorCountIsZeroError");
            return false;
        }

        getInstance().setProject(projectHome.getInstance());
        houseCodeHelper.genBuildCode(getInstance());
        return true;
    }


    public boolean isHaveHouse() {
        return !getInstance().getHouses().isEmpty();
    }


    public void genBuildName() {

        Logging.getLog(getClass()).debug("genBuildName");
        String result = projectHome.getInstance().getDistrictName() +
                projectHome.getInstance().getProjectName();

        if ((getInstance().getBuildNo() != null) && !getInstance().getBuildNo().trim().equals("")) {
            result += getInstance().getBuildNo() + messages.get("MapIdentification_build");
        }

        if (getInstance().getDevBuildNumber() != null) {
            result += getInstance().getDevBuildNumber() + messages.get("BuildBuildNameSuffix");
        }

        getInstance().setName(result);
    }

    private String getBuildCode() {
        if (isManaged()) {
            return getInstance().getId().substring(0, 21);
        } else {
            throw new IllegalArgumentException("build not manager!");
        }
    }


    public String genHouseOrder() {
        String result = GBT.getJDJT246(getBuildCode(), getInstance().getNextHouseOrder());
        getInstance().setNextHouseOrder(getInstance().getNextHouseOrder() + 1);
        return result;
    }


    @Override
    protected boolean verifyRemoveAvailable() {
        if (isManaged()) {
            if (getEntityManager().createQuery("select count(house.id) from House house where house.build.id = :buildId", Long.class).
                    setParameter("buildId", getInstance().getId()).getSingleResult() > 0) {
                facesMessages.addFromResourceBundle(StatusMessage.Severity.ERROR, "BuildCantDelete");
                return false;
            }
        }
        return true;
    }


    public List<BuildGridMap> getBuildGridPages() {
        List<BuildGridMap> result = new ArrayList<BuildGridMap>(getInstance().getBuildGridMaps());
        Collections.sort(result, new Comparator<BuildGridMap>() {
            @Override
            public int compare(BuildGridMap o1, BuildGridMap o2) {
                return (new Integer(o1.getOrder())).compareTo(o2.getOrder());
            }
        });
        return result;
    }

    public boolean isHaveIdleHouse(){
        return getEntityManager().createQuery("select count(house.id) from House house where house.build.id=:buildId and house.gridBlockId = null ", Long.class)
                .setParameter("buildId", getId()).getSingleResult().compareTo(new Long(0)) > 0;
    }

//    private List<House> idleHouse;
//
//    private BuildGridMap buildGridMap;
//
//    private List<House> getAllIdleHouse() {
//        if (idleHouse == null)
//            idleHouse = getEntityManager().createQuery("select house from House house where house.build.id = :buildId and  (house.gridBlockId = null)", House.class).
//                    setParameter("buildId", getId()).getResultList();
//        return idleHouse;
//
//    }
//
//
//    public BuildGridMap getIdleHouseGridMap() {
//        if (buildGridMap == null) {
//            initIdleHouseGridMap();
//        }
//        return buildGridMap;
//    }
//
//    private void initIdleHouseGridMap() {
//        BuildGridMap result = new BuildGridMap(getInstance());
//
//
//        Map<String, HouseGridTitle> titleMap = new HashMap<String, HouseGridTitle>();
//
//        Map<String, Map<String, List<GridBlock>>> floorHouse = new HashMap<String, Map<String, List<GridBlock>>>();
//        for (House house : getAllIdleHouse()) {
//
//            Map<String, List<GridBlock>> unitHouses = floorHouse.get(house.getInFloorName().trim());
//            if (unitHouses == null) {
//                unitHouses = new HashMap<String, List<GridBlock>>();
//                floorHouse.put(house.getInFloorName().trim(), unitHouses);
//            }
//
//            String unitName = (house.getHouseUnitName() == null) ? "" : house.getHouseUnitName().trim();
//            List<GridBlock> blockHouses = unitHouses.get(unitName);
//            HouseGridTitle title = titleMap.get(unitName);
//            if (blockHouses == null) {
//                blockHouses = new ArrayList<GridBlock>();
//                unitHouses.put(unitName, blockHouses);
//            }
//            blockHouses.add(new GridBlock(house, 1, 1));
//            if (title == null) {
//                title = new HouseGridTitle(result, 0, unitName);
//                titleMap.put(unitName, title);
//                result.getHouseGridTitles().add(title);
//            }
//        }
//
//
//        for (Map.Entry<String, Map<String, List<GridBlock>>> floorEntry : floorHouse.entrySet()) {
//            for (Map.Entry<String, List<GridBlock>> unitEntry : floorEntry.getValue().entrySet()) {
//                int houseCount = unitEntry.getValue().size();
//                HouseGridTitle title = titleMap.get(unitEntry.getKey());
//                if (title.getColspan() < houseCount) {
//                    title.setColspan(houseCount);
//                }
//            }
//        }
//
//
//        for (Map.Entry<String, Map<String, List<GridBlock>>> floorEntry : floorHouse.entrySet()) {
//            Integer index = DataFormat.strToInt(floorEntry.getKey());
//            GridRow row = new GridRow(result, floorEntry.getKey(), (index == null) ? -999 : index);
//            result.getGridRows().add(row);
//
//            List<GridBlock> blockList = new ArrayList<GridBlock>();
//            for (Map.Entry<String, List<GridBlock>> unitEntry : floorEntry.getValue().entrySet()) {
//
//                Collections.sort(unitEntry.getValue(), new Comparator<GridBlock>() {
//                    @Override
//                    public int compare(GridBlock o1, GridBlock o2) {
//                        return HouseInfo.OrderComparator.getInstance().compare(o1.getHouse().getHouseOrder(), o2.getHouse().getHouseOrder());
//                    }
//                });
//
//                blockList.addAll(unitEntry.getValue());
//
//                int colspan = titleMap.get(unitEntry.getKey()).getColspan();
//                if (unitEntry.getValue().size() < colspan) {
//                    for (int i = unitEntry.getValue().size() + 1; i <= colspan; i++) {
//                        blockList.add(new GridBlock(1, 1));
//                    }
//                }
//            }
//
//            for (GridBlock block : blockList) {
//                block.setOrder(blockList.indexOf(block));
//            }
//            row.getGridBlocks().addAll(blockList);
//        }
//
//
//        List<HouseGridTitle> titles = new ArrayList<HouseGridTitle>(result.getHouseGridTitles());
//        Collections.sort(titles, new Comparator<HouseGridTitle>() {
//            @Override
//            public int compare(HouseGridTitle o1, HouseGridTitle o2) {
//                return HouseInfo.OrderComparator.getInstance().compare(o1.getTitle(), o2.getTitle());
//            }
//        });
//        result.getHouseGridTitles().add(new HouseGridTitle(result, 0, "", 1));
//
//        for (HouseGridTitle title : titles) {
//            title.setOrder(titles.indexOf(title) + 1);
//        }
//
//
//        List<GridRow> rows = new ArrayList<GridRow>(result.getGridRows());
//        Collections.sort(rows, new Comparator<GridRow>() {
//            @Override
//            public int compare(GridRow o1, GridRow o2) {
//                return new Integer(o2.getFloorIndex()).compareTo(o1.getFloorIndex());
//            }
//        });
//
//        for (GridRow row : rows) {
//            row.setOrder(rows.indexOf(row));
//        }
//        buildGridMap = result;
//    }

    public BigDecimal getTotalHouseArea() {
        BigDecimal result = BigDecimal.ZERO;
        for (House house : getInstance().getHouses()) {
            result = result.add(house.getHouseArea());
        }
        return result;
    }

    public BigDecimal getTotalHouseUseArea() {
        BigDecimal result = BigDecimal.ZERO;
        for (House house : getInstance().getHouses()) {
            result = result.add(house.getUseArea());
        }
        return result;
    }

//    public Map<HouseInfo.HouseStatus, CountAreaEntry> getStatusTotalMap() {
//        Map<HouseInfo.HouseStatus, CountAreaEntry> result = new HashMap<HouseInfo.HouseStatus, CountAreaEntry>();
//        for (House house : getInstance().getHouses()) {
//            CountAreaEntry entry = result.get(house.getMasterStatus());
//            if (entry == null) {
//                result.put(house.getMasterStatus(), new CountAreaEntry(house.getHouseArea(), house.getUseArea()));
//            } else {
//                entry.addArea(house.getHouseArea(), house.getUseArea());
//            }
//        }
//        return result;
//    }

//    public List<Map.Entry<HouseInfo.HouseStatus, CountAreaEntry>> getStatusTotalList() {
//        List<Map.Entry<HouseInfo.HouseStatus, CountAreaEntry>> result = new ArrayList<Map.Entry<HouseInfo.HouseStatus, CountAreaEntry>>(getStatusTotalMap().entrySet());
//        Collections.sort(result, new Comparator<Map.Entry<HouseInfo.HouseStatus, CountAreaEntry>>() {
//            @Override
//            public int compare(Map.Entry<HouseInfo.HouseStatus, CountAreaEntry> o1, Map.Entry<HouseInfo.HouseStatus, CountAreaEntry> o2) {
//                return HouseInfo.StatusComparator.getInstance().compare(o1.getKey(), o2.getKey());
//            }
//        });
//        return result;
//    }

    public Map<Word, CountAreaEntry> getUseTypeTotalMap() {
        Map<Word, CountAreaEntry> result = new HashMap<Word, CountAreaEntry>();
        for (House house : getInstance().getHouses()) {
            CountAreaEntry entry = result.get(DictionaryWord.instance().getWord(house.getUseType()));
            if (entry != null) {
                entry.addArea(house.getHouseArea(), house.getUseArea());
            } else {
                result.put(DictionaryWord.instance().getWord(house.getUseType()),
                        new CountAreaEntry(house.getHouseArea(), house.getUseArea()));
            }
        }
        return result;
    }

    public List<Map.Entry<Word, CountAreaEntry>> getUseTypeTotalList() {
        List<Map.Entry<Word, CountAreaEntry>> result = new ArrayList<Map.Entry<Word, CountAreaEntry>>(getUseTypeTotalMap().entrySet());
        Collections.sort(result, new Comparator<Map.Entry<Word, CountAreaEntry>>() {
            @Override
            public int compare(Map.Entry<Word, CountAreaEntry> o1, Map.Entry<Word, CountAreaEntry> o2) {

                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return new Integer(o1.getKey().getPriority()).compareTo(o2.getKey().getPriority());
            }
        });
        return result;
    }

    public static class CountAreaEntry {

        public CountAreaEntry(BigDecimal area, BigDecimal useArea) {
            this.count = 1;
            this.area = area;
            this.useArea = useArea;
        }

        private int count;

        private BigDecimal area;

        private BigDecimal useArea;

        public void addArea(BigDecimal area, BigDecimal useArea) {
            count++;
            this.area = this.area.add(area);
            this.useArea = this.useArea.add(useArea);
        }

        public int getCount() {
            return count;
        }


        public BigDecimal getArea() {
            return area;
        }


        public BigDecimal getUseArea() {
            return useArea;
        }

    }


}
