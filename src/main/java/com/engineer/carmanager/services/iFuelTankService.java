package com.engineer.carmanager.services;

import com.engineer.carmanager.models.FuelTank;

import java.util.List;

public interface iFuelTankService {
    public FuelTank getFuelTankById(Long id);
    public void postFuelTank(FuelTank fuelTank);
    public List<FuelTank> getAllFuelTank();
    public void deleteFuelTank(Long id);
}