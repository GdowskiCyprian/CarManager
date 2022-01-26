package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.models.typeOfFuel;
import com.engineer.carmanager.repositories.CarRepository;
import com.engineer.carmanager.repositories.FuelTankRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FuelTankServiceImplTest {
    @InjectMocks
    FuelTankServiceImpl fuelTankServiceImpl;
    @Mock
    FuelTankRepository fuelTankRepository;
    @Mock
    CarRepository carRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        fuelTankServiceImpl = new FuelTankServiceImpl(fuelTankRepository, carRepository);
    }

    @Test
    void postFuelTank() {
        Car car = new Car();
        List<Car> carList = new ArrayList<>();
        car.setIdCar(1L);
        carList.add(car);
        when(carRepository.findAll()).thenReturn(carList);
        assertEquals("Fuel Tank saved", fuelTankServiceImpl.postFuelTank(1L, typeOfFuel.PETROL, 60D));
        assertEquals("Fuel tank save unsuccessful" , fuelTankServiceImpl.postFuelTank(2L, typeOfFuel.PETROL, 60D));
    }
}