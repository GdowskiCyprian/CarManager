package com.engineer.carmanager.services;

import com.engineer.carmanager.models.RepairShop;

import java.util.List;

public interface iRepairShopService {

    public RepairShop getRepairShopById(Long id);
    public void postRepairShop(RepairShop repairShop);
    public List<RepairShop> getAllRepairShop();
    public void deleteRepairShop(Long id);
    public RepairShop getRepairShopByMailAddress(String mailAddress);
}
