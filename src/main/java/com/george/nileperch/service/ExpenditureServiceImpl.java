package com.george.nileperch.service;

import com.george.nileperch.domain.nileperch.Expenditure;
import com.george.nileperch.repository.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by george on 1/20/16.
 */
@Service
@Transactional
public class ExpenditureServiceImpl implements ExpenditureService{
    @Autowired
    ExpenditureRepository expenditureRepository;

    @Override
    public Expenditure addNewExpenditure(Expenditure expenditure){
        Expenditure newExpenditure = expenditureRepository.save(expenditure);
        return newExpenditure;
    }

    @Override
    public List<Expenditure> getAllExpenditures(){
        return expenditureRepository.findAll();
    }

    @Override
    public Expenditure getExpenditure(Long id){
        return expenditureRepository.findOne(id);
    }
    @Override
    public boolean delete(Long id){
        expenditureRepository.delete(id);
        return true;
    }

    @Override
    public Expenditure editExpenditure(Expenditure expenditure){
        Expenditure inDb = null;
        if(expenditure.getId() !=null){
            inDb = getExpenditure(expenditure.getId());

            inDb.setItem(expenditure.getItem());
            inDb.setQty(expenditure.getQty());
            inDb.setCost(expenditure.getCost());
            inDb.setDescription(expenditure.getDescription());
            expenditureRepository.save(expenditure);
        }
        return inDb;

    }
}
