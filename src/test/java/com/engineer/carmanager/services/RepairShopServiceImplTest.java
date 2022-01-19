package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Auth;
import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.repositories.AuthRepository;
import com.engineer.carmanager.repositories.RepairShopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RepairShopServiceImplTest {
    @InjectMocks
    RepairShopServiceImpl repairShopServiceImpl;

    @Mock
    RepairShopRepository repairShopRepository;

    @Mock
    AuthRepository authRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        repairShopServiceImpl = new RepairShopServiceImpl(repairShopRepository, authRepository);
    }

    @Test
    void getAllRepairShop() {
        List<RepairShop> list = new ArrayList<>();
        RepairShop repairShop = new RepairShop();
        repairShop.setIdRepairShop(1L);
        list.add(repairShop);
        when(repairShopRepository.findAll()).thenReturn(list);
        assertEquals(1, repairShopServiceImpl.getAllRepairShop().toArray().length);
        assertEquals(list, repairShopServiceImpl.getAllRepairShop());


    }

    @Test
    void getRepairShopByMailAddress() {
        List<RepairShop> list = new ArrayList<>();
        Auth auth = new Auth();
        auth.setAuthid(1L);
        auth.setMailAddress("email");
        RepairShop repairShop = new RepairShop();
        repairShop.setIdRepairShop(1L);
        repairShop.setAuth(auth);
        list.add(repairShop);
        when(repairShopRepository.findAll()).thenReturn(list);
        assertEquals(repairShop, repairShopServiceImpl.getRepairShopByMailAddress("email"));
    }

    @Test
    void deleteRepairShop() {
        Auth auth = new Auth();
        auth.setAuthid(1L);
        auth.setMailAddress("email");
        RepairShop repairShop = new RepairShop();
        repairShop.setIdRepairShop(1L);
        repairShop.setAuth(auth);
        when(repairShopRepository.getById(repairShop.getIdRepairShop())).thenReturn(repairShop);
        assertEquals("Repair shop deleted", repairShopServiceImpl.deleteRepairShop(1L));
        assertEquals("Repair shop delete unsuccessful", repairShopServiceImpl.deleteRepairShop(2L));
    }
}