package com.dgsoft.house.owner.business.subscribe.complete;

import com.dgsoft.common.system.business.BusinessInstance;
import com.dgsoft.common.system.business.TaskCompleteSubscribeComponent;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.HouseBusiness;
import com.dgsoft.house.owner.model.OwnerBusiness;
import com.dgsoft.house.owner.model.SubStatus;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Logging;

import java.util.Set;

/**
 * Created by cooper on 8/1/15.
 */
@Name("statusComplete")
public class StatusComplete implements TaskCompleteSubscribeComponent {


    @In
    private OwnerBusinessHome ownerBusinessHome;

    @Override
    public void valid() {
    }

    @Override
    public boolean isPass() {
        return true;
    }

    @Override
    public void complete() {
        if(!ownerBusinessHome.getInstance().getType().equals(BusinessInstance.BusinessType.NORMAL_BIZ)){
            ownerBusinessHome.getInstance().getSelectBusiness().setStatus(BusinessInstance.BusinessStatus.CANCEL);
            for(SubStatus subStatus: ownerBusinessHome.getInstance().getSelectBusiness().getSubStatuses()){
                subStatus.setStatus(BusinessInstance.BusinessStatus.CANCEL);
            }
        }
        ownerBusinessHome.getInstance().setStatus(BusinessInstance.BusinessStatus.COMPLETE);
        for(SubStatus subStatus: ownerBusinessHome.getInstance().getSubStatuses()){
            subStatus.setStatus(BusinessInstance.BusinessStatus.COMPLETE);
        }
    }
}
