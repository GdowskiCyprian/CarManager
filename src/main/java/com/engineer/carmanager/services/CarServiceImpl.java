package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CarService")
public class CarServiceImpl implements iCarService{

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.getById(id);
    }

    @Override
    public void postCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> getAllCar() {

        return carRepository.findAll();
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> getCurrentCars(Long id) {
        return carRepository.findAll().stream().filter(
                Car -> Car.getClient().getRepairShop().getIdRepairShop().equals(id)
        ).toList();
    }
}
