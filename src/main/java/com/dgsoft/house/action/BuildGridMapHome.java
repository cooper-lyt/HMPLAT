package com.dgsoft.house.action;

import com.dgsoft.house.HouseEntityHome;
import com.dgsoft.house.model.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Logging;
import org.richfaces.event.DropEvent;
import org.richfaces.event.DropListener;
import org.richfaces.event.FileUploadEvent;


import java.math.BigDecimal;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: cooperlee
 * Date: 8/2/13
 * Time: 3:06 PM
 */
@Name("buildGridMapHome")
public class BuildGridMapHome extends HouseEntityHome<BuildGridMap> implements DropListener {

    @In
    private BuildHome buildHome;


    private boolean replaceGridMap;



    public boolean isReplaceGridMap() {
        return replaceGridMap;
    }

    public void setReplaceGridMap(boolean replaceGridMap) {
        this.replaceGridMap = replaceGridMap;
    }

    @Override
    public void create(){
        super.create();
        List<BuildGridMap> gridMaps = buildHome.getBuildGridPages();
        if (!isIdDefined() && buildHome.isIdDefined() && !gridMaps.isEmpty()){
            setId(gridMaps.get(0).getId());
            //TODO getIdleHouse
        }
    }

    public void deleteToIdle(){
        buildHome.getInstance().getBuildGridMaps().remove(getInstance());

    }


    public void templeteFileUploadListener(FileUploadEvent event) throws Exception {

        if (isManaged()) {
            getEntityManager().remove(getInstance());
        }
        SAXReader reader = new SAXReader();
        Document doc = reader.read(event.getUploadedFile().getInputStream());
        Element root = doc.getRootElement();
        if (replaceGridMap){


            buildHome.getInstance().getBuildGridMaps().remove(getInstance());
        }
        clearInstance();
        setInstance(analyzeTemplete(root));

        Logging.getLog(getClass()).debug("replaceGridMap:" + replaceGridMap);



        if (buildHome.isHaveHouse()){
            fillHouse();
        }else{
            generateHouse();
        }

    }

    private BuildGridMap analyzeTemplete(Element rootElement) {
        BuildGridMap result = new BuildGridMap();
        result.setName(buildHome.getInstance().getName());
        buildHome.getInstance().getBuildGridMaps().add(result);
        result.setBuild(buildHome.getInstance());
        Iterator<Element> iterator = rootElement.element("HEAD").elementIterator();
        int i = 0;
        while (iterator.hasNext()) {
            Element unitElement = iterator.next();
            result.getHouseGridTitles().add(
                    new HouseGridTitle(result, i,
                            unitElement.attributeValue("title", ""),
                            Integer.parseInt(unitElement.attributeValue("colSpan", "1"))));
            i++;
        }
        iterator = rootElement.element("BODY").elementIterator();
        i = 0;
        while (iterator.hasNext()) {
            Element floorElement = iterator.next();
            GridRow floor = new GridRow(result, floorElement.attributeValue("title", ""), i,
                    Integer.parseInt(floorElement.attributeValue("floor", "0")));
            Iterator<Element> houseIterator = floorElement.elementIterator();
            int j = 0;
            while (houseIterator.hasNext()) {
                Element houseElement = houseIterator.next();

                floor.getGridBlocks().add(new GridBlock(UUID.randomUUID().toString().replace("-", "").toUpperCase(), floor, j,
                        Integer.parseInt(houseElement.attributeValue("colSpan", "1")),
                        Integer.parseInt(houseElement.attributeValue("RowSpan", "1")),
                        Integer.parseInt(houseElement.attributeValue("UnitIndex", "1")),
                        houseElement.attributeValue("UnitName", ""),
                        new BigDecimal(houseElement.attributeValue("Area", "0")),
                        new BigDecimal(houseElement.attributeValue("UseArea", "0")),
                        new BigDecimal(houseElement.attributeValue("CommArea", "0")),
                        new BigDecimal(houseElement.attributeValue("ShineArea", "0")),
                        new BigDecimal(houseElement.attributeValue("LoftArea", "0")),
                        new BigDecimal(houseElement.attributeValue("CommParam", "0")),
                        houseElement.attributeValue("UseType", ""),
                        houseElement.attributeValue("Structure", ""),
                        houseElement.attributeValue("HouseType", ""),
                        houseElement.attributeValue("Order",""),
                        houseElement.attributeValue("Direction",""),
                        houseElement.attributeValue("EastWall",""),
                        houseElement.attributeValue("WestWall",""),
                        houseElement.attributeValue("SouthWall",""),
                        houseElement.attributeValue("NorthWall",""),
                        houseElement.attributeValue("KnotSize","")
                ));

                j++;
            }

            result.getGridRows().add(floor);
            i++;
        }
        return result;
    }


