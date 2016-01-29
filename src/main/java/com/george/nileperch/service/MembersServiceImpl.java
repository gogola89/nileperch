package com.george.nileperch.service;

import com.george.nileperch.domain.enumeration.MemberState;
import com.george.nileperch.domain.nileperch.Members;
import com.george.nileperch.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by george on 1/18/16.
 */
@Service
@Transactional
public class MembersServiceImpl implements MembersService {

    @Autowired
    MembersRepository membersRepository;

    @Override
    public Members addNewMember(Members members){
        members.setMemberState(MemberState.ACTIVE);
        Members newMember = membersRepository.save(members);
        return newMember;
    }

    @Override
    public List<Members> findAllMembers(){return membersRepository.findAll();}

    @Override
    public Members getOneMember(Long id){return membersRepository.getOne(id);}

    @Override
    public boolean delete(Long id){membersRepository.delete(id);
    return true;
    }

    @Override
    public Members editMember(Members members){

       Members inDb = null;
        if(members.getId() != null){
            inDb = getOneMember(members.getId());

            inDb.setFirstName(members.getFirstName());
            inDb.setSecondName(members.getSecondName());
            inDb.setEmail(members.getEmail());
            inDb.setIdNumber(members.getIdNumber());
            inDb.setKraPin(members.getKraPin());
            inDb.setPhoneNumber(members.getPhoneNumber());
            inDb.setSex(members.getSex());
            inDb.setSirName(members.getSirName());

            membersRepository.save(inDb);
        }
        return inDb;
    }

}
