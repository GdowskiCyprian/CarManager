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

    @RequestMapping(method = RequestMethod.POST, value = "/postRepairPart") //used
    public void postRepairPart(@RequestBody RepairPartTemp repairPartTemp) throws IOException {
        iRepairPartService.postRepairPart(repairPartTemp);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRepairPart/{id}") //used
    public void deleteRepairPart(@PathVariable Long id){
        iRepairPartService.deleteRepairPart(id);
    }
}
