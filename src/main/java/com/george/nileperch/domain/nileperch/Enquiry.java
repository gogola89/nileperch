package com.george.nileperch.domain.nileperch;

import com.george.nileperch.domain.AbstractModel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

/**
 * Created by george on 1/18/16.
 */
public class Enquiry extends AbstractModel {
    @Column(nullable = false)
    @NotEmpty(message = "Enter the subject of your query")
    private String subject;

    @Column(nullable = false)
    @NotEmpty(message = "Please enter your question")
    private String message;

    @ManyToOne

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
