package com.engineer.carmanager.services;

import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.repositories.RepairShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service("RepairShopService")
public class RepairShopServiceImpl implements iRepairShopService{

    private RepairShopRepository repairShopRepository;

    public RepairShopServiceImpl(RepairShopRepository repairShopRepository) {
        this.repairShopRepository = repairShopRepository;
    }

    @Override
    public RepairShop getRepairShopById(Long id) {
        return repairShopRepository.findById(id).get();
    }

    @Override
    public void postRepairShop(RepairShop repairShop) {
        repairShopRepository.save(repairShop);
    }

    @Override
    public List<RepairShop> getAllRepairShop() {
        return repairShopRepository.findAll();
    }

    @Override
    public void deleteRepairShop(Long id) {
        repairShopRepository.deleteById(id);
    }
    @Override
    public RepairShop getRepairShopByMailAddress(String mailAddress) {
        return repairShopRepository.findAll().stream()
                .filter(repairShop -> repairShop.getAuth().getMailAddress().equals(mailAddress))
                .findFirst()
                .get();
    }
}
