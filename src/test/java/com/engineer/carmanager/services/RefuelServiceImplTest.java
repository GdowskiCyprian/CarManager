package com.engineer.carmanager.services;

import com.engineer.carmanager.models.*;
import com.engineer.carmanager.repositories.FuelTankRepository;
import com.engineer.carmanager.repositories.RefuelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RefuelServiceImplTest {
    @Mock
    RefuelRepository refuelRepository;
    @Mock
    FuelTankRepository fuelTankRepository;
    @InjectMocks
    RefuelServiceImpl refuelServiceImpl;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        refuelServiceImpl = new RefuelServiceImpl(refuelRepository, fuelTankRepository);
    }

    @Test
    void postRefuel() {
        Car car = new Car();
        car.setIdCar(1L);
        FuelTank fuelTank = new FuelTank();
        fuelTank.setTypeOfFuel(typeOfFuel.PETROL);
        fuelTank.setCar(car);
        List<FuelTank> fuelTankList = new ArrayList<>();
        fuelTankList.add(fuelTank);
        when(fuelTankRepository.findAll()).thenReturn(fuelTankList);
        assertEquals("Refuel saved", refuelServiceImpl.postRefuel(1L, typeOfFuel.PETROL, 12D, 12D));
    }

    @Test
    void deleteRefuel() {
        assertEquals("Refuel deleted", refuelServiceImpl.deleteRefuel(1L));
    }

    @Test
    void getCurrentRefuels() {
        RepairShop repairShop = new RepairShop();
        repairShop.setIdRepairShop(1L);
        Client client = new Client();
        client.setRepairShop(repairShop);
        Car car = new Car();
        car.setIdCar(1L);
        car.setClient(client);
        FuelTank fuelTank = new FuelTank();
        fuelTank.setTypeOfFuel(typeOfFuel.PETROL);
        fuelTank.setCar(car);
        Refuel refuel = new Refuel();
        refuel.setFuelTank(fuelTank);
        List<Refuel> refuelList = new ArrayList<>();
        refuelList.add(refuel);
        when(refuelRepository.findAll()).thenReturn(refuelList);
        assertEquals(refuelList, refuelServiceImpl.getCurrentRefuels(1L));
    }
}