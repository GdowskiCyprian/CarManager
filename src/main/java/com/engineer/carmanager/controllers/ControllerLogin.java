package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.services.iClientService;
import com.engineer.carmanager.services.iRepairShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ControllerLogin {
    @Autowired
    @Qualifier("RepairShopService")
    iRepairShopService iRepairShopService;
    @Qualifier("ClientService")
    iClientService iClientService;
    @CrossOrigin
    @GetMapping("/login/{emailAddress}")
    public String loginCommunicate(@PathVariable("emailAddress") String mailAddress){
        if(iRepairShopService.getAllRepairShop().stream().anyMatch(RepairShop -> RepairShop.getMailAddress().equals(mailAddress))){
            return "REPAIR_SHOP";
        }
        else{
            return "CLIENT";
        }

    }

}