    public List<Integer> getColList() {
        List<Integer> result = new ArrayList<Integer>();
        for (HouseGridTitle title : getInstance().getHouseGridTitles()) {
            for (int i = 0; i < title.getColspan(); i++) {
                result.add(i);
            }
        }
        return result;
    }


    private List<House> idleHouses = new ArrayList<House>();

    public List<House> getIdleHouses() {
        return idleHouses;
    }

    public void setIdleHouses(List<House> idleHouses) {
        this.idleHouses = idleHouses;
    }

    public void fillHouse(){

    }

    public void generateHouse() {
        //TODO other info
        log.debug("generate House");

        for (GridRow row : getInstance().getGridRowList()) {

            for (GridBlock block : row.getGridBlockList()) {
                House newHouse = new House(buildHome.getInstance(),block);
                block.setHouse(newHouse);
                buildHome.getHouses().add(newHouse);
            }

        }
    }

    private String selectBlockId;

    private GridBlock operBlock;

    public String getSelectBlockId() {
        return selectBlockId;
    }

    public void setSelectBlockId(String selectBlockId) {
        this.selectBlockId = selectBlockId;
    }

    public GridBlock getOperBlock() {
        if ((operBlock == null) || (!operBlock.getId().equals(selectBlockId))){
            operBlock = null;
            for (GridRow row : getInstance().getGridRowList()) {
                for (GridBlock block : row.getGridBlocks()) {
                    if (block.getId().equals(selectBlockId)) {
                        operBlock = block;
                        return operBlock;

                    }
                }
            }
        }
        return operBlock;
    }

    public void idleHouse() {
        GridBlock block = getOperBlock();
        if (block != null) {
            if (block.getHouse() != null) {
                idleHouses.add(block.getHouse());
                block.getHouse().getGridBlock().clear();
                block.setHouse(null);

            }
        }
    }

    private boolean deleteHouse(House house){
        if (getEntityManager().contains(house)) {
            //TODO if canDelete
            house.getGridBlock().clear();
            buildHome.getHouses().remove(house);
            return true;
        }
        return true;
    }

    public void deleteHouse() {
        GridBlock block = getOperBlock();
        if (block != null) {
            if (block.getHouse() != null) {
                if (deleteHouse(block.getHouse())){
                    block.setHouse(null);
                }
            }

        }
    }

    public void deleteIdleHouse(){
        for (House house: idleHouses){
            if (house.getId().equals(selectBlockId)){
                if (deleteHouse(house)){
                    idleHouses.remove(house);
                }
                return;
            }
        }
    }

    @Override
    public void processDrop(DropEvent dropEvent) {
        log.debug("processDrop");

        GridBlock targetBlock = (GridBlock) dropEvent.getDropValue();
        if(dropEvent.getDragValue() instanceof GridBlock){

            House tempHouse = targetBlock.getHouse();
            targetBlock.setHouse(((GridBlock) dropEvent.getDragValue()).getHouse());
            ((GridBlock) dropEvent.getDragValue()).setHouse(tempHouse);
        }else if (dropEvent.getDragValue() instanceof House){
            House tempHouse = (House)dropEvent.getDragValue();
            if (targetBlock.getHouse() != null){
                idleHouses.add(targetBlock.getHouse());
            }
            targetBlock.setHouse(tempHouse);
            idleHouses.remove(tempHouse);
        }else {
            House newHouse = new House(buildHome.getInstance(),targetBlock);
            targetBlock.setHouse(newHouse);
            buildHome.getHouses().add(newHouse);
        }
    }

}
