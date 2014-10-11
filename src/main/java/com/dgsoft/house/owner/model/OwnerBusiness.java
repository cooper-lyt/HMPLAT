package com.dgsoft.house.owner.model;
// Generated Aug 19, 2014 4:32:06 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * OwnerBusiness generated by hbm2java
 */
@Entity
@Table(name = "OWNER_BUSINESS", catalog = "HOUSE_OWNER_RECORD")
@Inheritance(strategy = InheritanceType.JOINED)
public class OwnerBusiness implements java.io.Serializable {

    public enum BusinessSource {
        BIZ_CAREATE, BIZ_AFTER_SAVE, BIZ_IMPORT
    }

    public enum BusinessStatus {
        RUNNING, COMPLETE, ABORT, SUSPEND, CANCEL, MODIFY, MODIFYING;
    }


    private String id;
    private Integer version;
    private BusinessSource source;
    private Date recordTime;
    private String processMessage;
    private String memo;
    private BusinessStatus status;
    private Date applyTime;
    private Date createTime;
    private String defineName;
    private String defineId;
    private Set<UploadFiles> uploadFileses = new HashSet<UploadFiles>(0);
    private Set<Reason> reasons = new HashSet<Reason>(0);
    private Set<BusinessMoney> businessMoneys = new HashSet<BusinessMoney>(0);
    private Set<OtherRegiste> otherRegistes = new HashSet<OtherRegiste>(0);
    private Set<MappingCorp> mappingCorps = new HashSet<MappingCorp>(0);
    private Set<BusinessEmp> businessEmps = new HashSet<BusinessEmp>(0);
    private Set<Card> cards = new HashSet<Card>(0);
    private Set<BusinessPersion> businessPersions = new HashSet<BusinessPersion>(0);

    private Set<Evaluate> evaluates = new HashSet<Evaluate>(0);
    private Set<MortgaegeRegiste> mortgaegeRegistes = new HashSet<MortgaegeRegiste>(
            0);
    private Set<SaleInfo> saleInfos = new HashSet<SaleInfo>(0);
    private Set<HouseCloseCancel> houseCloseCancels = new HashSet<HouseCloseCancel>(
            0);
    private Set<Financial> financials = new HashSet<Financial>(0);
    private Set<BusinessHouse> businessHouses = new HashSet<BusinessHouse>(0);
    private Set<CloseHouse> closeHouses = new HashSet<CloseHouse>(0);
    private Set<TaskOper> taskOpers = new HashSet<TaskOper>(0);
    private Set<RegisterProperty>registerPropertys = new HashSet<RegisterProperty>(0);
    private OwnerBusiness selectBusiness;
    private Set<BusinessProject> businessProjects = new HashSet<BusinessProject>(0);

    public OwnerBusiness() {
    }

    public OwnerBusiness(BusinessSource source, Date recordTime, BusinessStatus status, Date applyTime, Date createTime) {
        this.source = source;
        this.recordTime = recordTime;
        this.status = status;
        this.applyTime = applyTime;
        this.createTime = createTime;
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

    @Version
    @Column(name = "VERSION")
    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "SOURCE", nullable = false, length = 20)
    @NotNull
    public BusinessSource getSource() {
        return this.source;
    }

