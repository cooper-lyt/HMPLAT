package com.dgsoft.common.system.model;
// Generated Apr 28, 2013 11:02:59 AM by Hibernate Tools 4.0.0

import com.dgsoft.common.system.PersonEntity;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "EMPLOYEE",catalog = "DB_PLAT_SYSTEM")
public class Employee implements java.io.Serializable {

    private String id;
    private Date joinDate;
    private String EMail;
    private String password;
    private boolean enable;
    private Set<Role> roles = new HashSet<Role>(0);
    private String phone;
    private String name;
    private String pyCode;
    private String windowsNo;


    public Employee() {

    }

    public Employee(String id) {
        enable = true;
        this.id = id;
    }

    public Employee(Date joinDate, String password){
        this.joinDate = joinDate;
        enable = true;
        this.password = password;
    }

    public Employee(String name, String id) {
        enable = true;
        this.name = name;
        this.id = id;
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



    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "JOIN_DATE", nullable = false, length = 19, columnDefinition = "DATETIME")
    @NotNull
    public Date getJoinDate() {
        return this.joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @Column(name = "E_MAIL", length = 20)
    @Size(max = 20)
    @Email
    public String getEMail() {
        return this.EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    @Column(name = "PASSWORD", length = 32,nullable = false)
    @Size(max = 100)
    @NotNull
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "ENABLE", nullable = false)
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinTable(name = "ROLE_EMP", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "ROL_ID"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Column(name = "PHONE", length = 20)
    @Size(max = 20)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "NAME", nullable = false, length = 100)
    @NotNull
    @Size(max = 50)
    public String getPersonName() {
        return this.name;
    }

    public void setPersonName(String name) {
        this.name = name;
    }

    @Column(name = "PY_CODE",nullable = true, length = 100)
    @Size(max = 50)
    public String getPyCode() {
        return pyCode;
    }

    public void setPyCode(String pyCode) {
        this.pyCode = pyCode;
    }

    @Column(name = "WINDOW_NO",nullable = true, length = 10)
    @Size(max = 10)
    public String getWindowsNo() {
        return windowsNo;
    }

    public void setWindowsNo(String windowsNo) {
        this.windowsNo = windowsNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }


        if (((Employee)obj).getId().equals(getId())){
            return true;
        }else
            return false;
    }

    @Override
    public int hashCode(){
        return getId().hashCode();
    }

}
