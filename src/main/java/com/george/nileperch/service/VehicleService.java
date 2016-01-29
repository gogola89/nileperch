package com.george.nileperch.service;

import com.george.nileperch.domain.nileperch.Vehicles;

import java.util.List;

/**
 * Created by george on 1/20/16.
 */
public interface VehicleService {
    public Vehicles addNewVehicle(Vehicles vehicles);
    public List<Vehicles> findAllVehicles();
    public Vehicles getOneVehicle(Long id);
    public Vehicles editVehicle(Vehicles vehicles);
    public boolean delete(Long id);
}
