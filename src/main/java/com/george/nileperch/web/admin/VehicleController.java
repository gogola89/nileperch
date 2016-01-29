package com.george.nileperch.web.admin;

import com.george.nileperch.domain.nileperch.Vehicles;
import com.george.nileperch.service.VehicleService;
import com.george.nileperch.web.front.support.VehicleValidator;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by george on 1/20/16.
 */
@Controller
@RequestMapping(value = "/admin/nileperch")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @Autowired
    VehicleValidator vehicleValidator;

    @RequestMapping(value = "/vehicleForm")
    public String newVehicle(Model model) {
        model.addAttribute("vehicle", new Vehicles());
        model.addAttribute("action", "CREATE");
        return "/admin/nileperch/vehicleForm";
    }

    @RequestMapping(value = "/vehicle/{id}/edit",method = RequestMethod.GET)
    public String editVehicle(@PathVariable("id") Long id,Model model){
        Vehicles vehicles = vehicleService.getOneVehicle(id);
        model.addAttribute("vehicle",vehicles);
        model.addAttribute("action", "EDIT");
        return "/admin/nileperch/vehicleForm";
    }

    @RequestMapping(value = "/vehicle/{action}")
    public String addVehicle(@ModelAttribute @Valid Vehicles vehicles, BindingResult bindingResult,
                             @PathVariable("action") String action, Model model) {
        String path = "Failed";
        if (action.equals("CREATE")) {
            vehicleValidator.validateVehicle(vehicles, bindingResult);
            if (bindingResult.hasErrors()) {
                model.addAttribute("vehicle", vehicles);
                return "/admin/nileperch/vehicleForm";
            }
            Vehicles newVehicle = vehicleService.addNewVehicle(vehicles);
            return "redirect:/admin/nileperch/vehicles";
        }
        if (action.equals("EDIT")) {
            Vehicles editedVehicle = vehicleService.editVehicle(vehicles);
            return "redirect:/admin/nileperch/vehicle" + vehicles.getId();
        }
        return path;
    }

    @RequestMapping(value = "/vehicles",method = RequestMethod.GET)
    public String getVehicleList(Model model){
        List<Vehicles> vehicles = vehicleService.findAllVehicles();
        model.addAttribute("vehicles",vehicles);
        return "/admin/nileperch/vehicleList";
    }

    @RequestMapping(value = "/vehicle/{id}",method = RequestMethod.GET)
    public String getVehicle(@PathVariable("id") Long id,Model model){
        Vehicles vehicles = vehicleService.getOneVehicle(id);
        model.addAttribute("vehicle",vehicles);
        return "/admin/nileperch/vehicle";
    }


    @RequestMapping(value = "/vehicle/{id}/delete",method = RequestMethod.GET)
    public String deleteVehicle(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
        boolean message = vehicleService.delete(id);
        redirectAttributes.addFlashAttribute("message",message);
        return "redirect:/admin/nileperch/vehicles";
    }

}
