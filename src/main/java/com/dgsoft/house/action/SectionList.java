package com.dgsoft.house.action;


import com.dgsoft.house.HouseEntityQuery;
import com.dgsoft.house.model.Section;
import org.jboss.seam.annotations.Name;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cooperlee
 * Date: 14-6-6
 * Time: 下午4:24
 */
@Name("sectionList")
public class SectionList extends HouseEntityQuery<Section> {

    private static final String EJBQL = "select section from Section section " +
            "left join fetch section.district district";

    private static final String[] RESTRICTIONS = {
            "lower(district.name) like lower(concat('%',#{baseMapDataMgr.districtName},'%'))",
            "lower(district.id) like lower(concat('%',#{baseMapDataMgr.districtId},'%'))",
            "lower(district.shortName) like lower(concat('%',#{baseMapDataMgr.districtName},'%'))",

            "lower(section.id) like lower(concat('%',#{baseMapDataMgr.sectionId},'%'))",
            "lower(section.name) like lower(concat('%',#{baseMapDataMgr.sectionName},'%'))",
            "lower(section.address) like lower(concat('%',#{baseMapDataMgr.sectionAddress},'%'))",
            "lower(section.pyCode) like lower(concat('%',#{baseMapDataMgr.sectionName},'%'))",

            "lower(section.name) like lower(concat('%',#{sectionSearchCondition.sectionName},'%'))",
            "district.id = #{sectionSearchCondition.districtId}"};


    private static final String[] SORT_COLUMNS = {
            "section.createTime","section.name","section.district.id","section.id"
    };

    public List<String> getSortColumns(){
        return Arrays.asList(SORT_COLUMNS);
    }

    public SectionList() {
        setEjbql(EJBQL);
        setRestrictionLogicOperator("or");
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
        setMaxResults(25);
        setOrderColumn("section.createTime");
        setOrderDirection("desc");
    }




}
