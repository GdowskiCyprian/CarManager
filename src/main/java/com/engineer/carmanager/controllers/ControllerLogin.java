package com.engineer.carmanager.controllers;

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
    @PostMapping("/register/register")
    public void registerCommunicate(@RequestParam String mail, @RequestParam String password, @RequestParam String role, @RequestParam Long idRepairShop){


    }

}
