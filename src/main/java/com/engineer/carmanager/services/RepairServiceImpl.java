package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.repositories.RepairRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("RepairService")
public class RepairServiceImpl implements iRepairService{

    private RepairRepository repairRepository;

    public RepairServiceImpl(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    @Override
    public Repair getRepairById(Long id) {
        return repairRepository.getById(id);
    }

    @Override
    public void postRepair(Repair repair) {
        repairRepository.save(repair);
    }

    @Override
    public List<Repair> getAllRepair() {
        return repairRepository.findAll();
    }

    @Override
    public void deleteRepair(Long id) {
        repairRepository.deleteById(id);
    }
}
