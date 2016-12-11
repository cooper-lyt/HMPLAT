package com.dgsoft.house.owner.model;
// Generated Aug 19, 2014 4:32:06 PM by Hibernate Tools 4.0.0


import com.dgsoft.common.system.PersonEntity;
import com.dgsoft.common.system.PowerPersonEntity;
import com.dgsoft.common.system.ProxyPersonEntity;
import com.dgsoft.common.system.Sex;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * BusinessPool generated by hbm2java
 */
@Entity
@Table(name = "POWER_OWNER", catalog = "HOUSE_OWNER_RECORD")
public class PowerPerson implements PowerPersonEntity, Comparable<PowerPerson>, java.io.Serializable {

    @Override
    @Transient
    public int compareTo(PowerPerson o) {
        Integer typePri = getType().getPri();
        int result = typePri.compareTo(o.getType().getPri());
        if(result == 0){
            return Integer.valueOf(getPriority()).compareTo(o.getPriority());
        }else{
            return result;
        }
    }

    public enum PowerPersonType {
        OWNER(0),CONTRACT(6),PREPARE(4),INIT(11);

        private int pri;

        public int getPri() {
            return pri;
        }

        PowerPersonType(int pri) {
            this.pri = pri;
        }
    }

    private String id;
    private String personName;
    private PersonEntity.CredentialsType credentialsType;
    private String credentialsNumber;
    private String relation;
    private BigDecimal poolArea;
    private BigDecimal poolPerc;

    private String legalPerson;
    private LegalType legalType;

    private String phone;
    private String rootAddress;
    private String address;

    private Date birthday;
    private Sex sex;

    private int pri;

    private MakeCard makeCard;

    private PowerPersonType type;
    private boolean old;

    private ProxyPersonEntity proxyPerson;
    private Set<BusinessHouse> businessHouses = new HashSet<BusinessHouse>(0);


    public PowerPerson() {
    }

    public PowerPerson(PowerPersonType type, boolean old) {
        this.type = type;
        this.old = old;
    }

    public PowerPerson(PowerPersonType type, boolean old ,PowerPerson pool){
        this.type = type;
        this.old = old;
        this.personName = pool.getPersonName();
        this.credentialsNumber = pool.getCredentialsNumber();
        this.credentialsType = pool.getCredentialsType();
        this.relation = pool.getRelation();
        this.poolArea = pool.getPoolArea();
        this.poolPerc = pool.getPoolPerc();
        this.phone = pool.getPhone();
        this.makeCard = pool.getMakeCard();
        this.legalPerson = pool.getLegalPerson();
        this.legalType = pool.getLegalType();
        this.rootAddress = pool.getRootAddress();
        this.address = pool.getAddress();
        this.birthday = pool.getBirthday();
        this.sex = pool.getSex();
    }

    public PowerPerson(PowerPersonType type, boolean old ,PowerPerson pool, int pri){
        this(type, old , pool);
        this.pri = pri;
    }

    public PowerPerson(String personName, CredentialsType credentialsType,
                       String credentialsNumber, String relation, BigDecimal poolArea,
                       BigDecimal perc, String phone, String legalPerson) {
        this.personName = personName;
        this.credentialsType = credentialsType;
        this.credentialsNumber = credentialsNumber;
        this.relation = relation;
        this.poolArea = poolArea;
        this.poolPerc = perc;
        this.phone = phone;
        this.legalPerson = legalPerson;
    }

    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    @Override
    public String getPersonName() {
        return this.personName;
    }

    @Override
    public void setPersonName(String name) {
        this.personName = name;
    }


    @Override
    @Enumerated(EnumType.STRING)
    @Column(name = "ID_TYPE", nullable = false, length = 32)
    @NotNull
    public PersonEntity.CredentialsType getCredentialsType() {
        return credentialsType;
    }

    @Override
    public void setCredentialsType(PersonEntity.CredentialsType credentialsType) {
        this.credentialsType = credentialsType;
    }

    @Override
    @Column(name = "ID_NO", nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    public String getCredentialsNumber() {
        return credentialsNumber;
    }

    @Override
    public void setCredentialsNumber(String cerdentialsNumber) {
        this.credentialsNumber = cerdentialsNumber;
    }

    @Column(name = "RELATION", length = 32)
    @Size(max = 32)
    public String getRelation() {
        return this.relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Column(name = "POOL_AREA", scale = 4)
    public BigDecimal getPoolArea() {
        return this.poolArea;
    }

    public void setPoolArea(BigDecimal poolArea) {
        this.poolArea = poolArea;
    }

    @Column(name = "PERC", scale = 4)
    public BigDecimal getPoolPerc() {
        return this.poolPerc;
    }

    public void setPoolPerc(BigDecimal perc) {
        this.poolPerc = perc;
    }

    @Column(name = "PHONE", nullable = true, length = 15)
    @Size(max = 15)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    @Column(name = "LEGAL_PERSON", nullable = true, length = 50)
    @Size(max = 50)
    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }


    @Enumerated(EnumType.STRING)
    @Column(name = "LEGAL_TYPE",length = 20)
    public LegalType getLegalType() {
        return legalType;
    }

    public void setLegalType(LegalType legalType) {
        this.legalType = legalType;
    }


    @Column(name = "ROOT_ADDRESS", length = 50)
    @Size(max = 50)
    public String getRootAddress() {
        return rootAddress;
    }

    public void setRootAddress(String rootAddress) {
        this.rootAddress = rootAddress;
    }

    @Column(name = "ADDRESS",length = 200)
    @Size(max = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "SEX",length = 10)
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }


    @Column(name = "PRI", nullable = false)
    public int getPriority() {
        return pri;
    }

    public void setPriority(int pri) {
        this.pri = pri;
    }

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "CARD", nullable = true)
    public MakeCard getMakeCard() {
        return this.makeCard;
    }

    public void setMakeCard(MakeCard makeCard) {
        this.makeCard = makeCard;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false, length = 16)
    @NotNull
    public PowerPersonType getType() {
        return type;
    }

    public void setType(PowerPersonType type) {
        this.type = type;
    }

    @Column(name = "OLD", nullable = false)
    public boolean isOld() {
        return old;
    }

    public void setOld(boolean old) {
        this.old = old;
    }


    @ManyToOne(fetch = FetchType.LAZY, targetEntity=ProxyPerson.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "PROXY_PERSON", nullable = true)
    public ProxyPersonEntity getPowerProxyPerson() {
        return proxyPerson;
    }

    public void setPowerProxyPerson(ProxyPersonEntity proxyPerson) {
        this.proxyPerson = proxyPerson;
    }

    @Transient
    public ProxyPerson getProxyPerson(){
        return (ProxyPerson) getPowerProxyPerson();
    }

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "powerPersons")
    public Set<BusinessHouse> getBusinessHouses() {
        return businessHouses;
    }

    public void setBusinessHouses(Set<BusinessHouse> businessHouses) {
        this.businessHouses = businessHouses;
    }
}
