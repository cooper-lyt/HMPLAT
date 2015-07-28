package com.dgsoft.house.owner.business.subscribe.complete;

import com.dgsoft.common.system.business.TaskCompleteSubscribeComponent;
import com.dgsoft.house.HouseInfo;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.HouseBusiness;
import com.dgsoft.house.owner.model.HouseState;
import org.apache.poi.ss.formula.functions.Now;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import java.util.Date;

/**
 * Created by Administrator on 15-7-28.
 * 添加备案状态,
 */
@Name("addContractsRecord")
public class AddContractsRecord implements TaskCompleteSubscribeComponent {

    @In
    private OwnerBusinessHome ownerBusinessHome;


    private boolean have;

    @Override
    public void valid() {


    }



    @Override
    public boolean isPass() {
        return true;
    }



    @Override
    public void complete() {

        for (HouseBusiness houseBusiness:ownerBusinessHome.getInstance().getHouseBusinesses()){
            for (HouseState houseState:houseBusiness.getAfterBusinessHouse().getHouseStates()){
                 //if (houseState.getState().equals(HouseInfo.HouseStatus.CONTRACTS_RECORD)){
                  //   have = true;
                 //    break;
                // }
                 //if(!have){
                     HouseState state = new HouseState(houseBusiness.getAfterBusinessHouse(),HouseInfo.HouseStatus.CONTRACTS_RECORD,new Date());
                     houseBusiness.getAfterBusinessHouse().getHouseStates().add(state);
                // }
            }
        }




    }
}