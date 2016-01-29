package com.george.nileperch.domain.nileperch;

import com.george.nileperch.domain.AbstractModel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * Created by george on 1/18/16.
 */
public class Sales extends AbstractModel {
    @Column(nullable = false)
    @NotEmpty(message = "Please enter item name")
    private String item;

    @NotNull
    private Integer cost;

    @NotNull(message = "Please enter amount paid")
    private Integer amountPaid;

    private Integer balance = cost-amountPaid;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
