package com.dgsoft.house.owner.business.subscribe;

import com.dgsoft.common.system.NumberBuilder;
import com.dgsoft.common.system.RunParam;
import com.dgsoft.house.owner.OwnerEntityHome;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.HouseBusiness;
import com.dgsoft.house.owner.model.HouseContract;
import com.dgsoft.house.owner.model.MakeCard;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wxy on 2018-03-20.
 * 交易，商品房 合同信息
 */
@Name("houseContractSubscribe")
public class HouseContractSubscribe extends OwnerEntityHome<HouseContract> {
    @In
    private OwnerBusinessHome ownerBusinessHome;




    @In(create = true)
    private NumberBuilder numberBuilder;

    @Override
    public void create(){
        super.create();
        for (HouseBusiness houseBusiness:ownerBusinessHome.getInstance().getHouseBusinesses()){
            if (houseBusiness.getHouseContract()!=null){
                if (houseBusiness.getHouseContract().getId()!=null){
                   setId(houseBusiness.getHouseContract().getId());
                }else{
                   setInstance(houseBusiness.getHouseContract());
                }
            }else{
                SimpleDateFormat numberDateformat = new SimpleDateFormat("yyyyMMdd");
                String datePart = numberDateformat.format(new Date());
                String site = RunParam.instance().getStringParamValue("SiteShort");
                String no=site+datePart + Long.toString(numberBuilder.getNumber("HTBH"));
                getInstance().setContractNumber(no);
                getInstance().setHouseBusiness(houseBusiness);

                houseBusiness.setHouseContract(getInstance());
            }
        }
    }
}
