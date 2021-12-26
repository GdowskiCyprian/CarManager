package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Repair;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface iRepairService {
    public Repair getRepairById(Long id);
    public void postRepair(String name,LocalDate date,String description,Long idCar);
    public List<Repair> getAllRepair();
    public void deleteRepair(Long id);
    public List<Repair> getRepairsByRepairShop(Long id);
    public List<Repair> getRepairsByClient(Long id);
}
