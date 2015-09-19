package com.dgsoft.house.owner.business.subscribe;

import com.dgsoft.house.owner.OwnerEntityHome;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.HouseBusiness;
import com.dgsoft.house.owner.model.RecordStore;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Logging;

/**
 * Created by wxy on 2015-09-16.
 * 多房屋档案位置
 */
@Name("recordStoreHouseSubscribe")
public class RecordStoreHouseSubscribe extends OwnerEntityHome<RecordStore> {

    @In
    private OwnerBusinessHome ownerBusinessHome;



    @Override
    public void create(){
        super.create();
        if(!ownerBusinessHome.getInstance().getRecordStores().isEmpty()){
            setId(ownerBusinessHome.getInstance().getReasons().iterator().next().getId());
        }else{
            Logging.getLog(getClass()).debug("aaa--"+ownerBusinessHome.getInstance().getId());
            getInstance().setOwnerBusiness(ownerBusinessHome.getInstance());
            ownerBusinessHome.getInstance().getRecordStores().add(getInstance());



            for(HouseBusiness houseBusiness:ownerBusinessHome.getInstance().getHouseBusinesses()){
                Logging.getLog(getClass()).debug("bbb--"+houseBusiness.getHouseCode());
                houseBusiness.setRecordStore(getInstance());
                getInstance().getHouseBusiness().add(houseBusiness);
            }


        }
    }








}