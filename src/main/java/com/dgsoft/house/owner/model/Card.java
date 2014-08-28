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

	private String id;
	private OwnerBusiness ownerBusiness;
	private String type;
	private String number;

	public Card() {
	}

	public Card(String id, OwnerBusiness ownerBusiness, String type,
			String number) {
		this.id = id;
		this.ownerBusiness = ownerBusiness;
		this.type = type;
		this.number = number;
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

	@Column(name = "TYPE", nullable = false, length = 10)
	@NotNull
	@Size(max = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
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
