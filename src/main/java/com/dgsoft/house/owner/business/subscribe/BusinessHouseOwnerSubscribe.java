package com.dgsoft.house.owner.business.subscribe;

import com.dgsoft.common.system.PersonHelper;
import com.dgsoft.house.owner.OwnerEntityHome;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.BusinessHouseOwner;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

/**
 * Created by cooper on 10/15/14.
 */
@Name("businessHouseOwnerSubscribe")
public class BusinessHouseOwnerSubscribe extends OwnerEntityHome<BusinessHouseOwner> {

    @In
    protected OwnerBusinessHome ownerBusinessHome;


    @Override
    public  BusinessHouseOwner createInstance(){
        BusinessHouseOwner result = new BusinessHouseOwner();
        result.setOwnerBusiness(ownerBusinessHome.getInstance());
        ownerBusinessHome.getSingleHoues().getAfterBusinessHouse().setBusinessHouseOwner(result);
        return result;
    }

    @Override
    public void create() {
        super.create();
        if (ownerBusinessHome.getSingleHoues().getAfterBusinessHouse().getBusinessHouseOwner() != null) {
            if (ownerBusinessHome.getSingleHoues().getAfterBusinessHouse().getBusinessHouseOwner().getId() == null) {
                setInstance(ownerBusinessHome.getSingleHoues().getAfterBusinessHouse().getBusinessHouseOwner());
            } else{
                setId(ownerBusinessHome.getSingleHoues().getAfterBusinessHouse().getBusinessHouseOwner().getId());
            }
        }else{
            clearInstance();
            ownerBusinessHome.getSingleHoues().getAfterBusinessHouse().setBusinessHouseOwner(getInstance());
        }
    }

    private PersonHelper<BusinessHouseOwner> personHelper;

    public PersonHelper<BusinessHouseOwner> getPersonInstance() {
        if ((personHelper == null) || (personHelper.getPersonEntity() != getInstance())) {
            personHelper = new PersonHelper(getInstance());
        }
        return personHelper;
    }


}
