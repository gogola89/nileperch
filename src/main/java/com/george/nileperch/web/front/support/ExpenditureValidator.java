package com.george.nileperch.web.front.support;

import com.george.nileperch.domain.nileperch.Expenditure;
import com.george.nileperch.repository.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Created by george on 1/22/16.
 */
@Component
public class ExpenditureValidator {
    @Autowired
    ExpenditureRepository expenditureRepository;

    public boolean validateNewExpenditure(Expenditure expenditure, BindingResult bindingResult){
        Expenditure existingExpenditure= expenditureRepository.findById(expenditure.getId());
        if(existingExpenditure != null){
            bindingResult.reject("Expenditure with that Id already exists");
        }
        return bindingResult.hasErrors();
    }
}
