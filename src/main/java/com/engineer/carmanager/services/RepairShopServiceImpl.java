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
    public List<RepairShop> getAllRepairShop() {
        return repairShopRepository.findAll();
    }

    @Override
    public RepairShop getRepairShopByMailAddress(String mailAddress) {
        return repairShopRepository.findAll().stream()
                .filter(repairShop -> repairShop.getAuth().getMailAddress().equals(mailAddress))
                .findFirst()
                .get();
    }
}
