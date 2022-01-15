package com.engineer.carmanager.services;
import com.engineer.carmanager.models.Car;

import java.util.List;

public interface iCarService {
     String postCar(Long idClient, int yearOfManufacture, String manufacturer, String model, String version, int displacement, int power, int mileage);
     String deleteCar(Long id);
     List<Car> getCurrentCarsByClient(Long id);
     String putCar(Long idCar, String manufacturer, String model, String version, int power, int mileage, int displacement, int yearOfManufacture, Long idClient);
}

