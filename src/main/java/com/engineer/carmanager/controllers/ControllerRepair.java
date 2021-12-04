package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.services.iRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "*")
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
    public void postRepair(@RequestParam String name, @RequestParam String date, @RequestParam String description, @RequestParam Long idCar){
        LocalDate date1 = LocalDate.parse(date);
        System.out.println("aaa");
        iRepairService.postRepair(name, date1, description, idCar);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRepair/{id}")
    public void deleteRepair(@PathVariable Long id){
        System.out.println(id);
        iRepairService.deleteRepair(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getrepairsbycurrent/{id}")
    public List<Repair> getRepairByCurrentRepairShop(@PathVariable("id") Long id){
        return iRepairService.getRepairsByRepairShop(id);
    }
}
