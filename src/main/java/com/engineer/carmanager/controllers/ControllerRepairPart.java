package com.engineer.carmanager.controllers;


import com.engineer.carmanager.models.RepairPart;
import com.engineer.carmanager.services.iRepairPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/repairParts")
public class ControllerRepairPart {

    @Autowired
    @Qualifier("RepairPartService")
    iRepairPartService iRepairPartService;

    @GetMapping(value = "/repairPartAll")
    public List<RepairPart> getRepairParts() {
        return iRepairPartService.getAllRepairPart();
    }

    @GetMapping(path = "/{repairPartID}")
    public RepairPart getRepairPartById(@PathVariable("repairPartID") Long id) {
        return iRepairPartService.getRepairPartById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/postRepairPart")
    public void postRepairPart(@RequestBody RepairPart repairPart){
        iRepairPartService.postRepairPart(repairPart);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRepairPart/{id}")
    public void deleteRepairPart(@PathVariable Long id){
        System.out.println(id);
        iRepairPartService.deleteRepairPart(id);
    }
}
