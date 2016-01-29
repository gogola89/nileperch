package com.george.nileperch.service;

import com.george.nileperch.domain.nileperch.Sales;

import java.util.List;

/**
 * Created by george on 1/24/16.
 */
public interface SalesService {

    public Sales addNewSale(Sales sales);
    public Sales editSale(Sales sales);
    public Sales getSale(Long id);
    public List<Sales> findAllSales();
    public boolean deleteSale(Long id);
}
