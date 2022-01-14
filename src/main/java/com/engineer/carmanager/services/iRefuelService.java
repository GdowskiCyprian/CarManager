package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Refuel;
import com.engineer.carmanager.models.typeOfFuel;

import java.util.List;

public interface iRefuelService {
     void postRefuel(Long idCar, typeOfFuel typeOfFuel, double price, double volume);
     void deleteRefuel(Long id);
     List<Refuel> getCurrentRefuels(Long id);
}
