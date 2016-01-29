package com.george.nileperch.domain.nileperch;

import com.george.nileperch.domain.AbstractModel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

/**
 * Created by george on 01/24/16.
 */
@Entity
public class Assets extends AbstractModel {
    @NotEmpty(message = "Please enter item name")
    @Size(max = 20,message = "Name should not exceed 20 characters")
    private String item;
    private Integer qty;
    private Integer cost;
    private String description;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer quantity) {
        this.qty = qty;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
