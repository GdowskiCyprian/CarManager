package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.Refuel;
import com.engineer.carmanager.models.typeOfFuel;
import com.engineer.carmanager.services.iRefuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/refuels")
public class ControllerRefuel {
    @Autowired
    @Qualifier("RefuelService")
    iRefuelService iRefuelService;

    @RequestMapping(method = RequestMethod.POST, value = "/postRefuel")  //used
    public String postRefuel(@RequestBody Map<String, String> refuelTempMap){
        return iRefuelService.postRefuel(
                Long.valueOf(refuelTempMap.get("idCar")),
                typeOfFuel.valueOf(refuelTempMap.get("typeOfFuel")),
                Double.valueOf(refuelTempMap.get("price")),
                Double.valueOf(refuelTempMap.get("volume"))
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRefuel/{id}") //used
    public String deleteRefuel(@PathVariable Long id){
        return iRefuelService.deleteRefuel(id);
    }

    @GetMapping("/getcurrentrefuels/{id}") //used
    public List<Refuel> getCurrentCars(@PathVariable("id") Long id){
        return iRefuelService.getCurrentRefuels(id);
    }

}
