package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Auth;
import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.repositories.AuthRepository;
import com.engineer.carmanager.repositories.ClientRepository;
import com.engineer.carmanager.repositories.RepairShopRepository;
import com.engineer.carmanager.security.PasswordConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AuthenticationServiceImplTest {
    @InjectMocks
    AuthenticationServiceImpl authenticationServiceImpl;
    @Mock
    ClientRepository clientRepository;
    @Mock
    RepairShopRepository repairShopRepository;
    @Mock
    AuthRepository authRepository;

    PasswordConfig passwordConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authenticationServiceImpl = new AuthenticationServiceImpl(clientRepository, repairShopRepository, authRepository, passwordConfig);
    }

    @Test
    void login() {
        List<RepairShop> list = new ArrayList<>();

        Auth auth = new Auth();
        auth.setAuthid(1L);
        auth.setMailAddress("REmail");

        RepairShop repairShop = new RepairShop();
        repairShop.setIdRepairShop(1L);
        repairShop.setAuth(auth);
        list.add(repairShop);

        List<Client> clientList = new ArrayList<>();

        Auth auth1 = new Auth();
        auth1.setAuthid(2L);
        auth1.setMailAddress("CEmail");

        Client client = new Client();
        client.setIdClient(1L);
        client.setAuth(auth1);
        clientList.add(client);
        when(repairShopRepository.findAll()).thenReturn(list);
        when(clientRepository.findAll()).thenReturn(clientList);
        assertEquals("CLIENT", authenticationServiceImpl.login("CEmail"));
        assertEquals("REPAIR_SHOP", authenticationServiceImpl.login("REmail"));
        assertEquals("Wrong email or Password", authenticationServiceImpl.login("something"));
    }

    @Test
    void registerClient() {
    }

    @Test
    void registerRepairShop() {
    }

    @Test
    void changePassword() {
    }
}