package com.engineer.carmanager.services;

import com.engineer.carmanager.models.RepairPart;

import java.util.List;

public interface iRepairPartService {
    public RepairPart getRepairPartById(Long id);
    public void postRepairPart(RepairPart repairPart);
    public List<RepairPart> getAllRepairPart();
    public void deleteRepairPart(Long id);
}
