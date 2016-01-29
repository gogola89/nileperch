package com.george.nileperch.repository;

import com.george.nileperch.domain.nileperch.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by george on 1/23/16.
 */
@Repository
public interface SalesRepository extends JpaRepository<Sales,Long> {

}
