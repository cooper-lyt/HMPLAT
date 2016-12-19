package com.dgsoft.house.owner.business.subscribe.complete;

import com.dgsoft.common.system.business.TaskCompleteSubscribeComponent;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.action.OwnerHouseHelper;
import com.dgsoft.house.owner.model.HouseBusiness;
import com.dgsoft.house.owner.model.HouseContract;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

/**
 * Created by wxy on 2016-12-19.
 */
@Name("projectBusinessOwnerKeyGen")
public class ProjectBusinessOwnerKeyGen implements TaskCompleteSubscribeComponent {

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
        for(HouseBusiness hb: ownerBusinessHome.getInstance().getHouseBusinesses()){
            KeyGeneratorHelper key = OwnerHouseHelper.genHouseSearchKey(hb.getAfterBusinessHouse());

            if (hb.getAfterBusinessHouse().getNewMainInitPerson() != null && hb.getAfterBusinessHouse().getNewMainInitPerson().getMakeCard()!=null) {
                key.addWord(hb.getAfterBusinessHouse().getNewMainInitPerson().getMakeCard().getNumber());

            }
            hb.setSearchKey(key.getKey());
        }

    }
}
