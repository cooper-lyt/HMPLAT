package com.dgsoft.house.owner.business.subscribe.complete;

import com.dgsoft.common.system.NumberBuilder;
import com.dgsoft.common.system.business.TaskCompleteSubscribeComponent;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.MakeCard;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import com.dgsoft.common.system.RunParam;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 15-5-28.
 */
@Name("makeCardMortgage")
public class MakeCardMortgage implements TaskCompleteSubscribeComponent {


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
            if(m.getType().equals(MakeCard.CardType.MORTGAGE_CARD)){
                return;
            }
        }

        SimpleDateFormat numberDateformat = new SimpleDateFormat("yyyyMMdd");
        String datePart = numberDateformat.format(new Date());

        Integer typeCard = RunParam.instance().getIntParamValue("CreateCradNumberType");
        String no;
        if (typeCard==2){
            no= datePart + Long.toString(numberBuilder.getNumber(MakeCard.CardType.MORTGAGE_CARD.name()));
        }else {
            no= datePart+'-'+ Long.toString(numberBuilder.getNumber(MakeCard.CardType.MORTGAGE_CARD.name()));
        }





        MakeCard makeCard = new MakeCard(MakeCard.CardType.MORTGAGE_CARD,no);

        if(ownerBusinessHome.getInstance().getMortgaegeRegiste()!=null && ownerBusinessHome.getInstance().getMortgaegeRegiste().getFinancial()!=null){
            ownerBusinessHome.getInstance().getMortgaegeRegiste().getFinancial().setMakeCard(makeCard);
            makeCard.setFinancial(ownerBusinessHome.getInstance().getMortgaegeRegiste().getFinancial());
        }


        makeCard.setOwnerBusiness(ownerBusinessHome.getInstance());
        ownerBusinessHome.getInstance().getMakeCards().add(makeCard);







    }
}
