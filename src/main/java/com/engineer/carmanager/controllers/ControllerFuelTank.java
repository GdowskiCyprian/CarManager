package com.engineer.carmanager.controllers;


import com.engineer.carmanager.models.FuelTank;
import com.engineer.carmanager.services.iFuelTankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/fuelTanks")
public class ControllerFuelTank {
    @Autowired
    @Qualifier("FuelTankService")
    iFuelTankService iFuelTankService;

    @GetMapping(value = "/fuelTankAll")
    public List<FuelTank> getFuelTanks() {
        return iFuelTankService.getAllFuelTank();
    }

    @GetMapping(path = "/{fuelTankID}")
    public FuelTank getFuelTankByID(@PathVariable("fuelTankID") Long id) {
        return iFuelTankService.getFuelTankById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/postFuelTank")
    public void postFuelTank(@RequestBody FuelTank fuelTank){
        iFuelTankService.postFuelTank(fuelTank);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteFuelTank/{id}")
    public void deleteFuelTank(@PathVariable Long id){
        iFuelTankService.deleteFuelTank(id);
    }
}
