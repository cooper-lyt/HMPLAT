package com.dgsoft.house.owner.model;
// Generated Aug 19, 2014 4:32:06 PM by Hibernate Tools 4.0.0

import com.dgsoft.house.SalePayType;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * SaleInfo generated by hbm2java
 */
@Entity
@Table(name = "SALE_INFO", catalog = "HOUSE_OWNER_RECORD")
public class SaleInfo implements java.io.Serializable {

	private String id;
	private BusinessHouse  businessHouse;
	private SalePayType payType;
	private BigDecimal sumPrice;
    private BigDecimal superviseMoney;


    private BigDecimal giftArea;


	public SaleInfo() {
	}

    public SaleInfo(SaleInfo saleInfo,BusinessHouse  businessHouse) {
        this.businessHouse = businessHouse;
        this.payType = saleInfo.getPayType();
        this.sumPrice = saleInfo.getSumPrice();
        this.giftArea= saleInfo.getGiftArea();
    }

	public SaleInfo(SalePayType payType, BigDecimal sumPrice) {
		this.payType = payType;
		this.sumPrice = sumPrice;

	}
    public SaleInfo(SalePayType payType, BigDecimal sumPrice,BigDecimal giftArea,BigDecimal superviseMoney) {
        this.payType = payType;
        this.sumPrice = sumPrice;
        this.giftArea=giftArea;
        this.superviseMoney = superviseMoney;

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



	@Column(name = "PAY_TYPE", length = 32)
    @Enumerated(EnumType.STRING)
	public SalePayType getPayType() {
		return this.payType;
	}

	public void setPayType(SalePayType payType) {
		this.payType = payType;
	}

	@Column(name = "SUM_PRICE", nullable = false, scale = 4)
	@NotNull
	public BigDecimal getSumPrice() {
		return this.sumPrice;
	}

	public void setSumPrice(BigDecimal sumPrice) {
		this.sumPrice = sumPrice;
	}

    @Column(name = "SUPERVISE_MONEY", nullable = false, scale = 4)
    @NotNull
    public BigDecimal getSuperviseMoney() {
        return superviseMoney;
    }

    public void setSuperviseMoney(BigDecimal superviseMoney) {
        this.superviseMoney = superviseMoney;
    }

    @Column(name = "GIFTAREA", nullable = true, scale = 4)
    public BigDecimal getGiftArea() {
        return giftArea;
    }

    public void setGiftArea(BigDecimal giftArea) {
        this.giftArea = giftArea;
    }


    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "HOUSEID", nullable = false)
    @NotNull
    public BusinessHouse getBusinessHouse() {
        return businessHouse;
    }

    public void setBusinessHouse(BusinessHouse businessHouse) {
        this.businessHouse = businessHouse;
    }
}
