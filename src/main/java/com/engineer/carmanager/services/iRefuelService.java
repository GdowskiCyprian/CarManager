package com.engineer.carmanager.services;

import com.engineer.carmanager.controllersHelpersModels.RefuelTemp;
import com.engineer.carmanager.models.Refuel;

import java.util.List;

public interface iRefuelService {
    public Refuel getRefuelById(Long id);
    public void postRefuel(RefuelTemp refuel);
    public List<Refuel> getAllRefuel();
    public void deleteRefuel(Long id);
    public List<Refuel> getCurrentRefuels(Long id);
}
