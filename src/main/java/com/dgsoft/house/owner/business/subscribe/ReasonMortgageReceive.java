package com.dgsoft.house.owner.business.subscribe;

import com.dgsoft.house.owner.OwnerEntityHome;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.Reason;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

/**
 * Created by wxy on 2016-08-08.
 * 抵押受理备注
 */
@Name("reasonMortgageReceive")
public class ReasonMortgageReceive extends OwnerEntityHome<Reason> {
    @In
    private OwnerBusinessHome ownerBusinessHome;

    @Override
    public Reason createInstance(){
        return new Reason(Reason.ReasonType.MORTGAGE_RECEIVE);
    }

    @Override
    public void create()
    {
        super.create();
        for(Reason reason: ownerBusinessHome.getInstance().getReasons()){
            if (reason.getType().equals(Reason.ReasonType.MORTGAGE_RECEIVE)){
                setId(reason.getId());
                return;
            }

        }
        getInstance().setOwnerBusiness(ownerBusinessHome.getInstance());
        ownerBusinessHome.getInstance().getReasons().add(getInstance());

    }

}
