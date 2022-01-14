package com.engineer.carmanager.services;

import com.engineer.carmanager.models.FuelTank;
import com.engineer.carmanager.models.Refuel;
import com.engineer.carmanager.models.typeOfFuel;
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
    public void postRefuel(Long idCar, typeOfFuel typeOfFuel, double price, double volume) {
        Refuel refuel = new Refuel();
        FuelTank fuelTank = fuelTankRepository.findAll().stream().filter(
                FuelTank -> FuelTank.getCar().getIdCar().equals(idCar)
        ).findFirst().get();
        refuel.setTypeOfFuel(typeOfFuel);
        refuel.setPrice(price);
        refuel.setVolume(volume);
        refuel.setFuelTank(fuelTank);
        if(refuel.getTypeOfFuel().equals(fuelTank.getTypeOfFuel())){
            refuelRepository.save(refuel);
        }
        else{
            System.out.println("wrong fuel");
        }

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
