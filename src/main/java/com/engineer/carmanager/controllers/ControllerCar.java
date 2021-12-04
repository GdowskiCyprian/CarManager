package com.engineer.carmanager.controllers;

import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.services.iCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/cars")
public class ControllerCar {

    @Autowired
    @Qualifier("CarService")
    iCarService iCarService;

    @GetMapping(value = "/carAll")
    public List<Car> getCars() {
        return iCarService.getAllCar();
    }

    @GetMapping(path = "/{carID}")
    public Car getCarById(@PathVariable("carID") Long id) {
        return iCarService.getCarById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/postCar")
    public void postCar(@RequestBody Car car){
        iCarService.postCar(car);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteCar/{id}")
    public void deleteCar(@PathVariable Long id){
        iCarService.deleteCar(id);
    }
    @GetMapping("/getcurrentcars/{id}")
    public List<Car> getCurrentCars(@PathVariable("id") Long id){
        return iCarService.getCurrentCars(id);
    }

}
