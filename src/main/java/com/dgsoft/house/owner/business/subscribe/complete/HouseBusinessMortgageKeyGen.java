package com.dgsoft.house.owner.business.subscribe.complete;

import com.dgsoft.common.system.business.TaskCompleteSubscribeComponent;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.action.OwnerHouseHelper;
import com.dgsoft.house.owner.model.HouseBusiness;
import com.dgsoft.house.owner.model.HouseContract;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

/**
 * Created by wxy on 2016-12-18.
 */
@Name("houseBusinessMortgageKeyGen")
public class HouseBusinessMortgageKeyGen implements TaskCompleteSubscribeComponent {

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

            if(hb.getAfterBusinessHouse().getHouseContracts()!=null) {
                for (HouseContract hc : hb.getAfterBusinessHouse().getHouseContracts()) {
                    key.addWord(hc.getContractNumber());
                }
            }
            if(hb.getStartBusinessHouse().getHouseContracts()!=null) {
                for (HouseContract hc : hb.getStartBusinessHouse().getHouseContracts()) {
                    key.addWord(hc.getContractNumber());
                }
            }
            if(ownerBusinessHome.getInstance().getMortgaegeRegiste()!=null &&
                    ownerBusinessHome.getInstance().getMortgaegeRegiste().getFinancial()!=null) {
                key.addWord(ownerBusinessHome.getInstance().getMortgaegeRegiste().getFinancial().getName());
            }

            hb.setSearchKey(key.getKey());
        }

    }
}
