package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Repair;

import java.util.List;

public interface iRepairService {
    public Repair getRepairById(Long id);
    public void postRepair(Repair repair);
    public List<Repair> getAllRepair();
    public void deleteRepair(Long id);
}
