package com.dgsoft.house.owner.business.subscribe.complete;

import com.dgsoft.common.system.business.TaskCompleteSubscribeComponent;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.HouseBusiness;
import com.dgsoft.house.owner.model.MakeCard;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

/**
 * Created by wxy on 2015-08-28.
 * 将以前的他项权利证作废
 */
@Name("markMortgageCardState")
public class MarkMortgageCardState implements TaskCompleteSubscribeComponent {

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

        for(HouseBusiness houseBusiness:ownerBusinessHome.getInstance().getHouseBusinesses()){
            for (MakeCard makeCard:houseBusiness.getStartBusinessHouse().getOtherPowerCards()){
                if (makeCard.getType().equals(MakeCard.CardType.MORTGAGE_CARD)){
                    makeCard.setEnable(false);
                }
            }
        }

    }
}