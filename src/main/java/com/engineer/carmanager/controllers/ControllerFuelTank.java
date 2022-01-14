package com.engineer.carmanager.controllers;


import com.engineer.carmanager.controllersHelpersModels.FuelTankTemp;
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

    @RequestMapping(method = RequestMethod.POST, value = "/postFuelTank") //used
    public void postFuelTank(@RequestBody FuelTankTemp fuelTankTemp){
        iFuelTankService.postFuelTank(fuelTankTemp);
    }

}
