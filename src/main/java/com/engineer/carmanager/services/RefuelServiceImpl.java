package com.engineer.carmanager.services;

import com.engineer.carmanager.controllersHelpersModels.RefuelTemp;
import com.engineer.carmanager.models.FuelTank;
import com.engineer.carmanager.models.Refuel;
import com.engineer.carmanager.repositories.CarRepository;
import com.engineer.carmanager.repositories.FuelTankRepository;
import com.engineer.carmanager.repositories.RefuelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("RefuelService")
public class RefuelServiceImpl implements iRefuelService{

    private RefuelRepository refuelRepository;
    private FuelTankRepository fuelTankRepository;

    public RefuelServiceImpl(RefuelRepository refuelRepository,
                             FuelTankRepository fuelTankRepository) {
        this.refuelRepository = refuelRepository;
        this.fuelTankRepository = fuelTankRepository;
    }

    @Override
    public Refuel getRefuelById(Long id) {
        return refuelRepository.getById(id);
    }

    @Override
    public void postRefuel(RefuelTemp refuelTemp) {
        Refuel refuel = new Refuel();
        FuelTank fuelTank = fuelTankRepository.findAll().stream().filter(
                FuelTank -> FuelTank.getCar().getIdCar().equals(refuelTemp.getIdCar())
        ).findFirst().get();
        refuel.setTypeOfFuel(refuelTemp.getTypeOfFuel());
        refuel.setPrice(refuelTemp.getPrice());
        refuel.setVolume(refuelTemp.getVolume());
        refuel.setFuelTank(fuelTank);
        if(refuel.getTypeOfFuel().equals(fuelTank.getTypeOfFuel())){
            refuelRepository.save(refuel);
        }
        else{
            System.out.println("wrong fuel");
        }

    }

    @Override
    public List<Refuel> getAllRefuel() {
        return refuelRepository.findAll();
    }

    @Override
    public void deleteRefuel(Long id) {
        refuelRepository.deleteById(id);
    }

    @Override
    public List<Refuel> getCurrentRefuels(Long id) {
        return refuelRepository.findAll().stream().filter(
                Refuel -> Refuel.getFuelTank().getCar().getClient().getRepairShop().getIdRepairShop().equals(id)
        ).toList();
    }
}
