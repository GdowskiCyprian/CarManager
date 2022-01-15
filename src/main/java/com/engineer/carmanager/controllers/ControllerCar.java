package com.engineer.carmanager.controllers;
import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.services.iCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/cars")
public class ControllerCar {

    @Autowired
    @Qualifier("CarService")
    iCarService iCarService;

    @RequestMapping(method = RequestMethod.POST, value = "/postCar") //used
    public String postCar(@RequestBody Map<String, String> carMap){
        return iCarService.postCar(
                Long.valueOf(carMap.get("idClient")),
                Integer.parseInt(carMap.get("yearOfManufacture")),
                carMap.get("manufacturer"),
                carMap.get("model"),
                carMap.get("version"),
                Integer.parseInt(carMap.get("displacement")),
                Integer.parseInt(carMap.get("power")),
                Integer.parseInt(carMap.get("mileage"))
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteCar/{id}") //used
    public String deleteCar(@PathVariable Long id){
        return iCarService.deleteCar(id);
    }

    @GetMapping("/getcurrentcarsbyclient/{id}") //used
    public List<Car> getCurrentCarsByClient(@PathVariable("id") Long id){
        return iCarService.getCurrentCarsByClient(id);
    }
    @PutMapping("/putcar") //used
    public String putCar(@RequestBody Map<String, String> car){
        return iCarService.putCar(
                Long.valueOf(car.get("idCar")),
                car.get("manufacturer"),
                car.get("model"),
                car.get("version"),
                Integer.parseInt(car.get("power")),
                Integer.parseInt(car.get("mileage")),
                Integer.parseInt(car.get("displacement")),
                Integer.parseInt(car.get("yearOfManufacture")),
                Long.valueOf(car.get("idClient"))
        );
    }

}
