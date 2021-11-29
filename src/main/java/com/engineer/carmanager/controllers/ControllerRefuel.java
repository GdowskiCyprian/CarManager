package com.engineer.carmanager.controllers;

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

    @GetMapping(value = "/refuelAll")
    public List<Refuel> getRefuels() {
        return iRefuelService.getAllRefuel();
    }

    @GetMapping(path = "/{refuelID}")
    public Refuel getRefuelById(@PathVariable("refuelID") Long id) {
        return iRefuelService.getRefuelById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/postRefuel")
    public void postRefuel(@RequestBody Refuel refuel){
        iRefuelService.postRefuel(refuel);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRefuel/{id}")
    public void deleteRefuel(@PathVariable Long id){
        iRefuelService.deleteRefuel(id);
    }


}
