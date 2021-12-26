package com.engineer.carmanager.services;

import com.engineer.carmanager.controllersHelpersModels.CarTemp;
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
    public Car getCarById(Long id) {
        return carRepository.getById(id);
    }

    @Override
    public void postCar(CarTemp carTemp) {
        Car car = new Car();
        Client client = clientRepository.findAll().stream().filter(
                Client -> Client.getIdClient().equals(carTemp.getIdClient())
        ).findFirst().get();
        car.setClient(client);
        car.setYearOfManufacture(carTemp.getYearOfManufacture());
        car.setManufacturer(carTemp.getManufacturer());
        car.setModel(carTemp.getModel());
        car.setVersion(carTemp.getVersion());
        car.setDisplacement(carTemp.getDisplacement());
        car.setPower(carTemp.getPower());
        car.setMileage(carTemp.getMileage());
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

    @Override
    public List<Car> getCurrentCarsByClient(Long id) {
        return carRepository.findAll().stream().filter(
                Car -> Car.getClient().getIdClient().equals(id)
        ).toList();
    }
}
