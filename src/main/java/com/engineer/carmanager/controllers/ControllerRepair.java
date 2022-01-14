package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.controllersHelpersModels.RepairTemp;
import com.engineer.carmanager.services.iRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/repairs")
public class ControllerRepair {
    @Autowired
    @Qualifier("RepairService")
    iRepairService iRepairService;

    @RequestMapping(method = RequestMethod.POST, value = "/postRepair") //used
    public String postRepair(@RequestBody RepairTemp repairTemp)
    {
        LocalDate date1 = LocalDate.parse(repairTemp.getDate());
        return iRepairService.postRepair(repairTemp.getName(), date1, repairTemp.getDescription(), repairTemp.getIdCar());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRepair/{id}") //used
    public void deleteRepair(@PathVariable Long id){
        System.out.println(id);
        iRepairService.deleteRepair(id);
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
