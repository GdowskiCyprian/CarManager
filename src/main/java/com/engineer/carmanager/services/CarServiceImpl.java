package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.repositories.CarRepository;
import com.engineer.carmanager.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CarService")
public class CarServiceImpl implements iCarService{

    private CarRepository carRepository;
    private ClientRepository clientRepository;

    public CarServiceImpl(CarRepository carRepository, ClientRepository clientRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void postCar(Long idClient, int yearOfManufacture, String manufacturer, String model, String version, int displacement, int power, int mileage) {
        Car car = new Car();
        Client client = clientRepository.findAll().stream().filter(
                Client -> Client.getIdClient().equals(idClient)
        ).findFirst().get();
        car.setClient(client);
        car.setYearOfManufacture(yearOfManufacture);
        car.setManufacturer(manufacturer);
        car.setModel(model);
        car.setVersion(version);
        car.setDisplacement(displacement);
        car.setPower(power);
        car.setMileage(mileage);
        carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> getCurrentCarsByClient(Long id) {
        return carRepository.findAll().stream().filter(
                Car -> Car.getClient().getIdClient().equals(id)
        ).toList();
    }

    @Override
    public void putCar(Long idCar, String manufacturer, String model, String version, int power, int mileage, int displacement, int yearOfManufacture, Long idClient) {
        Client client = clientRepository.findAll().stream().filter(
                Client -> Client.getIdClient().equals(idClient)
        ).findFirst().get();
        Car car = new Car();
        car.setIdCar(idCar);
        car.setManufacturer(manufacturer);
        car.setModel(model);
        car.setVersion(version);
        car.setPower(power);
        car.setMileage(mileage);
        car.setDisplacement(displacement);
        car.setYearOfManufacture(yearOfManufacture);
        car.setClient(client);
        carRepository.save(car);
    }

}
