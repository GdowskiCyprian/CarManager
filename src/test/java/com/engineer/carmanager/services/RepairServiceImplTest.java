package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.repositories.CarRepository;
import com.engineer.carmanager.repositories.RepairRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RepairServiceImplTest {
    @Mock
    RepairRepository repairRepository;
    @Mock
    CarRepository carRepository;
    @InjectMocks
    RepairServiceImpl repairServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        repairServiceImpl = new RepairServiceImpl(repairRepository, carRepository);
    }

    @Test
    void postRepair() {
        Car car = new Car();
        car.setIdCar(1L);
        when(carRepository.getById(1L)).thenReturn(car);
        assertEquals("Repair saved", repairServiceImpl.postRepair("name", LocalDate.now(), "desc", 1L));
    }

    @Test
    void deleteRepair() {
        assertEquals("Repair deleted", repairServiceImpl.deleteRepair(1L));
    }

    @Test
    void getRepairsByRepairShop() {
        RepairShop repairShop = new RepairShop();
        repairShop.setIdRepairShop(1L);
        Client client = new Client();
        client.setRepairShop(repairShop);
        Car car = new Car();
        car.setClient(client);
        Repair repair1 = new Repair();
        Repair repair2 = new Repair();
        repair1.setCar(car);
        repair2.setCar(car);
        List<Repair> repairList = new ArrayList<>();
        repairList.add(repair1);
        repairList.add(repair2);
        when(repairRepository.findAll()).thenReturn(repairList);
        assertEquals(repairList, repairServiceImpl.getRepairsByRepairShop(1L));
    }

    @Test
    void getRepairsByClient() {
        Client client = new Client();
        client.setIdClient(1L);
        Car car = new Car();
        car.setClient(client);
        Repair repair1 = new Repair();
        Repair repair2 = new Repair();
        repair1.setCar(car);
        repair2.setCar(car);
        List<Repair> repairList = new ArrayList<>();
        repairList.add(repair1);
        repairList.add(repair2);
        when(repairRepository.findAll()).thenReturn(repairList);
        assertEquals(repairList, repairServiceImpl.getRepairsByClient(1L));
    }
}