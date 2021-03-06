package com.dgsoft.house.owner.action;

import com.dgsoft.house.HouseInfo;
import com.dgsoft.house.HouseStatus;
import com.dgsoft.house.SalePayType;
import com.dgsoft.house.owner.OwnerEntityLoader;
import com.dgsoft.house.owner.model.AddHouseStatus;
import com.dgsoft.house.owner.model.HouseBusiness;
import com.dgsoft.house.owner.model.MortgaegeRegiste;
import com.dgsoft.house.owner.model.OwnerBusiness;
import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Logging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cooper on 8/11/15.
 */

@Name("ownerHouseHelper")
@Scope(ScopeType.STATELESS)
public class OwnerHouseHelper {


    @In(create = true)
    private OwnerEntityLoader ownerEntityLoader;


    public List<HouseStatus> getHouseAllStatus(String houseCode) {
        List<HouseStatus> statuses = new ArrayList<HouseStatus>();

        //包含 COMPLETE_CANCEL 不再讨论

        List<AddHouseStatus> addHouseStatusList = ownerEntityLoader.getEntityManager().createQuery("select addHouseStatus from AddHouseStatus  addHouseStatus where addHouseStatus.houseBusiness.houseCode = :houseCode and (addHouseStatus.houseBusiness.ownerBusiness.status = 'COMPLETE' or addHouseStatus.houseBusiness.ownerBusiness.status = 'COMPLETE_CANCEL' or addHouseStatus.houseBusiness.ownerBusiness.status = 'MODIFYING' or ((addHouseStatus.houseBusiness.ownerBusiness.status = 'RUNNING' or addHouseStatus.houseBusiness.ownerBusiness.status = 'SUSPEND') and addHouseStatus.houseBusiness.ownerBusiness.recorded = true)) ", AddHouseStatus.class).setParameter("houseCode",houseCode).getResultList();

        Collections.sort(addHouseStatusList, new Comparator<AddHouseStatus>() {
            @Override
            public int compare(AddHouseStatus o1, AddHouseStatus o2) {
                return Boolean.valueOf(o1.isRemove()).compareTo(o2.isRemove());
            }
        });

         for(AddHouseStatus status: addHouseStatusList){
            if(status.isRemove()){

                if (!statuses.remove(status.getStatus())){
                    Logging.getLog(getClass()).warn("calc all house status remove fail.");
                }
            }else {
                statuses.add(status.getStatus());
            }
         }

        List<HouseStatus> result = new ArrayList<HouseStatus>();
        for(HouseStatus status: statuses){
            if (!result.contains(status) || status.isAllowRepeat()){
                result.add(status);
            }
        }

        Collections.sort(result, new HouseStatus.StatusComparator());
        return result;
    }

    public HouseStatus getMasterStatus(String houseCode){
        List<HouseStatus> statuses = getHouseAllStatus(houseCode);
        if (statuses.isEmpty()){
           return null;
        }else
            return statuses.get(0);
    }


    public List<MortgaegeRegiste> getMortgaeges(String houseCode){
       List<HouseBusiness> ownerBusinesses = ownerEntityLoader.getEntityManager().createQuery("select hb from HouseBusiness hb left join fetch hb.ownerBusiness ob  where hb.houseCode =:houseCode and hb.canceled = false and (ob.status = 'COMPLETE'  or ob.status = 'MODIFYING' or ((ob.status = 'RUNNING' or ob.status = 'SUSPEND') and ob.recorded = true))", HouseBusiness.class)
               .setParameter("houseCode",houseCode)
               .getResultList();

        List<MortgaegeRegiste> result = new ArrayList<MortgaegeRegiste>();
        for (HouseBusiness houseBusiness: ownerBusinesses){
            if (houseBusiness.getOwnerBusiness().getMortgaegeRegiste() != null){
                result.add(houseBusiness.getOwnerBusiness().getMortgaegeRegiste());
            }
        }
        return result;
    }


    public static OwnerHouseHelper instance() {
        return (OwnerHouseHelper) Component.getInstance(OwnerHouseHelper.class, true);
    }




    public SalePayType[] getSalePayType(){
        return SalePayType.values();
    }


}
