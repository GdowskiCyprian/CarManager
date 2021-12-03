package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Client;

import java.util.List;

public interface iClientService {
    public Client getClientById(Long id);
    public void postClient(Client client);
    public List<Client> getAllClient();
    public void deleteClient(Long id);
    public List<Client> getCurrentClients(Long id);
}
