package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.services.iRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/repairs")
public class ControllerRepair {
    @Autowired
    @Qualifier("RepairService")
    iRepairService iRepairService;

    @RequestMapping(method = RequestMethod.POST, value = "/postRepair") //used
    public String postRepair(@RequestBody Map<String, String> repairMap)
    {
        return iRepairService.postRepair(
                repairMap.get("name"),
                LocalDate.parse(repairMap.get("date")),
                repairMap.get("description"),
                Long.valueOf(repairMap.get("idCar"))
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRepair/{id}") //used
    public String deleteRepair(@PathVariable Long id){
        return iRepairService.deleteRepair(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getrepairsbycurrent/{id}") //used
    public List<Repair> getRepairByCurrentRepairShop(@PathVariable("id") Long id){
        return iRepairService.getRepairsByRepairShop(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/getrepairsbycurrentclient/{id}") //used
    public List<Repair> getRepairByCurrentClient(@PathVariable("id") Long id){
        return iRepairService.getRepairsByClient(id);
    }
}
