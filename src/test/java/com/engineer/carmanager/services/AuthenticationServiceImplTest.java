package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Auth;
import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.repositories.AuthRepository;
import com.engineer.carmanager.repositories.ClientRepository;
import com.engineer.carmanager.repositories.RepairShopRepository;
import com.engineer.carmanager.security.PasswordConfig;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
@EnableJpaAuditing
class AuthenticationServiceImplTest {

    AuthenticationServiceImpl authenticationServiceImpl;

    PasswordConfig passwordConfig;

    @MockBean
    AuthRepository authRepository;
    @MockBean
    RepairShopRepository repairShopRepository;
    @MockBean
    ClientRepository clientRepository;



    @BeforeAll
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        passwordConfig = new PasswordConfig();
        authenticationServiceImpl = new AuthenticationServiceImpl(clientRepository, repairShopRepository, authRepository, passwordConfig);

    }

    @Test
    void login() {
        Auth auth = new Auth("client@client.pl", passwordConfig.passwordEncoder().encode("ClientPassword"),"CLIENT" );
        authRepository.save(auth);
        RepairShop repairShop = new RepairShop();
        repairShopRepository.save(repairShop);
        Client client = new Client(123456789, "name", "surname",repairShop, auth );
        clientRepository.save(client);
        Assertions.assertEquals("CLIENT", authenticationServiceImpl.login("client@client.pl"));
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