package com.dgsoft.house.owner.model;
// Generated Aug 18, 2014 5:12:39 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * BusinessHouseMoney generated by hbm2java
 */
@Entity
@Table(name = "BUSINESS_MONEY", catalog = "HOUSE_OWNER_RECORD")
public class BusinessMoney implements java.io.Serializable {

	private String id;
	private Business business;
	private String moneyTypeId;
	private BigDecimal shouldMoney;
	private BigDecimal factMoney;
	private String chargeDetails;
	private String memo;

	public BusinessMoney() {
	}

	public BusinessMoney(String id, Business business) {
		this.id = id;
		this.business = business;
	}
	public BusinessMoney(String id, Business business, String moneyTypeId,
                         BigDecimal shouldMoney, BigDecimal factMoney, String chargeDetails,
                         String memo) {
		this.id = id;
		this.business = business;
		this.moneyTypeId = moneyTypeId;
		this.shouldMoney = shouldMoney;
		this.factMoney = factMoney;
		this.chargeDetails = chargeDetails;
		this.memo = memo;
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
	@JoinColumn(name = "BUSINESS", nullable = false)
	@NotNull
	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	@Column(name = "MONEY_TYPE_ID", length = 20)
	@Size(max = 20)
	public String getMoneyTypeId() {
		return this.moneyTypeId;
	}

	public void setMoneyTypeId(String moneyTypeId) {
		this.moneyTypeId = moneyTypeId;
	}

	@Column(name = "SHOULD_MONEY", precision = 18, scale = 3)
	public BigDecimal getShouldMoney() {
		return this.shouldMoney;
	}

	public void setShouldMoney(BigDecimal shouldMoney) {
		this.shouldMoney = shouldMoney;
	}

	@Column(name = "FACT_MONEY", precision = 18, scale = 3)
	public BigDecimal getFactMoney() {
		return this.factMoney;
	}

	public void setFactMoney(BigDecimal factMoney) {
		this.factMoney = factMoney;
	}

	@Column(name = "CHARGE_DETAILS", length = 200)
	@Size(max = 200)
	public String getChargeDetails() {
		return this.chargeDetails;
	}

	public void setChargeDetails(String chargeDetails) {
		this.chargeDetails = chargeDetails;
	}

	@Column(name = "MEMO", length = 200)
	@Size(max = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
