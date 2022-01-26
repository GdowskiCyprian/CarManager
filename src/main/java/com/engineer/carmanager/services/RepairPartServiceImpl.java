package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.models.RepairPart;
import com.engineer.carmanager.repositories.RepairPartRepository;
import com.engineer.carmanager.repositories.RepairRepository;
import org.springframework.stereotype.Service;

@Service("RepairPartService")
public class RepairPartServiceImpl implements iRepairPartService{

    private final RepairPartRepository repairPartRepository;
    private final RepairRepository repairRepository;

    public RepairPartServiceImpl(RepairPartRepository repairPartRepository, RepairRepository repairRepository) {
        this.repairPartRepository = repairPartRepository;
        this.repairRepository = repairRepository;
    }

    @Override
    public String postRepairPart(String partname, String partdescription, Double price, Long idRepair) {
        String returnMessage = "Repair part saved";
        try {
            RepairPart repairPart = new RepairPart();
            repairPart.setName(partname);
            repairPart.setDescription(partdescription);
            repairPart.setPrice(price);
            Repair repair = repairRepository.findAll().stream()
                    .filter(Repair -> Repair.getIdRepair().equals(idRepair))
                    .findFirst().get();
            repairPart.setRepair(repair);
            repairPartRepository.save(repairPart);
        }
        catch (Exception e){
            returnMessage = "Repair part save unsuccessful";
        }
        return returnMessage;
    }

    @Override
    public String deleteRepairPart(Long id) {
        String returnMessage = "Repair part deleted";
        try{
            repairPartRepository.deleteById(id);
        }
        catch (Exception e){
            returnMessage = "Repair part delete unsuccessful";
        }
        return returnMessage;
    }
}
