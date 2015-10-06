package com.dgsoft.common.system.model;
// Generated Apr 28, 2013 11:02:59 AM by Hibernate Tools 4.0.0

import com.dgsoft.common.OrderModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * BusinessDefine generated by hbm2java
 */
@Entity
@Table(name = "BUSINESS_DEFINE",catalog = "DB_PLAT_SYSTEM")
public class BusinessDefine implements java.io.Serializable,OrderModel {

    public enum RegBookIndexPart{

        BASIC_INFO(1), //基本状况登记
        HOUSE_OWNER(2), //房屋所有权登记
        HOUSE_MORTGAGE(3), //房屋它项权利登记
        OTHER_REG(4);//其它状况部分登记

        private int pri;

        public int getPri() {
            return pri;
        }

        RegBookIndexPart(int pri) {
            this.pri = pri;
        }
    }

    public enum RegBookPage {

        OWNER_CHANGE_PAGE(RegBookIndexPart.HOUSE_OWNER,"/report/register-book/OwnerChange.xhtml"), //所有权部分 (改变基本状况页,不改变基本状况)

        PROJECT_MORTGAGE_PAGE(RegBookIndexPart.HOUSE_MORTGAGE, "/report/register-book/ProjectMortgage.xhtml"),//在建工程抵押部分

        OWNER_HOUSE_MORTGAGE_PAGE(RegBookIndexPart.HOUSE_MORTGAGE,"/report/register-book/HouseMortgage.xhtml"), //现房抵押部分

        COURT_CLOSE_PAGE(RegBookIndexPart.OTHER_REG,"/report/register-book/CourtClose.xhtml"),//查封部分

        DISSIDENCE_PAGE(RegBookIndexPart.OTHER_REG,"/report/register-book/Dissidence.xhtml"),//异议部分（异议）

        PREPARE_OWNER_PAGE(RegBookIndexPart.OTHER_REG,"/report/register-book/PrepareOwner.xhtml");//预告登记部分

        private String location;

        private RegBookIndexPart part;

        public RegBookIndexPart getPart() {
            return part;
        }

        public String getLocation() {
            return location;
        }

        RegBookPage(RegBookIndexPart part, String location){
            this.part = part;
            this.location = location;
        }
    }

    public enum RegBookBizType{


        OWNER_HOUSE_CHANGE(true, RegBookPage.OWNER_CHANGE_PAGE), OWNER_CHANGE(true, RegBookPage.OWNER_CHANGE_PAGE), //所有权部分 (改变基本状况页,不改变基本状况)

        PROJECT_MORTGAGE_PART(true, RegBookPage.PROJECT_MORTGAGE_PAGE),//在建工程抵押部分

        OWNER_HOUSE_MORTGAGE(true, RegBookPage.OWNER_HOUSE_MORTGAGE_PAGE), //现房抵押部分

        COURT_CLOSE_PART(true, RegBookPage.COURT_CLOSE_PAGE), COURT_CLOSE_CANCEL_PART(false, RegBookPage.COURT_CLOSE_PAGE), //查封部分(查封,查封解除)

        DISSIDENCE(true, RegBookPage.DISSIDENCE_PAGE),//异议部分（异议）

        PREPARE_OWNER(true, RegBookPage.PREPARE_OWNER_PAGE),//预告登记部分

        HIGHEST_MORTGAGE_CONFIRM(false, RegBookPage.OWNER_HOUSE_MORTGAGE_PAGE), //现房抵押最高额确定登记

        PROJECT_HIGHEST_MORTGAGE_CONFIRM(false, RegBookPage.PROJECT_MORTGAGE_PAGE),//在建工程抵押最高额确定登记

        PROJECT_MORTGAGE_CANCEL(false,null),//在建工程抵押注销（包括各种抵押类型的注销）

        DISSIDENCE_CANCEL(false, RegBookPage.DISSIDENCE_PAGE), //异议解除

        MORTGAGE_CANCEL(false, RegBookPage.OWNER_HOUSE_MORTGAGE_PAGE), //现房抵押注销

        PREPARE_CANCEL(false, RegBookPage.PREPARE_OWNER_PAGE); //预告登记解除

        private boolean master;

        private RegBookPage page;

        public boolean isMaster() {
            return master;
        }

        public RegBookPage getPage() {
            return page;
        }

        RegBookBizType(boolean master, RegBookPage page) {
            this.master = master;
            this.page = page;
        }
    }

    private String id;
    private BusinessCategory businessCategory;
    private String name;
    private String wfName;
    private String startPage;
    private String memo;
    private Integer version;

    private String rolePrefix;
    private String description;
    private int priority;
    private Set<TaskSubscribe> taskSubscribes = new HashSet<TaskSubscribe>(0);
    private Set<BusinessNeedFile> businessNeedFiles = new HashSet<BusinessNeedFile>(0);
    private Set<SubscribeGroup> subscribeGroups = new HashSet<SubscribeGroup>(0);
    private Set<CreateComponent> businessCreateDataValids = new HashSet<CreateComponent>(0);
    private boolean enable;
    private String pickBusinessDefineId;
    private String pickBusinessViewPage;
    private boolean requiredBiz;


    private Set<Fee> fees = new HashSet<Fee>(0);
    private Set<BusinessReport> businessReports = new HashSet<BusinessReport>(0);
    private String modifyPage;
    private String registerBookPart;



