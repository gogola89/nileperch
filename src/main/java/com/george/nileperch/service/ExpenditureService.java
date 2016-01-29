package com.george.nileperch.service;

import com.george.nileperch.domain.nileperch.Expenditure;

import java.util.List;

/**
 * Created by george on 1/20/16.
 */
public interface ExpenditureService {
    public Expenditure addNewExpenditure(Expenditure expenditure);
    public Expenditure getExpenditure(Long id);
    public List<Expenditure> getAllExpenditures();
    public boolean delete(Long id);
    public Expenditure editExpenditure(Expenditure expenditure);
}
