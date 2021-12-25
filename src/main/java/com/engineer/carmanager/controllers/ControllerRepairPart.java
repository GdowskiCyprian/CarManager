package com.engineer.carmanager.controllers;


import com.engineer.carmanager.models.RepairPart;
import com.engineer.carmanager.controllersHelpersModels.RepairPartTemp;
import com.engineer.carmanager.services.iRepairPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    public void postRepairPart(@RequestBody RepairPartTemp repairPartTemp) throws IOException {
        iRepairPartService.postRepairPart(repairPartTemp);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRepairPart/{id}")
    public void deleteRepairPart(@PathVariable Long id){
        iRepairPartService.deleteRepairPart(id);
    }
}
