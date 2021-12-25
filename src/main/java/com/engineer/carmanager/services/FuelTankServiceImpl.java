package com.engineer.carmanager.services;

import com.engineer.carmanager.controllersHelpersModels.FuelTankTemp;
import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.models.FuelTank;
import com.engineer.carmanager.repositories.CarRepository;
import com.engineer.carmanager.repositories.FuelTankRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("FuelTankService")
public class FuelTankServiceImpl implements iFuelTankService{
    private FuelTankRepository fuelTankRepository;
    private CarRepository carRepository;

    public FuelTankServiceImpl(FuelTankRepository fuelTankRepository, CarRepository carRepository) {
        this.fuelTankRepository = fuelTankRepository;
        this.carRepository = carRepository;
    }

    @Override
    public FuelTank getFuelTankById(Long id) {
        return fuelTankRepository.getById(id);
    }

    @Override
    public void postFuelTank(FuelTankTemp fuelTankTemp) {
        FuelTank fuelTank = new FuelTank();
        Car car = carRepository.findAll().stream().filter(
                Car -> Car.getIdCar().equals(fuelTankTemp.getIdCar())
        ).findFirst().get();
        fuelTank.setTypeOfFuel(fuelTankTemp.getTypeOfFuel());
        fuelTank.setCapacity(fuelTankTemp.getCapacity());
        fuelTank.setCar(car);
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
