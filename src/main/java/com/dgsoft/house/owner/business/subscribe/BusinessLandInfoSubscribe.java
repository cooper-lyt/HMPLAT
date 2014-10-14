package com.dgsoft.house.owner.business.subscribe;

import com.dgsoft.house.owner.OwnerEntityHome;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.LandInfo;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-9-23
 * Time: 下午4:28
 * To change this template use File | Settings | File Templates.
 */
@Name("businessLandInfoSubscribe")
public class BusinessLandInfoSubscribe extends OwnerEntityHome<LandInfo>  {
    @In
    private OwnerBusinessHome ownerBusinessHome;

    private boolean have;

    public boolean isHave() {
        return have;
    }

    public void setHave(boolean have) {
        this.have = have;
    }








    @Override
    public void create(){
        super.create();

        if (ownerBusinessHome.getSingleHoues().getLandInfo()!=null) {
            have = true;
            setId(ownerBusinessHome.getSingleHoues().getLandInfo().getId());
        } else {
            have = false;
        }
    }

    public void checkHave(){
        clearInstance();
        if (have){
            ownerBusinessHome.getSingleHoues().setLandInfo(getInstance());
        } else {
            ownerBusinessHome.getSingleHoues().setLandInfo(null);
        }
    }
}
