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
        passwordConfig = new PasswordConfig();
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

        List<Auth> authList = new ArrayList<>();
        authList.add(auth);
        authList.add(auth1);
        when(repairShopRepository.findAll()).thenReturn(list);
        when(clientRepository.findAll()).thenReturn(clientList);
        when(authRepository.findAll()).thenReturn(authList);
        assertEquals("Client registration successful", authenticationServiceImpl.registerClient("email", "pass","name", "surname", 662211349, 1L));
        assertEquals("Email is already taken", authenticationServiceImpl.registerClient("CEmail", "pass","name", "surname", 662211349, 1L));
    }

    @Test
    void registerRepairShop() {
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

        List<Auth> authList = new ArrayList<>();
        authList.add(auth);
        authList.add(auth1);

        when(repairShopRepository.findAll()).thenReturn(list);
        when(clientRepository.findAll()).thenReturn(clientList);
        when(authRepository.findAll()).thenReturn(authList);
        assertEquals("Repair Shop registration successful", authenticationServiceImpl.registerRepairShop("email", "pass", "name", 123456789, 12345678));
        assertEquals("Email is already taken", authenticationServiceImpl.registerRepairShop("REmail", "pass", "name", 123456789, 12345678));

    }

    @Test
    void changePassword() {
        List<RepairShop> list = new ArrayList<>();

        Auth auth = new Auth();
        auth.setAuthid(1L);
        auth.setMailAddress("REmail");
        auth.setPassword(passwordConfig.passwordEncoder().encode("pass"));

        RepairShop repairShop = new RepairShop();
        repairShop.setIdRepairShop(1L);
        repairShop.setAuth(auth);
        list.add(repairShop);

        List<Client> clientList = new ArrayList<>();

        Auth auth1 = new Auth();
        auth1.setAuthid(2L);
        auth1.setMailAddress("CEmail");
        auth1.setPassword(passwordConfig.passwordEncoder().encode("pass"));

        Client client = new Client();
        client.setIdClient(1L);
        client.setAuth(auth1);
        clientList.add(client);

        List<Auth> authList = new ArrayList<>();
        authList.add(auth);
        authList.add(auth1);
        when(repairShopRepository.findAll()).thenReturn(list);
        when(clientRepository.findAll()).thenReturn(clientList);
        when(authRepository.findAll()).thenReturn(authList);
        assertEquals("Password changed successfully", authenticationServiceImpl.changePassword("REmail", "pass", "pass1"));
        assertEquals("Password changed successfully", authenticationServiceImpl.changePassword("CEmail", "pass", "pass1"));
        assertEquals("Please check your credentials", authenticationServiceImpl.changePassword("REmail", "notapass", "pass1"));
        assertEquals("there was some error, check your credentials and try again", authenticationServiceImpl.changePassword("notaemail", "pass", "pass1"));
    }
}