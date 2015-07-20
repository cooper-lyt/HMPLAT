package com.dgsoft.house.owner.business.create;

import com.dgsoft.common.system.business.BusinessDataFill;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.BusinessPool;
import com.dgsoft.house.owner.model.HouseBusiness;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * Created by Administrator on 15-7-20.
 * 共有权人填充
 */
@Name("businessPoolFill")
@Scope(ScopeType.STATELESS)
public class BusinessPoolFill implements BusinessDataFill {

    @In
    private OwnerBusinessHome ownerBusinessHome;


    @Override
    public void fillData() {

       for (HouseBusiness houseBusiness:ownerBusinessHome.getInstance().getHouseBusinesses()){

           for(BusinessPool businessPool:houseBusiness.getStartBusinessHouse().getBusinessPools()){
               houseBusiness.getAfterBusinessHouse().getBusinessPools().add(businessPool);

           }
       }

    }
}
