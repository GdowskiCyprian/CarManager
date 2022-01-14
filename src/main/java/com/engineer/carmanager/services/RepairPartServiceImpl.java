package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.models.RepairPart;
import com.engineer.carmanager.repositories.RepairPartRepository;
import com.engineer.carmanager.repositories.RepairRepository;
import org.springframework.stereotype.Service;

@Service("RepairPartService")
public class RepairPartServiceImpl implements iRepairPartService{

    private RepairPartRepository repairPartRepository;
    private RepairRepository repairRepository;

    public RepairPartServiceImpl(RepairPartRepository repairPartRepository, RepairRepository repairRepository) {
        this.repairPartRepository = repairPartRepository;
        this.repairRepository = repairRepository;
    }

    @Override
    public void postRepairPart(String partname, String partdescription, Double price, Long idRepair) {
        RepairPart repairPart = new RepairPart();
        repairPart.setName(partname);
        repairPart.setDescription(partdescription);
        repairPart.setPrice(price);
        Repair repair = repairRepository.findAll().stream()
                .filter(Repair -> Repair.getIdRepair().equals(idRepair))
                .findFirst().orElse(null);
        repairPart.setRepair(repair);
        repairPartRepository.save(repairPart);
    }

    @Override
    public void deleteRepairPart(Long id) {
        repairPartRepository.deleteById(id);
    }
}
