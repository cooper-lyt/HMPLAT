package com.dgsoft.house.owner.model;
// Generated Aug 19, 2014 4:32:06 PM by Hibernate Tools 4.0.0

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Card generated by hbm2java
 */
@Entity
@Table(name = "CARD", catalog = "HOUSE_OWNER_RECORD")
public class Card implements java.io.Serializable {

    public enum CardType{NOTICE,OWNER_RSHIP,MORTGAGE,PROJECT_MORTGAGE,SALE_LICENSE,MERCHANDISE_CONTRAC};
	private String id;
	private OwnerBusiness ownerBusiness;
	private CardType type;
	private String number;



	public Card() {
	}

    public Card(CardType type) {
        this.type = type;
    }

    public Card(OwnerBusiness ownerBusiness, Card card) {
        this.ownerBusiness = ownerBusiness;
        this.type = card.getType();
        this.number = card.getNumber();
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUSINESS_ID", nullable = false)
	@NotNull
	public OwnerBusiness getOwnerBusiness() {
		return this.ownerBusiness;
	}

	public void setOwnerBusiness(OwnerBusiness ownerBusiness) {
		this.ownerBusiness = ownerBusiness;
	}

	@Column(name = "TYPE", nullable = false, length = 20)
	@NotNull
    @Enumerated(EnumType.STRING)
    public CardType getType() {
		return this.type;
	}

	public void setType(CardType type) {
		this.type = type;
	}

	@Column(name = "NUMBER", nullable = false, length = 100)
	@NotNull
	@Size(max = 100)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
