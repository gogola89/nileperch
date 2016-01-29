package com.george.nileperch.service;

import com.george.nileperch.domain.nileperch.Contribution;

import java.util.List;

/**
 * Created by george on 1/22/16.
 */
public interface ContService {
    public Contribution addNewCont(Contribution contribution);
    public List<Contribution> findAllConts();
    public Contribution editCont(Contribution contribution);
    public Contribution getOneCont(Long id);
    public  boolean delete(Long id);
}
