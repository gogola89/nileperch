package com.george.nileperch.domain.nileperch;

import com.george.nileperch.domain.AbstractModel;

import javax.persistence.Entity;

/**
 * Created by wladek on 11/24/15.
 */
@Entity
public class Transaction extends AbstractModel {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
