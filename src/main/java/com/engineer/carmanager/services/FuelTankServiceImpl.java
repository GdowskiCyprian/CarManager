package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.models.FuelTank;
import com.engineer.carmanager.models.typeOfFuel;
import com.engineer.carmanager.repositories.CarRepository;
import com.engineer.carmanager.repositories.FuelTankRepository;
import org.springframework.stereotype.Service;

@Service("FuelTankService")
public class FuelTankServiceImpl implements iFuelTankService{
    private FuelTankRepository fuelTankRepository;
    private CarRepository carRepository;

    public FuelTankServiceImpl(FuelTankRepository fuelTankRepository, CarRepository carRepository) {
        this.fuelTankRepository = fuelTankRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void postFuelTank(Long idCar, typeOfFuel typeOfFuel, Double capacity) {
        FuelTank fuelTank = new FuelTank();
        Car car = carRepository.findAll().stream().filter(
                Car -> Car.getIdCar().equals(idCar)
        ).findFirst().get();
        fuelTank.setTypeOfFuel(typeOfFuel);
        fuelTank.setCapacity(capacity);
        fuelTank.setCar(car);
        fuelTankRepository.save(fuelTank);
    }
}
