package com.george.nileperch.domain.nileperch;

import com.george.nileperch.domain.AbstractModel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Created by george on 1/18/16.
 */
@Entity
public class Expenditure extends AbstractModel {
    @NotEmpty(message = "Please enter item")
    private String item;
    private int qty;
    @NotNull(message = "Please enter cost")
    private long cost;
    @Column(nullable = false)
    @NotEmpty(message = "Please describe the expenditure")
    private String description;

    @OneToMany(mappedBy = "Sales")

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