    public BusinessDefine() {
    }

    public BusinessDefine(String id, BusinessCategory businessCategory,
                          String name, String wfName) {
        this.id = id;
        this.businessCategory = businessCategory;
        this.name = name;
        this.wfName = wfName;
    }

    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY", nullable = false)
    @NotNull
    public BusinessCategory getBusinessCategory() {
        return this.businessCategory;
    }

    public void setBusinessCategory(BusinessCategory businessCategory) {
        this.businessCategory = businessCategory;
    }

    @Column(name = "NAME", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "WF_NAME", nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    public String getWfName() {
        return this.wfName;
    }

    public void setWfName(String wfName) {
        this.wfName = wfName;
    }

    @Column(name = "START_PAGE", length = 200)
    @Size(max = 200)
    public String getStartPage() {
        return this.startPage;
    }

    public void setStartPage(String operPage) {
        this.startPage = operPage;
    }

    @Column(name = "MEMO", length = 200)
    @Size(max = 200)
    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "businessDefine")
    public Set<BusinessNeedFile> getBusinessNeedFiles() {
        return businessNeedFiles;
    }

    public void setBusinessNeedFiles(Set<BusinessNeedFile> businessNeedFiles) {
        this.businessNeedFiles = businessNeedFiles;
    }


    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true,cascade = {CascadeType.ALL},mappedBy = "businessDefine")
    public Set<TaskSubscribe> getTaskSubscribes() {
        return taskSubscribes;
    }

    public void setTaskSubscribes(Set<TaskSubscribe> editSubscribes) {
        this.taskSubscribes = editSubscribes;
    }

    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true,cascade = {CascadeType.ALL},mappedBy = "businessDefine")
    public Set<SubscribeGroup> getSubscribeGroups() {
        return subscribeGroups;
    }

    public void setSubscribeGroups(Set<SubscribeGroup> subscribeGroups) {
        this.subscribeGroups = subscribeGroups;
    }

    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Column(name="DESCRIPTION",nullable = true,length = 500)
    @Size(max = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="ROLE_PREFIX",nullable = true,length = 20)
    @Size(max = 20)
    public String getRolePrefix() {
        return rolePrefix;
    }

    public void setRolePrefix(String rolePrefix) {
        this.rolePrefix = rolePrefix;
    }

    @Column(name="ENABLE",nullable = false)
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    @Column(name = "PRIORITY",nullable = false)
    public int getPriority() {
        return this.priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }


    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true,cascade = {CascadeType.ALL},mappedBy = "businessDefine")
    public Set<CreateComponent> getBusinessCreateDataValids() {
        return businessCreateDataValids;
    }

    public void setBusinessCreateDataValids(Set<CreateComponent> businessCreateDataValids) {
        this.businessCreateDataValids = businessCreateDataValids;
    }

    @Column(name = "PICK_BUSINESS_DEFINE_ID", nullable = true, length = 32)
    @Size(max = 32)
    public String getPickBusinessDefineId() {
        return pickBusinessDefineId;
    }

    public void setPickBusinessDefineId(String pickBusinessDefineId) {
        this.pickBusinessDefineId = pickBusinessDefineId;
    }

    @Column(name="PICK_BUSINESS_VIEW_PAGE", nullable = true, length = 255)
    @Size(max = 255)
    public String getPickBusinessViewPage() {
        return pickBusinessViewPage;
    }

    public void setPickBusinessViewPage(String pickBusinessViewPage) {
        this.pickBusinessViewPage = pickBusinessViewPage;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BusinessDefine)) {
            return false;
        }
        return id.equals(((BusinessDefine) obj).getId());
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BUSINESS_AND_FEE",joinColumns=@JoinColumn(name="BUSINESS"),inverseJoinColumns = @JoinColumn(name = "FEE"))
    public Set<Fee> getFees() {
        return fees;
    }

    public void setFees(Set<Fee> fees) {
        this.fees = fees;
    }

    @Column(name = "MODIFY_PAGE",nullable = true, length = 200)
    @Size(max = 200)
    public String getModifyPage() {
        return modifyPage;
    }

    public void setModifyPage(String modifyPage) {
        this.modifyPage = modifyPage;
    }


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "businessDefine")
    public Set<BusinessReport> getBusinessReports() {
        return businessReports;
    }

    public void setBusinessReports(Set<BusinessReport> businessReports) {
        this.businessReports = businessReports;
    }

    @Column(name = "REQUIRED_BIZ", nullable = false)
    public boolean isRequiredBiz() {
        return requiredBiz;
    }

    public void setRequiredBiz(boolean requiredBiz) {
        this.requiredBiz = requiredBiz;
    }


    @Column(name = "REGISTER_BOOK_PART",nullable = true,length = 256)
    public String getRegisterBookPart() {
        return registerBookPart;
    }

    public void setRegisterBookPart(String registerBookPage) {
        this.registerBookPart = registerBookPage;
    }

    @Transient
    public Set<RegBookBizType> getRegisterBookParts(){
        if (getRegisterBookPart() == null || getRegisterBookPart().trim().equals("")){
            return new HashSet<RegBookBizType>(0);
        }
        Set<RegBookBizType> result = new HashSet<RegBookBizType>();
        for(String type: getRegisterBookPart().split(",")){
            if (!type.trim().equals("")){
                result.add(RegBookBizType.valueOf(type));
            }
        }
        return result;
    }
}
