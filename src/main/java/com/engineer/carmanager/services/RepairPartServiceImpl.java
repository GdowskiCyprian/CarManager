package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.models.RepairPart;
import com.engineer.carmanager.controllersHelpersModels.RepairPartTemp;
import com.engineer.carmanager.repositories.RepairPartRepository;
import com.engineer.carmanager.repositories.RepairRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("RepairPartService")
public class RepairPartServiceImpl implements iRepairPartService{

    private RepairPartRepository repairPartRepository;
    private RepairRepository repairRepository;

    public RepairPartServiceImpl(RepairPartRepository repairPartRepository, RepairRepository repairRepository) {
        this.repairPartRepository = repairPartRepository;
        this.repairRepository = repairRepository;
    }

    @Override
    public RepairPart getRepairPartById(Long id) {
        return repairPartRepository.getById(id);
    }

    @Override
    public void postRepairPart(RepairPartTemp repairPartTemp) {
        RepairPart repairPart = new RepairPart();
        repairPart.setName(repairPartTemp.getPartname());
        repairPart.setDescription(repairPartTemp.getPartdescription());
        repairPart.setPrice(repairPartTemp.getPartprice());
        Repair repair = repairRepository.findAll().stream()
                .filter(Repair -> Repair.getIdRepair().equals(repairPartTemp.getIdRepair()))
                .findFirst().orElse(null);
        repairPart.setRepair(repair);
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
