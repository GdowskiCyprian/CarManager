package com.engineer.carmanager.controllers;

import com.engineer.carmanager.services.iAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class ControllerLogin {

    @Autowired
    @Qualifier("AuthenticationService")
    private iAuthenticationService iAuthenticationService;
    @GetMapping("/login/{emailAddress}") //used
    public String loginCommunicate(@PathVariable("emailAddress") String email){
        return iAuthenticationService.login(email);
    }
    @PostMapping("/register/repairshop") //used
    public String registerRepairShop(@RequestBody Map<String, String> repairShopMap){
        return this.iAuthenticationService.registerRepairShop(repairShopMap.get("email"),
                repairShopMap.get("password"), repairShopMap.get("name"), Integer.parseInt(repairShopMap.get("phoneNumber")),
                Integer.parseInt(repairShopMap.get("nip")));
    }
    @PostMapping("/register/client") //used
    public String registerClient(@RequestBody Map<String, String> clientMap){
        return this.iAuthenticationService.registerClient(clientMap.get("email"),clientMap.get("password"),
                clientMap.get("name"),clientMap.get("surname"), Integer.parseInt(clientMap.get("phoneNumber")),
                Long.valueOf(clientMap.get("idRepairShop")));
    }

    @PostMapping("/changepassword") //used
    public String changePasswordClient(@RequestBody Map<String, String> body){
        System.out.println(body.get("email") + " " + body.get("oldPassword") + " " + body.get("newPassword"));
        return iAuthenticationService.changePassword(body.get("email"), body.get("oldPassword"), body.get("newPassword"));
    }
}
