package com.george.nileperch.service;

import com.george.nileperch.domain.nileperch.Sales;
import com.george.nileperch.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by george on 1/24/16.
 */
@Service
@Transactional
public class SalesServiceImpl implements SalesService {

    @Autowired
    SalesRepository salesRepository;

    @Override
    public Sales addNewSale(Sales sales){
        Sales newSale = salesRepository.save(sales);
        return newSale;
    }

    @Override
    public List<Sales> findAllSales(){
        return salesRepository.findAll();
    }

    @Override
    public Sales getSale(Long id){
        return salesRepository.getOne(id);
    }

    @Override
    public boolean deleteSale(Long id){
        salesRepository.delete(id);
        return true;
    }

    @Override
    public Sales editSale(Sales sales){
        Sales inDb = null;
        if(sales.getId() != null){
            inDb = getSale(sales.getId());

            inDb.setItem(sales.getItem());
            inDb.setCost(sales.getCost());
            inDb.setAmountPaid(sales.getAmountPaid());
            inDb.setBalance(sales.getBalance());
        }
        return inDb;
    }
}
