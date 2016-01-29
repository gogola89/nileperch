package com.george.nileperch.web.front.support;

import com.george.nileperch.domain.nileperch.Contribution;
import com.george.nileperch.repository.ContRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Created by george on 1/22/16.
 */
@Component
public class ContValidator {
    @Autowired
    ContRepository contRepository;

    public boolean validateCont(Contribution contribution,BindingResult bindingResult){
        Contribution existingCont = contRepository.getOne(contribution.getId());
        if(existingCont != null){
            bindingResult.rejectValue("Already contributed","Contribution exists");
        }
        return bindingResult.hasErrors();
    }
}
