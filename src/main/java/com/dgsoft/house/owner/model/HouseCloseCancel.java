package com.dgsoft.house.owner.model;
// Generated Aug 19, 2014 4:32:06 PM by Hibernate Tools 4.0.0

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * HouseCloseCancel generated by hbm2java
 */
@Entity
@Table(name = "HOUSE_CLOSE_CANCEL", catalog = "HOUSE_OWNER_RECORD")
public class HouseCloseCancel implements java.io.Serializable {

	private String id;
	private OwnerBusiness ownerBusiness;
	private Date cancelDate;
    private String clour;
    private String action;
    private String legalDocuments;
    private String executionNotice;
    private String sendPerson;
    private String phone;
    private String executionCardNumber;
    private String workCardNumber;

    private String houseCardNo;
    private String contractCode;
    private String projectRship;



    public HouseCloseCancel() {
	}

    public HouseCloseCancel(OwnerBusiness ownerBusiness,HouseCloseCancel other) {
        this.ownerBusiness = ownerBusiness;
        this.cancelDate = other.getCancelDate();
        this.clour = other.getClour();
        this.action = other.getAction();
        this.legalDocuments = other.getLegalDocuments();
        this.executionNotice = other.getExecutionNotice();
        this.sendPerson = other.getSendPerson();
        this.phone = other.getPhone();
        this.executionCardNumber = other.getExecutionCardNumber();
        this.workCardNumber = other.getWorkCardNumber();
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CANCEL_DATE", nullable = false, length = 19)
	@NotNull
	public Date getCancelDate() {
		return this.cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

    @Column(name = "CANCEL_DOWN_CLOUR", length = 100, nullable = false)
    @NotNull
    @Size(max = 100)
    public String getClour() {
        return clour;
    }

    public void setClour(String clour) {
        this.clour = clour;
    }

    @Column(name="ACTION",length = 100)
    @Size(max = 100)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

    @Column(name = "SEND_PEOPLE",length = 10)
    @Size(max = 10)
    public String getSendPerson() {
        return sendPerson;
    }

    public void setSendPerson(String sendPerson) {
        this.sendPerson = sendPerson;
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
    public String getExecutionCardNumber() {
        return executionCardNumber;
    }

    public void setExecutionCardNumber(String executionCardNumber) {
        this.executionCardNumber = executionCardNumber;
    }

    @Column(name = "WORK_CARD_NO", length = 30)
    @Size(max = 30)
    public String getWorkCardNumber() {
        return workCardNumber;
    }

    public void setWorkCardNumber(String workCardNumber) {
        this.workCardNumber = workCardNumber;
    }




    @Column(name = "HOUSECARDNO", length = 30)
    @Size(max = 30)
    public String getHouseCardNo() {
        return houseCardNo;
    }

    public void setHouseCardNo(String houseCardNo) {
        this.houseCardNo = houseCardNo;
    }

    @Column(name = "CONTRACTCODE", length = 30)
    @Size(max = 30)
    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    @Column(name = "PROJECTRSIHP", length = 30)
    @Size(max = 30)
    public String getProjectRship() {
        return projectRship;
    }

    public void setProjectRship(String projectRship) {
        this.projectRship = projectRship;
    }
}
