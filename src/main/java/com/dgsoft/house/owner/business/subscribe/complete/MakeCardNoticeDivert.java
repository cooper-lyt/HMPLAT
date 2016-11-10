package com.dgsoft.house.owner.business.subscribe.complete;

import com.dgsoft.common.system.NumberBuilder;
import com.dgsoft.common.system.RunParam;
import com.dgsoft.common.system.business.TaskCompleteSubscribeComponent;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.MakeCard;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wxy on 2016-07-17.
 * 转移预告登记号生成
 */
@Name("makeCardNoticeDivert")
public class MakeCardNoticeDivert implements TaskCompleteSubscribeComponent {



    @In
    private OwnerBusinessHome ownerBusinessHome;


    @In(create = true)
    private NumberBuilder numberBuilder;



    @Override
    public void valid() {
    }

    @Override
    public boolean isPass() {
        return true;
    }

    @Override
    public void complete() {
        for (MakeCard m:ownerBusinessHome.getInstance().getMakeCards()){
            if(m.getType().equals(MakeCard.CardType.NOTICE_DIVERT)){
                return;
            }
        }
        SimpleDateFormat numberDateformat = new SimpleDateFormat("yyyyMMdd");
        String datePart = numberDateformat.format(new Date());
        Integer typeCard = RunParam.instance().getIntParamValue("CreateCradNumberType");
        String no;
        if (typeCard==2){
            no= datePart + Long.toString(numberBuilder.getNumber(MakeCard.CardType.NOTICE_DIVERT.name()));

        }else {
            no= datePart+'-'+ Long.toString(numberBuilder.getNumber(MakeCard.CardType.NOTICE_DIVERT.name()));
        }



        MakeCard makeCard = new MakeCard(MakeCard.CardType.NOTICE_DIVERT, no);

        if(ownerBusinessHome.getSingleHoues().getAfterBusinessHouse().getBusinessHouseOwner()!=null){
            ownerBusinessHome.getSingleHoues().getAfterBusinessHouse().getBusinessHouseOwner().setMakeCard(makeCard);

        }
        makeCard.setOwnerBusiness(ownerBusinessHome.getInstance());
        ownerBusinessHome.getInstance().getMakeCards().add(makeCard);



    }


}
