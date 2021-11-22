package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.services.iRepairShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/repairshops")
public class ControllerRepairShop {
    @Autowired
    @Qualifier("RepairShopService")
    iRepairShopService iRepairShopService;

    @GetMapping(value = "/repairShopAll")
    public List<RepairShop> getRepairShops() {
        return iRepairShopService.getAllRepairShop();
    }

    @GetMapping(path = "/{repairShopID}")
    public RepairShop getRepairShopById(@PathVariable("repairShopID") Long id) {
        return iRepairShopService.getRepairShopById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/postRepairShop")
    public void postRepairShop(@RequestBody RepairShop repairShop){
        iRepairShopService.postRepairShop(repairShop);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRepairShop/{id}")
    public void deleteRepairShop(@PathVariable Long id){
        iRepairShopService.deleteRepairShop(id);
    }

    @GetMapping(path="/getByMail/{repairShopMailAddress}")
    public RepairShop getRepairShopByMailAddress1(@PathVariable("repairShopMailAddress") String mailAddress){
        return iRepairShopService.getRepairShopByMailAddress(mailAddress);
    }

}
