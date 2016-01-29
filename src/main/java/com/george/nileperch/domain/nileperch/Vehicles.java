package com.george.nileperch.domain.nileperch;

import com.george.nileperch.domain.AbstractModel;
import com.george.nileperch.domain.enumeration.VehicleState;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by george on 1/15/16.
 */
@Entity
public class Vehicles extends AbstractModel {
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Please enter vehicle reg no")
    private String regNo;

    @NotEmpty(message = "Please enter owner name")
    @Type(type = "text")
    private String ownerName;

    @NotEmpty(message = "Please fill in drivers name")
    @Type(type = "text")
    private String driversName;

    @NotEmpty(message = "Please enter conductors name")
    @Type(type = "text")
    private String conductorsName;

    @Enumerated(EnumType.STRING)
    private VehicleState vehicleState;

    @OneToMany(mappedBy = "Contribution")


    public String getRegNo(){return regNo;}

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getOwnerName(){return ownerName;}

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getDriversName(){return driversName;}

    public void setDriversName(String driversName) {
        this.driversName = driversName;
    }

    public String getConductorsName(){return conductorsName;}

    public void setConductorsName(String conductorsName) {
        this.conductorsName = conductorsName;
    }

    public VehicleState getVehicleState(){return vehicleState;}

    public void setVehicleState(VehicleState vehicleState) {
        this.vehicleState = vehicleState;
    }
}
