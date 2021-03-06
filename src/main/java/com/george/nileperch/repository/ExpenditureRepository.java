package com.george.nileperch.repository;

import com.george.nileperch.domain.nileperch.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by george on 1/20/16.
 */
@Repository
public interface ExpenditureRepository extends JpaRepository<Expenditure,Long>{
    public Expenditure findById(Long id);
}
