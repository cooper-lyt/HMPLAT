package com.dgsoft.house.owner.business.subscribe.complete;

import com.dgsoft.common.system.business.TaskCompleteSubscribeComponent;
import com.dgsoft.house.HouseInfo;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.HouseBusiness;
import com.dgsoft.house.owner.model.HouseState;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;

import java.util.Date;

/**
 * Created by Administrator on 15-7-29.
 * 添加初始登记
 */
@Name("addInitReg")
public class AddInitReg implements TaskCompleteSubscribeComponent {


    @In
    private OwnerBusinessHome ownerBusinessHome;





    @In
    private FacesMessages facesMessages;

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
            //HouseState state = new HouseState(houseBusiness.getAfterBusinessHouse(), HouseInfo.HouseStatus.INIT_REG,new Date());
            houseBusiness.getAfterBusinessHouse().addStatus(HouseInfo.HouseStatus.INIT_REG);

        }




    }
}