package com.george.nileperch.repository;

import com.george.nileperch.domain.nileperch.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by george on 1/20/16.
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicles, Long>{
    Vehicles findByRegNo(String regNo);

}
