package com.dgsoft.house.owner.business;

import org.jboss.seam.annotations.Name;

/**
 * Created by cooper on 8/11/15.
 */
@Name("singleHouseBusinessCreate")
public class SingleOwnerBusinessCreate extends OwnerBusinessCreateComponent {


    private static final String NORMAL_BIZ_BEGIN_PAGE = "/business/houseOwner/SingleHouseStart.xhtml";
    private static final String PATCH_BIZ_BEGIN_PAGE = "/business/houseOwner/SingleHouseBusinessPatch.xhtml";



    @Override
    protected String getNormalBusinessPage() {
        return NORMAL_BIZ_BEGIN_PAGE;
    }

    @Override
    protected String getPatchBusinessPage() {
        return PATCH_BIZ_BEGIN_PAGE;
    }

}
