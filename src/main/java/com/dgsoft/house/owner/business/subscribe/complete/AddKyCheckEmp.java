package com.dgsoft.house.owner.business.subscribe.complete;

import com.dgsoft.common.system.AuthenticationInfo;
import com.dgsoft.common.system.business.TaskCompleteSubscribeComponent;
import com.dgsoft.house.owner.action.OwnerBusinessHome;
import com.dgsoft.house.owner.model.BusinessEmp;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import java.util.Date;

/**
 * Created by wxy on 2015-08-17.
 * 添加审核人,开原审核人是登薄人
 */
@Name("addKyCheckEmp")
public class AddKyCheckEmp implements TaskCompleteSubscribeComponent {

    @In
    private OwnerBusinessHome ownerBusinessHome;

    @In
    private AuthenticationInfo authInfo;

    @In(required = false,scope = ScopeType.BUSINESS_PROCESS)
    private String transitionComments;

    @Override
    public void valid() {

    }

    @Override
    public boolean isPass() {
        return true;
    }

    @Override
    public void complete() {
        for (BusinessEmp businessEmp:ownerBusinessHome.getInstance().getBusinessEmps()){
            if (businessEmp.getType().equals(BusinessEmp.EmpType.REG_EMP)){
                ownerBusinessHome.getInstance().getBusinessEmps().remove(businessEmp);
                break;
            }


        }
        BusinessEmp businessEmp = new BusinessEmp(BusinessEmp.EmpType.REG_EMP);
        businessEmp.setEmpName(authInfo.getLoginEmployee().getPersonName());
        businessEmp.setEmpCode(authInfo.getLoginEmployee().getId());
        businessEmp.setOperDate(new Date());
        businessEmp.setComments(transitionComments);
        businessEmp.setOwnerBusiness(ownerBusinessHome.getInstance());
        ownerBusinessHome.getInstance().setRegTime(businessEmp.getOperDate());
        ownerBusinessHome.getInstance().getBusinessEmps().add(businessEmp);





    }




}
