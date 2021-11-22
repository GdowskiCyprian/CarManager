package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Refuel;

import java.util.List;

public interface iRefuelService {
    public Refuel getRefuelById(Long id);
    public void postRefuel(Refuel refuel);
    public List<Refuel> getAllRefuel();
    public void deleteRefuel(Long id);
}
