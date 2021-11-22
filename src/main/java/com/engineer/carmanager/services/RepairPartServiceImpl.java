package com.engineer.carmanager.services;

import com.engineer.carmanager.models.RepairPart;
import com.engineer.carmanager.repositories.RepairPartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("RepairPartService")
public class RepairPartServiceImpl implements iRepairPartService{

    private RepairPartRepository repairPartRepository;

    public RepairPartServiceImpl(RepairPartRepository repairPartRepository) {
        this.repairPartRepository = repairPartRepository;
    }

    @Override
    public RepairPart getRepairPartById(Long id) {
        return repairPartRepository.getById(id);
    }

    @Override
    public void postRepairPart(RepairPart repairPart) {
        repairPartRepository.save(repairPart);
    }

    @Override
    public List<RepairPart> getAllRepairPart() {
        return repairPartRepository.findAll();
    }

    @Override
    public void deleteRepairPart(Long id) {
        repairPartRepository.deleteById(id);
    }
}
