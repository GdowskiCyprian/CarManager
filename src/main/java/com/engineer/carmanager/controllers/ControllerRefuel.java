package com.engineer.carmanager.controllers;

import com.engineer.carmanager.controllersHelpersModels.RefuelTemp;
import com.engineer.carmanager.models.Refuel;
import com.engineer.carmanager.services.iRefuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/refuels")
public class ControllerRefuel {
    @Autowired
    @Qualifier("RefuelService")
    iRefuelService iRefuelService;

    @RequestMapping(method = RequestMethod.POST, value = "/postRefuel")  //used
    public void postRefuel(@RequestBody RefuelTemp refuelTemp){
        iRefuelService.postRefuel(refuelTemp);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRefuel/{id}") //used
    public void deleteRefuel(@PathVariable Long id){
        iRefuelService.deleteRefuel(id);
    }

    @GetMapping("/getcurrentrefuels/{id}") //used
    public List<Refuel> getCurrentCars(@PathVariable("id") Long id){
        return iRefuelService.getCurrentRefuels(id);
    }

}
