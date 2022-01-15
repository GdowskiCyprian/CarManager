package com.engineer.carmanager.services;

import com.engineer.carmanager.models.typeOfFuel;


public interface iFuelTankService {
     String postFuelTank(Long idCar, typeOfFuel typeOfFuel, Double capacity);
}
