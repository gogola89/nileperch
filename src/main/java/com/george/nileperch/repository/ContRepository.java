package com.george.nileperch.repository;

import com.george.nileperch.domain.nileperch.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by george on 1/22/16.
 */
@Repository
public interface ContRepository extends JpaRepository<Contribution,Long>{
   public Contribution findById(Long id);
}
