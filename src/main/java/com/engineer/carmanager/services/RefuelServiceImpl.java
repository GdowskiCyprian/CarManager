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

    private final RefuelRepository refuelRepository;
    private final FuelTankRepository fuelTankRepository;

    public RefuelServiceImpl(RefuelRepository refuelRepository,
                             FuelTankRepository fuelTankRepository) {
        this.refuelRepository = refuelRepository;
        this.fuelTankRepository = fuelTankRepository;
    }

    @Override
    public String postRefuel(Long idCar, typeOfFuel typeOfFuel, double price, double volume) {
        String returnMessage = "Refuel saved";
        try{
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
                returnMessage = "Wrong fuel";
            }
        }
        catch (Exception e){
            returnMessage = "Refuel save unsuccessful";
        }
        return returnMessage;


    }

    @Override
    public String deleteRefuel(Long id) {
        String returnMessage = "Refuel deleted";
        try{
            refuelRepository.deleteById(id);
        }
        catch(Exception e){
            returnMessage = "Refuel delete unsuccessful";
        }
        return returnMessage;
    }

    @Override
    public List<Refuel> getCurrentRefuels(Long id) {
        return refuelRepository.findAll().stream().filter(
                Refuel -> Refuel.getFuelTank().getCar().getClient().getRepairShop().getIdRepairShop().equals(id)
        ).toList();
    }
}
