package com.dgsoft.house.action;

import com.dgsoft.common.GBT;
import com.dgsoft.common.SetLinkList;
import com.dgsoft.common.system.NumberBuilder;
import com.dgsoft.common.system.RunParam;
import com.dgsoft.common.system.model.NumberPool;
import com.dgsoft.common.system.model.SystemParam;
import com.dgsoft.house.HouseEntityHome;
import com.dgsoft.house.model.Build;
import com.dgsoft.house.model.House;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by cooper on 7/29/14.
 */
@Name("buildHome")
public class BuildHome extends HouseEntityHome<Build> {


    private SetLinkList<House> houses;

    public SetLinkList<House> getHouses() {
        if (houses == null){
            houses = new SetLinkList<House>(getInstance().getHouses());
        }
        return houses;
    }

    @Override
    protected void initInstance(){
        super.initInstance();
        houses = null;
    }

    public boolean isHaveHouse() {
        return !getInstance().getHouses().isEmpty();
    }

    private String getBuildCode() {
        if (isManaged()) {
            return getInstance().getId().substring(0,21);
        } else {
            throw new IllegalArgumentException("build not manager!");
        }
    }


    private String genHouseOrder() {
        String result = GBT.getJDJT246(getBuildCode(), getInstance().getNextHouseOrder());
        getInstance().setNextHouseOrder(getInstance().getNextHouseOrder() + 1);
        return result;
    }

    @Override
    protected boolean wire(){
        for(House house: getHouses()){
            if ((house.getId() == null) || (house.getId().trim().equals(""))){
                house.setId(genHouseOrder());
            }
        }
        return true;
    }

    @Override
    protected boolean verifyUpdateAvailable() {
        //TODO verify House Data
        return true;
    }

}
