package com.dgsoft.house.owner.model;
// Generated Aug 19, 2014 4:32:06 PM by Hibernate Tools 4.0.0

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * CloseHouse generated by hbm2java
 */
@Entity
@Table(name = "CLOSE_HOUSE", catalog = "HOUSE_OWNER_RECORD")
public class CloseHouse implements java.io.Serializable {

	private String id;
	private OwnerBusiness ownerBusiness;
	private String closeDownClour;
	private String action;
	private Date closeDate;
	private Date toDate;

	public CloseHouse() {
	}

	public CloseHouse(String id, OwnerBusiness ownerBusiness,
			String closeDownClour, Date closeDate) {
		this.id = id;
		this.ownerBusiness = ownerBusiness;
		this.closeDownClour = closeDownClour;
		this.closeDate = closeDate;
	}
	public CloseHouse(String id, OwnerBusiness ownerBusiness,
			String closeDownClour, String action, Date closeDate, Date toDate) {
		this.id = id;
		this.ownerBusiness = ownerBusiness;
		this.closeDownClour = closeDownClour;
		this.action = action;
		this.closeDate = closeDate;
		this.toDate = toDate;
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
	public OwnerBusiness getHouseBusiness() {
		return this.ownerBusiness;
	}

	public void setHouseBusiness(OwnerBusiness houseBusiness) {
		this.ownerBusiness = houseBusiness;
	}

	@Column(name = "CLOSE_DOWN_CLOUR", nullable = false, length = 32)
	@NotNull
	@Size(max = 32)
	public String getCloseDownClour() {
		return this.closeDownClour;
	}

	public void setCloseDownClour(String closeDownClour) {
		this.closeDownClour = closeDownClour;
	}

	@Column(name = "ACTION", length = 100)
	@Size(max = 100)
	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CLOSE_DATE", nullable = false, length = 19)
	@NotNull
	public Date getCloseDate() {
		return this.closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TO_DATE", length = 19)
	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
