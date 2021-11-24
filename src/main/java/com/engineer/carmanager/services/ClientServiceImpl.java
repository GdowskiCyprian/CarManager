package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ClientService")
public class ClientServiceImpl implements iClientService{

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClientById(Long id) {
        return (Client) clientRepository.getById(id);

    }

    @Override
    public void postClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
