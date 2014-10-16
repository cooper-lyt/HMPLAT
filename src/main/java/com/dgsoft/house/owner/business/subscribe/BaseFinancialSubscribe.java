package com.dgsoft.house.owner.business.subscribe;

import com.dgsoft.house.owner.OwnerEntityHome;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.Financial;
import org.jboss.seam.annotations.In;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-10-14
 * Time: 下午4:55
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseFinancialSubscribe extends OwnerEntityHome<Financial> {

    @In
    private OwnerBusinessHome ownerBusinessHome;

    protected abstract Financial.FinancialType getType();

    @Override
    protected Financial createInstance() {
        return new Financial(getType());
    }

    @Override
    public Class<Financial> getEntityClass() {
        return Financial.class;
    }

    @Override
    public void create(){
        super.create();
        // ownerBusinessHome.getSingleHoues().getOwnerBusiness().getFinancials()
        for(Financial financial:ownerBusinessHome.getInstance().getFinancials()){
            if(financial.getType().equals(getType())){
                setId(financial.getId());
                return;
            }
        }
        getInstance().setOwnerBusiness(ownerBusinessHome.getInstance());
        ownerBusinessHome.getInstance().getFinancials().add(getInstance());
    }
}