    public void setSource(BusinessSource source) {
        this.source = source;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RECORD_TIME", nullable = false, length = 19)
    @NotNull
    public Date getRecordTime() {
        return this.recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    @Column(name = "PROCESS_MESSAGE", length = 400)
    @Size(max = 400)
    public String getProcessMessage() {
        return this.processMessage;
    }

    public void setProcessMessage(String processMessage) {
        this.processMessage = processMessage;
    }

    @Column(name = "DEFINE_NAME", nullable = true, length = 50)
    @Size(max = 50)
    public String getDefineName() {
        return defineName;
    }

    public void setDefineName(String defineName) {
        this.defineName = defineName;
    }

    @Column(name = "DEFINE_ID", nullable = true, length = 32)
    @Size(max = 32)
    public String getDefineId() {
        return defineId;
    }

    public void setDefineId(String defineId) {
        this.defineId = defineId;
    }

    @Column(name = "MEMO", length = 200)
    @Size(max = 200)
    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 20)
    @NotNull
    public BusinessStatus getStatus() {
        return this.status;
    }

    public void setStatus(BusinessStatus status) {
        this.status = status;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APPLY_TIME", nullable = false, length = 19)
    @NotNull
    public Date getApplyTime() {
        return this.applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", nullable = false, length = 19)
    @NotNull
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<UploadFiles> getUploadFileses() {
        return this.uploadFileses;
    }

    public void setUploadFileses(Set<UploadFiles> uploadFileses) {
        this.uploadFileses = uploadFileses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<Reason> getReasons() {
        return this.reasons;
    }

    public void setReasons(Set<Reason> reasons) {
        this.reasons = reasons;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<BusinessMoney> getBusinessMoneys() {
        return this.businessMoneys;
    }

    public void setBusinessMoneys(Set<BusinessMoney> businessMoneys) {
        this.businessMoneys = businessMoneys;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<OtherRegiste> getOtherRegistes() {
        return this.otherRegistes;
    }

    public void setOtherRegistes(Set<OtherRegiste> otherRegistes) {
        this.otherRegistes = otherRegistes;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<MappingCorp> getMappingCorps() {
        return this.mappingCorps;
    }

    public void setMappingCorps(Set<MappingCorp> mappingCorps) {
        this.mappingCorps = mappingCorps;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<BusinessEmp> getBusinessEmps() {
        return this.businessEmps;
    }

    public void setBusinessEmps(Set<BusinessEmp> businessEmps) {
        this.businessEmps = businessEmps;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<Card> getCards() {
        return this.cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<BusinessPersion> getBusinessPersions() {
        return this.businessPersions;
    }

    public void setBusinessPersions(Set<BusinessPersion> businessPersions) {
        this.businessPersions = businessPersions;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<Evaluate> getEvaluates() {
        return this.evaluates;
    }

    public void setEvaluates(Set<Evaluate> evaluates) {
        this.evaluates = evaluates;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<MortgaegeRegiste> getMortgaegeRegistes() {
        return this.mortgaegeRegistes;
    }

    public void setMortgaegeRegistes(Set<MortgaegeRegiste> mortgaegeRegistes) {
        this.mortgaegeRegistes = mortgaegeRegistes;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<SaleInfo> getSaleInfos() {
        return this.saleInfos;
    }


    public void setSaleInfos(Set<SaleInfo> saleInfos) {
        this.saleInfos = saleInfos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<HouseCloseCancel> getHouseCloseCancels() {
        return this.houseCloseCancels;
    }

    public void setHouseCloseCancels(Set<HouseCloseCancel> houseCloseCancels) {
        this.houseCloseCancels = houseCloseCancels;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<Financial> getFinancials() {
        return this.financials;
    }

    public void setFinancials(Set<Financial> financials) {
        this.financials = financials;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<BusinessHouse> getBusinessHouses() {
        return this.businessHouses;
    }

    public void setBusinessHouses(Set<BusinessHouse> businessHouses) {
        this.businessHouses = businessHouses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<CloseHouse> getCloseHouses() {
        return this.closeHouses;
    }

    public void setCloseHouses(Set<CloseHouse> closeHouses) {
        this.closeHouses = closeHouses;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", orphanRemoval = true, cascade = {CascadeType.ALL})
    public Set<TaskOper> getTaskOpers() {
        return taskOpers;
    }

    public void setTaskOpers(Set<TaskOper> taskOpers) {
        this.taskOpers = taskOpers;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "SELECT_BUSINESS", nullable = true)
    public OwnerBusiness getSelectBusiness() {
        return selectBusiness;
    }

    public void setSelectBusiness(OwnerBusiness selectBusiness) {
        this.selectBusiness = selectBusiness;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness",orphanRemoval = true, cascade = CascadeType.ALL)
    public Set<BusinessProject> getBusinessProjects() {
        return businessProjects;
    }

    public void setBusinessProjects(Set<BusinessProject> businessProjects) {
        this.businessProjects = businessProjects;
    }


    @Transient
    public BusinessProject getBusinessProject(){
        if (getBusinessProjects().isEmpty()){
            return null;
        }else{
            return getBusinessProjects().iterator().next();
        }
    }

    @Transient
    public void setBusinessProject(BusinessProject businessProject){
        getBusinessProjects().clear();
        if (businessProject != null){
            getBusinessProjects().add(businessProject);
        }
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerBusiness", cascade = {CascadeType.ALL}, orphanRemoval = true)
    public Set<RegisterProperty> getRegisterPropertys() {
        return registerPropertys;
    }

    public void setRegisterPropertys(Set<RegisterProperty> registerPropertys) {
        this.registerPropertys = registerPropertys;
    }
}
