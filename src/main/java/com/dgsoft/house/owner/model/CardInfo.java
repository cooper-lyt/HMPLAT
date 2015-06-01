package com.dgsoft.house.owner.model;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * Created by Administrator on 15-5-26.
 */
@Entity
@Table(name = "CARD_INFO", catalog = "HOUSE_OWNER_RECORD")
public class CardInfo  implements Serializable  {

    private String id;

    private String code;
    private String memo;
    private String makeEmpCode;
    private String makeEmpName;
    private Date printTime;



    private MakeCard makeCard;



    @OneToOne
    @PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
    public MakeCard getMakeCard() {
        return makeCard;
    }

    public void setMakeCard(MakeCard makeCard) {
        this.makeCard = makeCard;
    }



    public CardInfo(MakeCard makeCard){
        this.makeCard = makeCard;
    }


    public CardInfo(){

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

    @Column(name = "CODE", length = 100)
    @Size(max = 100)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "MEMO", length = 200)
    @Size(max = 200)
    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Column(name = "MAKE_EMP_CODE", nullable = false, length = 32)
    @NotNull
    @Size(max = 32)
    public String getMakeEmpCode() {
        return this.makeEmpCode;
    }

    public void setMakeEmpCode(String makeEmpCode) {
        this.makeEmpCode = makeEmpCode;
    }

    @Column(name = "MAKE_EMP_NAME", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    public String getMakeEmpName() {
        return this.makeEmpName;
    }

    public void setMakeEmpName(String makeEmpName) {
        this.makeEmpName = makeEmpName;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PRINT_TIME", nullable = false, length = 19)
    @NotNull
    public Date getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Date printTime) {
        this.printTime = printTime;
    }


}