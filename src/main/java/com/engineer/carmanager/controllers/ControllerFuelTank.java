package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.typeOfFuel;
import com.engineer.carmanager.services.iFuelTankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/fuelTanks")
public class ControllerFuelTank {
    @Autowired
    @Qualifier("FuelTankService")
    iFuelTankService iFuelTankService;

    @RequestMapping(method = RequestMethod.POST, value = "/postFuelTank") //used
    public void postFuelTank(@RequestBody Map<String, String> fuelTankMap){
        iFuelTankService.postFuelTank(Long.valueOf(fuelTankMap.get("idCar")), typeOfFuel.valueOf(fuelTankMap.get("typeOfFuel")), Double.valueOf(fuelTankMap.get("capacity")));
    }

}
