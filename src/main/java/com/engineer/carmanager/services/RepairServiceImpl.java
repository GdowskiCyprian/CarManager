package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.repositories.CarRepository;
import com.engineer.carmanager.repositories.RepairRepository;
import com.engineer.carmanager.repositories.RepairShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service("RepairService")
public class RepairServiceImpl implements iRepairService{

    private RepairRepository repairRepository;
    private CarRepository carRepository;

    public RepairServiceImpl(RepairRepository repairRepository, CarRepository carRepository) {
        this.repairRepository = repairRepository;
        this.carRepository = carRepository;
    }

    @Override
    public Repair getRepairById(Long id) {
        return repairRepository.getById(id);
    }

    @Override
    public String postRepair(String name,LocalDate date,String description,Long idCar) {
        Car car = carRepository.findAll().stream()
                .filter(Car -> Car.getIdCar().equals(idCar))
                .findFirst().orElse(null);
        Repair repair = new Repair();
        repair.setName(name);
        repair.setDate(date);
        repair.setDescription(description);
        repair.setCar(car);
        repairRepository.save(repair);
        return "Added new repair of name: " + name;
    }

    @Override
    public List<Repair> getAllRepair() {
        return repairRepository.findAll();
    }

    @Override
    public void deleteRepair(Long id) {
        repairRepository.deleteById(id);
    }

    public List<Repair> getRepairsByRepairShop(Long id){
        return repairRepository.findAll().stream().filter(Repair -> Repair.getCar().getClient().getRepairShop().getIdRepairShop().equals(id)).toList();
    }

    @Override
    public List<Repair> getRepairsByClient(Long id) {
        return repairRepository.findAll().stream().filter(
                Repair -> Repair.getCar().getClient().getIdClient().equals(id)
        ).toList();
    }
}
