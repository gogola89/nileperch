package com.george.nileperch.service;

import com.george.nileperch.domain.nileperch.Contribution;
import com.george.nileperch.repository.ContRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by george on 1/22/16.
 */
@Service
@Transactional
public class ContServiceImpl implements ContService {

    @Autowired
    ContRepository contRepository;

    @Override
    public Contribution addNewCont(Contribution contribution){
        Contribution newCont = contRepository.save(contribution);
        return newCont;
    }

    @Override
    public List<Contribution> findAllConts(){
        return contRepository.findAll();
    }

    @Override
    public Contribution getOneCont(Long id){
        return contRepository.getOne(id);
    }

    @Override
    public boolean delete(Long id){
        contRepository.delete(id);
        return true;
    }

    @Override
    public Contribution editCont(Contribution contribution){
        Contribution inDb = null;
        if(inDb != null){
            inDb = getOneCont(contribution.getId());

            inDb.setOfficeCont(contribution.getOfficeCont());
            inDb.setShareCont(contribution.getShareCont());
            inDb.setPaidBy(contribution.getPaidBy());
            inDb.setRegNo(contribution.getRegNo());
        }
        return inDb;
    }
}
