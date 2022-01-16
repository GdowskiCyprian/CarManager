package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.services.iClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/clients")
public class ControllerClient {
    @Autowired
    @Qualifier("ClientService")
    iClientService iClientService;

    @GetMapping("/getcurrentclients/{id}") //used
    public List<Client> getCurrentClients(@PathVariable("id") Long id){
        return iClientService.getCurrentClients(id);
    }

    @GetMapping("/getbymail/{email}") //used
    public Client getByMail(@PathVariable("email") String email){
        return iClientService.getClientbyMail(email);
    }

    @DeleteMapping("/deleteClient/{id}") //used
    public String deleteClient(@PathVariable("id") Long id) {return iClientService.deleteClient(id);}
}
