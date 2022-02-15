package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.repositories.CarRepository;
import com.engineer.carmanager.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CarService")
public class CarServiceImpl implements iCarService{

    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    public CarServiceImpl(CarRepository carRepository, ClientRepository clientRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public String postCar(Long idClient, int yearOfManufacture, String manufacturer,
                          String model, String version, int displacement, int power,
                          int mileage) {
        String returnMessage = "Car saved";
        try{
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
        catch(Exception e){
            returnMessage = "Car save unsuccessful";
        }
        return returnMessage;
    }

    @Override
    public String deleteCar(Long id) {
        String returnMessage = "Car deleted";
        try{
            carRepository.deleteById(id);
        }
        catch(Exception e){
            returnMessage = "Car delete unsuccessful";
        }
        return returnMessage;

    }

    @Override
    public List<Car> getCurrentCarsByClient(Long id) {
        return carRepository.findAll().stream().filter(
                Car -> Car.getClient().getIdClient().equals(id)
        ).toList();
    }

    @Override
    public String putCar(Long idCar, String manufacturer, String model, String version,
                         int power, int mileage, int displacement, int yearOfManufacture,
                         Long idClient) {
        String returnMessage = "Car updated";
        try {
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
        catch(Exception e){
            returnMessage = "Car update unsuccessful";
        }
        return returnMessage;

    }

}
