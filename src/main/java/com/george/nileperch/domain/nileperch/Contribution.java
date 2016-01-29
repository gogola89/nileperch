package com.george.nileperch.domain.nileperch;

import com.george.nileperch.domain.AbstractModel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by george on 1/18/16.
 */
@Entity
public class Contribution extends AbstractModel {
    String regNo;
    private Integer officeCont;
    private Integer shareCont;
    @NotEmpty(message = "Enter name of paying individual")
    private String paidBy;

    public Integer getOfficeCont() {
        return officeCont;
    }

    public void setOfficeCont(Integer officeCont) {
        this.officeCont = officeCont;
    }

    public Integer getShareCont() {
        return shareCont;
    }

    public void setShareCont(Integer shareCont) {
        this.shareCont = shareCont;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
