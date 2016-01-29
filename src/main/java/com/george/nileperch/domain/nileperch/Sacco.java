package com.george.nileperch.domain.nileperch;

import com.george.nileperch.domain.AbstractModel;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by george on 1/18/16.
 */
@Entity
public class Sacco extends AbstractModel{
    @Column(nullable = false)
    @NotEmpty(message = "Enter sacco name")
    private String saccoName;

    @Column(nullable = false)
    @NotEmpty
    private String saccoPin;

    @Email
    private String email;

    public String getSaccoName() {
        return saccoName;
    }

    public void setSaccoName(String saccoName) {
        this.saccoName = saccoName;
    }

    public String getSaccoPin() {
        return saccoPin;
    }

    public void setSaccoPin(String saccoPin) {
        this.saccoPin = saccoPin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
