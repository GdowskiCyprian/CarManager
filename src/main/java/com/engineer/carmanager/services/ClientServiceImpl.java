package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Auth;
import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.repositories.AuthRepository;
import com.engineer.carmanager.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("ClientService")
public class ClientServiceImpl implements iClientService{

    private final ClientRepository clientRepository;
    private final AuthRepository authRepository;

    public ClientServiceImpl(ClientRepository clientRepository, AuthRepository authRepository) {
        this.clientRepository = clientRepository;
        this.authRepository = authRepository;
    }

    @Override
    public List<Client> getCurrentClients(Long id) {
        return clientRepository.findAll().stream().filter(
                Client -> Client.getRepairShop().getIdRepairShop().equals(id)
        ).collect(Collectors.toList());
    }

    @Override
    public Client getClientbyMail(String email) {
        return clientRepository.findAll().stream().filter(
                Client -> Client.getAuth().getMailAddress().equals(email)
        ).findAny().get();
    }

    @Override
    public String deleteClient(Long id) {
        String returnMessage = "Client deleted";
        try{
            Auth auth = clientRepository.getById(id).getAuth();
            clientRepository.deleteById(id);
            authRepository.deleteById(auth.getAuthid());
        }
        catch(Exception e){
            returnMessage = "Client delete unsuccessful";
        }
        return returnMessage;
    }
}
