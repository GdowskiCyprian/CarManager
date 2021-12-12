package com.engineer.carmanager.controllers;

import com.engineer.carmanager.controllersHelpersModels.ClientTemp;
import com.engineer.carmanager.controllersHelpersModels.RepairShopTemp;
import com.engineer.carmanager.models.Auth;
import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.services.iAuthenticationService;
import com.engineer.carmanager.services.iClientService;
import com.engineer.carmanager.services.iRepairShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin
@RestController
public class ControllerLogin {
    @Autowired
    @Qualifier("AuthenticationService")
    private iAuthenticationService iAuthenticationService;
    @GetMapping("/login/{emailAddress}")
    public String loginCommunicate(@PathVariable("emailAddress") String email){

        return iAuthenticationService.login(email);
    }
    @PostMapping("/register/repairshop")
    public String registerRepairShop(@RequestBody RepairShopTemp repairShopTemp){
        return this.iAuthenticationService.registerRepairShop(repairShopTemp.getEmail(),
                repairShopTemp.getPassword(), repairShopTemp.getName(), repairShopTemp.getPhoneNumber(),
                repairShopTemp.getNip());
    }
    @PostMapping("/register/client")
    public String registerClient(@RequestBody ClientTemp clientTemp){
        return this.iAuthenticationService.registerClient(clientTemp.getEmail(),clientTemp.getPassword(),
                clientTemp.getName(),clientTemp.getSurname(), clientTemp.getPhoneNumber(), clientTemp.getIdRepairShop());
    }

}
