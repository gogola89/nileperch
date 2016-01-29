package com.george.nileperch.domain.nileperch;

import com.george.nileperch.domain.AbstractModel;
import com.george.nileperch.domain.enumeration.MemberState;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by george on 1/15/16.
 */
@Entity
public class Members extends AbstractModel {
    @Column(nullable = false)
    @NotEmpty(message = "Please enter first name")
    @Size(max = 20,message = "Not more than 20 characters")
    private String firstName;

    @Column(nullable = false)
    @NotEmpty(message = "Please enter second name")
    @Size(max = 20,message = "Not more than 20 characters")
    private String secondName;

    @Column(nullable = false)
    @NotEmpty(message = "Please enter sirname")
    @Size(max = 20,message = "Not more than 20 characters")
    private String sirName;

    @Column(unique = true)
    @Email
    private String email;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Please enter phone number")
    private long phoneNumber;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "KRA PIN required")
    private String kraPin;

    @Column(nullable = false)
    @NotEmpty
    private String sex;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Please enter national ID Number")
    private Long idNumber;

    @Enumerated(EnumType.STRING)
    private MemberState memberState;

    @OneToMany(mappedBy = "Vehicles")

    public String getFirstName(){return firstName;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public  String getSecondName(){return secondName;}

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSirName(){return sirName;}

    public void setSirName(String sirName) {
        this.sirName = sirName;
    }

    public String getEmail(){return email;}

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber(){return phoneNumber;}

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getKraPin(){return kraPin;}

    public void setKraPin(String kraPin) {
        this.kraPin = kraPin;
    }

    public String getSex(){return sex;}

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getIdNumber(){return idNumber;}

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public MemberState getMemberState() {
        return memberState;
    }

    public void setMemberState(MemberState memberState) {
        this.memberState = memberState;
    }

    public String getFullNames(){
        return getFirstName()+" "+getSecondName()+" "+getSirName();
    }
}
