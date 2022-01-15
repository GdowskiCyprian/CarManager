package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Repair;

import java.time.LocalDate;
import java.util.List;

public interface iRepairService {
     String postRepair(String name,LocalDate date,String description,Long idCar);
     String deleteRepair(Long id);
     List<Repair> getRepairsByRepairShop(Long id);
     List<Repair> getRepairsByClient(Long id);
}
