package com.george.nileperch.service;

import com.george.nileperch.domain.enumeration.VehicleState;
import com.george.nileperch.domain.nileperch.Vehicles;
import com.george.nileperch.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by george on 1/20/16.
 */
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicles addNewVehicle(Vehicles vehicles){
        vehicles.setVehicleState(VehicleState.ACTIVE);
        Vehicles newVehicle = vehicleRepository.save(vehicles);

        return newVehicle;
    }

    @Override
    public List<Vehicles> findAllVehicles(){
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicles getOneVehicle(Long id){
        return vehicleRepository.getOne(id);
    }

    @Override
    public boolean delete(Long id){
        vehicleRepository.delete(id);
        return true;
    }

    @Override
    public Vehicles editVehicle(Vehicles vehicles){
        Vehicles inDb = null;
        if(vehicles.getId() != null){
            inDb = getOneVehicle(vehicles.getId());

            inDb.setRegNo(vehicles.getRegNo());
            inDb.setOwnerName(vehicles.getOwnerName());
            inDb.setDriversName(vehicles.getDriversName());
            inDb.setConductorsName(vehicles.getConductorsName());

            vehicleRepository.save(inDb);
        }
        return inDb;
    }


}
