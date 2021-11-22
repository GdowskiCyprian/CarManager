package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Car;

import java.util.List;

public interface iCarService {
    public Car getCarById(Long id);
    public void postCar(Car car);
    public List<Car> getAllCar();
    public void deleteCar(Long id);
}
