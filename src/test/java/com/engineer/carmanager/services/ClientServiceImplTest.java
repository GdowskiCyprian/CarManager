package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Auth;
import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.repositories.AuthRepository;
import com.engineer.carmanager.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClientServiceImplTest {
    @Mock
    ClientRepository clientRepository;
    @Mock
    AuthRepository authRepository;
    @InjectMocks
    ClientServiceImpl clientServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clientServiceImpl = new ClientServiceImpl(clientRepository, authRepository);
    }

    @Test
    void getCurrentClients() {
        List<Client> clientList = new ArrayList<>();
        Client client = new Client();
        RepairShop repairShop = new RepairShop();
        repairShop.setIdRepairShop(1L);
        client.setRepairShop(repairShop);
        clientList.add(client);
        when(clientRepository.findAll()).thenReturn(clientList);
        assertEquals(clientList, clientServiceImpl.getCurrentClients(1L));
    }

    @Test
    void getClientbyMail() {
        List<Client> clientList = new ArrayList<>();
        Client client = new Client();
        Auth auth = new Auth();
        auth.setMailAddress("email");
        client.setAuth(auth);
        clientList.add(client);
        when(clientRepository.findAll()).thenReturn(clientList);
        assertEquals(client, clientServiceImpl.getClientbyMail("email"));
    }

    @Test
    void deleteClient() {

        Client client = new Client();
        Auth auth = new Auth();
        auth.setMailAddress("email");
        client.setAuth(auth);
        when(clientRepository.getById(1L)).thenReturn(client);
        assertEquals("Client deleted", clientServiceImpl.deleteClient(1L));
    }
}