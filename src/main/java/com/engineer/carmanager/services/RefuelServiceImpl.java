package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Refuel;
import com.engineer.carmanager.repositories.RefuelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("RefuelService")
public class RefuelServiceImpl implements iRefuelService{

    private RefuelRepository refuelRepository;

    public RefuelServiceImpl(RefuelRepository refuelRepository) {
        this.refuelRepository = refuelRepository;
    }

    @Override
    public Refuel getRefuelById(Long id) {
        return refuelRepository.getById(id);
    }

    @Override
    public void postRefuel(Refuel refuel) {
        refuelRepository.save(refuel);
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
