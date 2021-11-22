package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.services.iClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ControllerClient {
    @Autowired
    @Qualifier("ClientService")
    iClientService iClientService;

    @GetMapping(value = "/clientAll")
    public List<Client> getClients() {
        return iClientService.getAllClient();
    }

    @GetMapping(path = "/{clientID}")
    public Client getClientById(@PathVariable("clientID") Long id) {
        return iClientService.getClientById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/postClient")
    public void postClient(@RequestBody Client client){
        iClientService.postClient(client);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id){
        iClientService.deleteClient(id);
    }

}
