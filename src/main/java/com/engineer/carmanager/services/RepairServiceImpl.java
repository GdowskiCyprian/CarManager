package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Car;
import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.repositories.CarRepository;
import com.engineer.carmanager.repositories.RepairRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service("RepairService")
public class RepairServiceImpl implements iRepairService{

    private final RepairRepository repairRepository;
    private final CarRepository carRepository;

    public RepairServiceImpl(RepairRepository repairRepository, CarRepository carRepository) {
        this.repairRepository = repairRepository;
        this.carRepository = carRepository;
    }

    @Override
    public String postRepair(String name,LocalDate date,String description,Long idCar) {
        String returnMessage = "Repair saved";
        try{
            Car car = carRepository.getById(idCar);
            Repair repair = new Repair();
            repair.setName(name);
            repair.setDate(date);
            repair.setDescription(description);
            repair.setCar(car);
            repairRepository.save(repair);
        }
        catch(Exception e){
            returnMessage = "Repair save unsuccessful";
        }
        return returnMessage;
    }

    @Override
    public String deleteRepair(Long id) {
        String returnMessage = "Repair deleted";
        try{
            repairRepository.deleteById(id);
        }
        catch(Exception e){
            returnMessage = "Repair delete unsuccessful";
        }
        return returnMessage;
    }

    public List<Repair> getRepairsByRepairShop(Long id){
        return repairRepository.findAll().stream().filter(Repair -> Repair.getCar().getClient()
                .getRepairShop().getIdRepairShop().equals(id)).collect(Collectors.toList());
    }

    @Override
    public List<Repair> getRepairsByClient(Long id) {
        return repairRepository.findAll().stream().filter(
                Repair -> Repair.getCar().getClient().getIdClient().equals(id)
        ).collect(Collectors.toList());
    }
}
