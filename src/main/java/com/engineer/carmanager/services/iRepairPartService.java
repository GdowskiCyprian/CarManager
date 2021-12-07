package com.engineer.carmanager.services;

import com.engineer.carmanager.models.RepairPart;
import com.engineer.carmanager.models.RepairPartTemp;

import java.io.IOException;
import java.util.List;

public interface iRepairPartService {
    public RepairPart getRepairPartById(Long id);
    public void postRepairPart(RepairPartTemp repairPartTemp) throws IOException;
    public List<RepairPart> getAllRepairPart();
    public void deleteRepairPart(Long id);
}
