package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.repositories.CarRepository;
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

class CarServiceImplTest {
    @InjectMocks
    CarServiceImpl carServiceImpl;
    @Mock
    CarRepository carRepository;
    @Mock
    ClientRepository clientRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        carServiceImpl = new CarServiceImpl(carRepository, clientRepository);
    }

    @Test
    void postCar() {
        List<Client> clientList = new ArrayList<>();
        Client client = new Client();
        client.setIdClient(1L);
        clientList.add(client);
        when(clientRepository.findAll()).thenReturn(clientList);
        assertEquals("Car saved", carServiceImpl.postCar(1L,
                1234, "A", "model", "version",
                1234, 1234, 1234));
        assertEquals("Car save unsuccessful", carServiceImpl.postCar(2L,
                1234, "A", "model", "version",
                1234, 1234, 1234));
    }

    @Test
    void deleteCar() {
        assertEquals("Car deleted", carServiceImpl.deleteCar(1L));
    }

    @Test
    void getCurrentCarsByClient() {
        Client client = new Client();
        client.setIdClient(1L);
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car();
        car1.setClient(client);
        Car car2 = new Car();
        car2.setClient(client);
        carList.add(car1);
        carList.add(car2);
        when(carRepository.findAll()).thenReturn(carList);
        assertEquals(carList, carServiceImpl.getCurrentCarsByClient(1L));
    }

    @Test
    void putCar() {
        List<Client> clientList = new ArrayList<>();
        Client client = new Client();
        client.setIdClient(1L);
        clientList.add(client);
        when(clientRepository.findAll()).thenReturn(clientList);
        assertEquals("Car updated", carServiceImpl.putCar(1L,"A", "model", "version", 1234, 1234, 1234,1234,  1L));
        assertEquals("Car update unsuccessful", carServiceImpl.putCar(1L,"A", "model", "version", 1234, 1234, 1234,1234,  2L));
    }
}