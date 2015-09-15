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
    private String legalDocuments;
    private String executionNotice;
    private String sendPeople;
    private String phone;
    private String executCardNo;
    private String workCardNo;

    private String HouseCardNo;
    private String ContractCode;
    private String ProjectRship;



	public CloseHouse() {
	}

    public CloseHouse(OwnerBusiness ownerBusiness, CloseHouse other) {
        this.ownerBusiness = ownerBusiness;
        this.closeDownClour = other.getCloseDownClour();
        this.action = other.getAction();
        this.closeDate = other.getCloseDate();
        this.toDate = other.getToDate();
        this.legalDocuments = other.getLegalDocuments();
        this.executionNotice = other.getExecutionNotice();
        this.sendPeople = other.getSendPeople();
        this.phone = other.getPhone();
        this.executCardNo = other.getExecutCardNo();
        this.workCardNo = other.getWorkCardNo();
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

	public void setOwnerBusiness(OwnerBusiness houseBusiness) {
		this.ownerBusiness = houseBusiness;
	}

	@Column(name = "CLOSE_DOWN_CLOUR", nullable = false, length = 100)
	@NotNull
	@Size(max = 100)
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
    @Column(name = "LEGAL_DOCUMENTS", length = 50)
    @Size(max = 50)
    public String getLegalDocuments() {
        return legalDocuments;
    }

    public void setLegalDocuments(String legalDocuments) {
        this.legalDocuments = legalDocuments;
    }

    @Column(name = "EXECUTION_NOTICE", length = 50)
    @Size(max = 50)
    public String getExecutionNotice() {
        return executionNotice;
    }

    public void setExecutionNotice(String executionNotice) {
        this.executionNotice = executionNotice;
    }

    @Column(name = "SEND_PEOPLE", length = 10)
    @Size(max = 10)
    public String getSendPeople() {
        return sendPeople;
    }

    public void setSendPeople(String sendPeople) {
        this.sendPeople = sendPeople;
    }

    @Column(name = "PHONE", length = 15)
    @Size(max = 15)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "EXECUTION_CARD_NO", length = 30)
    @Size(max = 30)
    public String getExecutCardNo() {
        return executCardNo;
    }

    public void setExecutCardNo(String executCardNo) {
        this.executCardNo = executCardNo;
    }

    @Column(name = "WORK_CARD_NO", length = 30)
    @Size(max = 30)
    public String getWorkCardNo() {
        return workCardNo;
    }

    public void setWorkCardNo(String workCardNo) {
        this.workCardNo = workCardNo;
    }

    @Column(name = "HOUSECARDNO", length = 30)
    @Size(max = 30)
    public String getHouseCardNo() {
        return HouseCardNo;
    }

    public void setHouseCardNo(String houseCardNo) {
        HouseCardNo = houseCardNo;
    }
    @Column(name = "CONTRACTCODE", length = 30)
    @Size(max = 30)
    public String getContractCode() {
        return ContractCode;
    }

    public void setContractCode(String contractCode) {
        ContractCode = contractCode;
    }

    @Column(name = "PROJECTRSIHP", length = 30)
    @Size(max = 30)
    public String getProjectRship() {
        return ProjectRship;
    }

    public void setProjectRship(String projectRship) {
        ProjectRship = projectRship;
    }
}
