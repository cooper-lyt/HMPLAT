package com.dgsoft.house.model;
// Generated Jul 12, 2013 11:32:23 AM by Hibernate Tools 4.0.0

import com.dgsoft.common.system.PersonEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * AttachEmployee generated by hbm2java
 */
@Entity
@Table(name = "ATTACH_EMPLOYEE", catalog = "HOUSE_INFO")
public class AttachEmployee implements java.io.Serializable,PersonEntity {

    private String id;
    private String licenseLeve;
    private String licenseNumber;
    private Date licenseTimeTo;
    private String phone;
    private String deucation;
    private String name;
    private PersonEntity.CredentialsType credentialsType;
    private String credentialsNumber;
    private Boolean enable;
    private Date createTime;
    private Set<EmployeeAttachAction> employeeAttachActions = new HashSet<EmployeeAttachAction>(0);
    private AttachCorporation attachCorporation;

    public AttachEmployee() {
    }

    public AttachEmployee(AttachCorporation attachCorporation) {
        this.attachCorporation = attachCorporation;
    }

    public AttachEmployee(String id, Boolean enable, Date createTime) {
        this.id = id;
        this.enable = enable;
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

    @Column(name = "LICENSE_LEVE", length = 32)
    @Size(max = 32)
    public String getLicenseLeve() {
        return this.licenseLeve;
    }

    public void setLicenseLeve(String licenseLeve) {
        this.licenseLeve = licenseLeve;
    }

    @Column(name = "LICENSE_NUMBER", length = 50)
    @Size(max = 50)
    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LICENSE_TIME_TO", nullable = false, length = 19)
    @NotNull
    public Date getLicenseTimeTo() {
        return this.licenseTimeTo;
    }

    public void setLicenseTimeTo(Date licenseTimeTo) {
        this.licenseTimeTo = licenseTimeTo;
    }

    @Column(name = "PHONE", length = 20)
    @Size(max = 20)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "DEUCATION", length = 32)
    @Size(max = 32)
    public String getDeucation() {
        return this.deucation;
    }

    public void setDeucation(String deucation) {
        this.deucation = deucation;
    }

    @Override
    @Column(name = "NAME", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    public String getPersonName() {
        return this.name;
    }

    public void setPersonName(String name) {
        this.name = name;
    }

    @Override
    @Enumerated(EnumType.STRING)
    @Column(name = "CREDENTIALS_TYPE", length = 32)
    public PersonEntity.CredentialsType getCredentialsType() {
        return this.credentialsType;
    }

    public void setCredentialsType(PersonEntity.CredentialsType credentialsType) {
        this.credentialsType = credentialsType;
    }

    @Override
    @Column(name = "CREDENTIALS_NUMBER", length = 100)
    @Size(max = 100)
    public String getCredentialsNumber() {
        return this.credentialsNumber;
    }

    public void setCredentialsNumber(String credentialsNumber) {
        this.credentialsNumber = credentialsNumber;
    }


    @Column(name = "ENABLE")
    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CORP", nullable = false)
    @NotNull
    public AttachCorporation getAttachCorporation() {
        return attachCorporation;
    }

    public void setAttachCorporation(AttachCorporation attachCorporation) {
        this.attachCorporation = attachCorporation;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "attachEmployee")
    public Set<EmployeeAttachAction> getEmployeeAttachActions() {
        return this.employeeAttachActions;
    }

    public void setEmployeeAttachActions(
            Set<EmployeeAttachAction> employeeAttachActions) {
        this.employeeAttachActions = employeeAttachActions;
    }

}
