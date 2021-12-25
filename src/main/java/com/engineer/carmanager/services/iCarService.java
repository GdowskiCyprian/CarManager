package com.engineer.carmanager.services;

import com.engineer.carmanager.controllersHelpersModels.CarTemp;
import com.engineer.carmanager.models.Car;

import java.util.List;

public interface iCarService {
    public Car getCarById(Long id);
    public void postCar(CarTemp carTemp);
    public List<Car> getAllCar();
    public void deleteCar(Long id);
    public List<Car> getCurrentCars(Long id);
}
