package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Repair;
import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.repositories.RepairRepository;
import com.engineer.carmanager.repositories.RepairShopRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("RepairService")
public class RepairServiceImpl implements iRepairService{

    private RepairRepository repairRepository;
    private RepairShopRepository repairShopRepository;

    public RepairServiceImpl(RepairRepository repairRepository, RepairShopRepository repairShopRepository) {
        this.repairRepository = repairRepository;
        this.repairShopRepository = repairShopRepository;
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

    public List<Repair> getRepairsByRepairShop(Long id){
//        List<Repair> tempRepairs = new ArrayList<>();
//        RepairShop repairShop = new RepairShop();
//        repairShop = repairShopRepository.getById(id);
//        tempRepairs =
        return repairRepository.findAll().stream().filter(Repair -> Repair.getCar().getClient().getRepairShop().getIdRepairShop().equals(id)).toList();
    }
}
