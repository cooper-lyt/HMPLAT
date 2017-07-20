package com.dgsoft.house.owner.action;

import com.dgsoft.house.owner.OwnerEntityQuery;
import com.dgsoft.house.owner.model.HouseRecord;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import java.util.Arrays;

/**
 * Created by cooper on 7/16/15.
 */
@Name("houseRecordList")
@Scope(ScopeType.CONVERSATION)
public class HouseRecordList extends OwnerEntityQuery<HouseRecord> {


    private static final String EJBQL = "select distinct houseRecord from HouseRecord houseRecord " +
            "left join fetch houseRecord.businessHouse businessHouse " +
            "left join businessHouse.powerPersons pool " +
            "left join pool.makeCard poolCard " +
            "left join fetch businessHouse.houseBusinessForAfter houseBusiness " +
            "left join fetch houseBusiness.ownerBusiness ownerBusiness " +
            "left join ownerBusiness.recordStores store " ;

    private static final String[] RESTRICTIONS = {
        "lower(houseRecord.houseCode) = lower(#{houseRecordList.searchKey})",
            "lower(businessHouse.buildName) like lower(concat('%',concat(#{houseRecordList.searchKey},'%')))",
            "lower(houseRecord.searchKey) like lower(concat('%',concat(#{houseRecordList.searchKey},'%')))",
            "lower(poolCard.number) = lower(#{houseRecordList.searchKey})",
            "lower(pool.personName) = lower(#{houseRecordList.searchKey})",
            "lower(pool.credentialsNumber) = lower(#{houseRecordList.searchKey})",
            "lower(store.recordCode) = lower(#{houseRecordList.searchKey})"
    };

    public HouseRecordList() {
        setEjbql(EJBQL);
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setRestrictionLogicOperator("or");
        setMaxResults(100);
    }

    private String searchKey;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
