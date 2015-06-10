package com.dgsoft.house.model;
// Generated Jul 12, 2013 11:32:23 AM by Hibernate Tools 4.0.0

import com.dgsoft.common.system.PersonEntity;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * PoolOwner generated by hbm2java
 */
@Entity
@Table(name = "POOL_OWNER", catalog = "HOUSE_INFO")
public class PoolOwner implements java.io.Serializable,PersonEntity {

	private String id;
    private String personName;
    private String credentialsNumber;
    private PersonEntity.CredentialsType credentialsType;
	private String relation;
	private String perc;
    private BigDecimal area;
    private String memo;
    private String phone;
    private HouseContract houseContract;

	public PoolOwner() {
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 32)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	@NotNull
	@Size(max = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTRACT_ID", nullable = false)
	@NotNull
    public HouseContract getHouseContract() {
        return houseContract;
    }

    public void setHouseContract(HouseContract houseContract) {
        this.houseContract = houseContract;
    }

    @Column(name = "RELATION", length = 32)
	@Size(max = 32)
	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

    @Override
    @Column(name = "NAME",nullable = false,length = 50)
    @NotNull
    @Size(max = 50)
    public String getPersonName() {
        return personName;
    }

    @Override
    public void setPersonName(String name) {
        this.personName = name;
    }

    @Column(name = "ID_NO",nullable = false,length = 100)
    @NotNull
    @Size(max = 100)
    public String getCredentialsNumber() {
        return credentialsNumber;
    }

    public void setCredentialsNumber(String credentialsNumber) {
        this.credentialsNumber = credentialsNumber;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "ID_TYPE", nullable = false, length = 32)
    @NotNull
    public PersonEntity.CredentialsType getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(PersonEntity.CredentialsType credentialsType) {
        this.credentialsType = credentialsType;
    }

    @Column(name = "PERC", nullable = true, length = 10)
    @Size(max = 10)
    public String getPerc() {
        return perc;
    }

    public void setPerc(String perc) {
        this.perc = perc;
    }

    @Column(name = "POOL_AREA", nullable = true, scale = 4)
    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    @Column(name = "MEMO",nullable = true, length = 200)
    @Size(max = 200)
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Column(name = "PHONE", nullable = true, length = 15)
    @Size(max = 15)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
