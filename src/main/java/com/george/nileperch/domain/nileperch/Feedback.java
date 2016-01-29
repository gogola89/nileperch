package com.george.nileperch.domain.nileperch;

import com.george.nileperch.domain.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Created by george on 1/18/16.
 */
@Entity
public class Feedback extends AbstractModel {
    private String feedbackMsg;

    public String getFeedbackMsg() {
        return feedbackMsg;
    }

    public void setFeedbackMsg(String feedbackMsg) {
        this.feedbackMsg = feedbackMsg;
    }
}
