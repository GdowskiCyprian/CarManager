package com.engineer.carmanager.services;

import com.engineer.carmanager.models.typeOfFuel;


public interface iFuelTankService {
     void postFuelTank(Long idCar, typeOfFuel typeOfFuel, Double capacity);
}
