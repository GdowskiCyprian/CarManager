package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.services.iRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repairs")
public class ControllerRepair {
    @Autowired
    @Qualifier("RepairService")
    iRepairService iRepairService;

    @GetMapping(value = "/repairAll")
    public List<Repair> getRepairs() {
        return iRepairService.getAllRepair();
    }

    @GetMapping(path = "/{repairID}")
    public Repair getRepairById(@PathVariable("repairID") Long id) {
        return iRepairService.getRepairById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/postRepair")
    public void postRepair(@RequestBody Repair repair){
        iRepairService.postRepair(repair);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRepair/{id}")
    public void deleteRepair(@PathVariable Long id){
        iRepairService.deleteRepair(id);
    }
}
