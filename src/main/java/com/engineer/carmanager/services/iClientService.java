package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Client;

import java.util.List;

public interface iClientService {
     List<Client> getCurrentClients(Long id);
     Client getClientbyMail(String email);
}
