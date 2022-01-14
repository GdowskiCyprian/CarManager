package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.services.iRepairShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/repairshops")
public class ControllerRepairShop {
    @Autowired
    @Qualifier("RepairShopService")
    iRepairShopService iRepairShopService;

    @GetMapping(value = "/repairShopAll") //used
    public List<RepairShop> getRepairShops() {
        return iRepairShopService.getAllRepairShop();
    }

    @GetMapping(path="/getByMail/{repairShopMailAddress}") //used
    public RepairShop getRepairShopByMailAddress1(@PathVariable("repairShopMailAddress") String mailAddress){
        return iRepairShopService.getRepairShopByMailAddress(mailAddress);
    }

}
