package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ClientService")
public class ClientServiceImpl implements iClientService{

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getCurrentClients(Long id) {
        return clientRepository.findAll().stream().filter(
                Client -> Client.getRepairShop().getIdRepairShop().equals(id)
        ).toList();
    }

    @Override
    public Client getClientbyMail(String email) {
        return clientRepository.findAll().stream().filter(
                Client -> Client.getAuth().getMailAddress().equals(email)
        ).findAny().get();
    }
}
