package com.george.nileperch.web.front.support;

import com.george.nileperch.domain.nileperch.Vehicles;
import com.george.nileperch.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Created by george on 1/20/16.
 */
@Component
public class VehicleValidator {
    @Autowired
    VehicleRepository vehicleRepository;

    public boolean validateVehicle(Vehicles vehicles, BindingResult bindingResult){
        Vehicles existingVehicle = vehicleRepository.findByRegNo(vehicles.getRegNo());
        if(existingVehicle != null){
            bindingResult.rejectValue("Vehicle already exists","Vehicle cant be added");
        }
        return bindingResult.hasErrors();
    }
}
