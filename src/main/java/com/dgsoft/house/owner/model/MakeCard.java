package com.dgsoft.house.owner.model;
// Generated Oct 11, 2014 3:13:15 PM by Hibernate Tools 4.0.0

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * MakeCard generated by hbm2java
 */
@Entity
@Table(name = "MAKE_CARD", catalog = "HOUSE_OWNER_RECORD")
public class MakeCard implements java.io.Serializable {


    public enum CardType{NOTICE,OWNER_RSHIP,MORTGAGE,PROJECT_MORTGAGE,POOL_RSHIP};
	private String id;
	private OwnerBusiness ownerBusiness;
	private CardType type;
	private String number;
    private boolean disable;
    //private Set<OtherPowerCard> otherPowerCards = new HashSet<OtherPowerCard>(0);


    private CardInfo cardInfo;


    public MakeCard() {

    }


    public MakeCard(CardType type,boolean disable,String number) {
        this.type = type;
        this.disable = disable;
        this.number = number;
	}

    public MakeCard(String id,OwnerBusiness ownerBusiness,CardType type,String number,boolean disable){
        this.id = id;
        this.ownerBusiness = ownerBusiness;
        this.type = type;
        this.number = number;
        this.disable = disable;

    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
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


    @Column(name = "DISABLE",nullable = false)
    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }


//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "makeCardByCard")
//    public Set<OtherPowerCard> getOtherPowerCards() {
//        return otherPowerCards;
//    }
//
//    public void setOtherPowerCards(Set<OtherPowerCard> otherPowerCards) {
//        this.otherPowerCards = otherPowerCards;
//    }



}
