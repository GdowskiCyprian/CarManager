package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.Auth;
import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.models.RepairShop;
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
    @Qualifier("RepairShopService")
    iRepairShopService iRepairShopService;
    @Qualifier("ClientService")
    iClientService iClientService;
    //dodac auth service
    @GetMapping("/login/{emailAddress}")
    public String loginCommunicate(@PathVariable("emailAddress") String mailAddress){
        if(iRepairShopService.getAllRepairShop().stream().anyMatch(RepairShop -> RepairShop.getAuth().getMailAddress().equals(mailAddress))){
            return "REPAIR_SHOP";
        }
        else if(iClientService.getAllClient().stream().anyMatch(Client -> Client.getAuth().getMailAddress().equals(mailAddress)))
        {
            return "CLIENT";
        }
        else{
            return "error";
        }
    }
    @PostMapping("/register/register")
    public String registerCommunicate(@RequestParam String mail, @RequestParam String password, @RequestParam String role ){
        //role bedzie wybierany
        if(Objects.equals(role, "CLIENT")){
            Client client = new Client();
            Auth auth = new Auth();
            auth.setMailAddress(mail);
            auth.setPassword(password);
            auth.setRole(role);
            client.setName("defaultname");
            client.setPhoneNumber(123456789);
            client.setSurname("defaultsurname");
            client.setAuth(auth);
            //dokonczyc ta funckcje
        }
        return "";
    }

}
