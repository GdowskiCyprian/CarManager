package com.engineer.carmanager.services;
import com.engineer.carmanager.models.Car;

import java.util.List;

public interface iCarService {
     void postCar(Long idClient, int yearOfManufacture, String manufacturer, String model, String version, int displacement, int power, int mileage);
     void deleteCar(Long id);
     List<Car> getCurrentCarsByClient(Long id);
     void putCar(Long idCar, String manufacturer, String model, String version, int power, int mileage, int displacement, int yearOfManufacture, Long idClient);
}

