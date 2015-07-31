package com.dgsoft.house.owner.business.subscribe.complete;

import com.dgsoft.common.system.business.TaskCompleteSubscribeComponent;
import com.dgsoft.house.owner.OwnerEntityHome;
import com.dgsoft.house.owner.OwnerEntityLoader;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.HouseBusiness;
import com.dgsoft.house.owner.model.HouseRecord;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

/**
 * Created by Administrator on 15-7-30.
 * 房屋档案
 */
@Name("houseRecordComplete")
public class HouseRecordComplete implements TaskCompleteSubscribeComponent {


    @In
    private OwnerBusinessHome ownerBusinessHome;

    @In(create = true)
    private OwnerEntityLoader ownerEntityLoader;

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
            HouseRecord houseRecord =ownerEntityLoader.getEntityManager().find(HouseRecord.class,houseBusiness.getHouseCode());
            if (houseRecord == null){
                houseRecord = new HouseRecord(houseBusiness.getAfterBusinessHouse(),houseBusiness.getAfterBusinessHouse().getHouseCode());
            }else{
                houseRecord.setBusinessHouse(houseBusiness.getAfterBusinessHouse());
            }
            houseBusiness.getAfterBusinessHouse().setHouseRecord(houseRecord);

        }
    }
}
