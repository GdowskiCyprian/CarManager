package com.engineer.carmanager.services;

import com.engineer.carmanager.models.FuelTank;
import com.engineer.carmanager.repositories.FuelTankRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("FuelTankService")
public class FuelTankServiceImpl implements iFuelTankService{
    private FuelTankRepository fuelTankRepository;

    public FuelTankServiceImpl(FuelTankRepository fuelTankRepository) {
        this.fuelTankRepository = fuelTankRepository;
    }

    @Override
    public FuelTank getFuelTankById(Long id) {
        return fuelTankRepository.getById(id);
    }

    @Override
    public void postFuelTank(FuelTank fuelTank) {
        fuelTankRepository.save(fuelTank);
    }

    @Override
    public List<FuelTank> getAllFuelTank() {
        return fuelTankRepository.findAll();
    }

    @Override
    public void deleteFuelTank(Long id) {
        fuelTankRepository.deleteById(id);
    }
}
