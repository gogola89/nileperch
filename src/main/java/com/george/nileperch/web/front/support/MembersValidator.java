package com.george.nileperch.web.front.support;

import com.george.nileperch.domain.nileperch.Members;
import com.george.nileperch.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Created by george on 1/19/16.
 */
@Component
public class MembersValidator {

    @Autowired
    MembersRepository membersRepository;

    public boolean validateNewMember(Members members, BindingResult bindingResult){
        Members existingMember = membersRepository.findByIdNumber(members.getIdNumber());
        if(existingMember != null){
            bindingResult.reject("User with that Id already exists");
        }
        return bindingResult.hasErrors();
    }
}
