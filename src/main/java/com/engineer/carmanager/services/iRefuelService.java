package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Refuel;
import com.engineer.carmanager.models.typeOfFuel;

import java.util.List;

public interface iRefuelService {
     String postRefuel(Long idCar, typeOfFuel typeOfFuel, double price, double volume);
     String deleteRefuel(Long id);
     List<Refuel> getCurrentRefuels(Long id);
}
