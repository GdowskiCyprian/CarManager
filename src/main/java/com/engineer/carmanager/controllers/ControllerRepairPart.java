package com.engineer.carmanager.controllers;

import com.engineer.carmanager.services.iRepairPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/repairParts")
public class ControllerRepairPart {

    @Autowired
    @Qualifier("RepairPartService")
    iRepairPartService iRepairPartService;

    @RequestMapping(method = RequestMethod.POST, value = "/postRepairPart") //used
    public String postRepairPart(@RequestBody Map<String, String> repairPartMap) {
        return iRepairPartService.postRepairPart(
                repairPartMap.get("partname"),
                repairPartMap.get("partdescription"),
                Double.valueOf(repairPartMap.get("price")),
                Long.valueOf(repairPartMap.get("idRepair"))
        );
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRepairPart/{id}") //used
    public String deleteRepairPart(@PathVariable Long id){
        return iRepairPartService.deleteRepairPart(id);
    }
}
