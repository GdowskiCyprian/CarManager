package com.engineer.carmanager.services;

import com.engineer.carmanager.models.RepairShop;

import java.util.List;

public interface iRepairShopService {
     List<RepairShop> getAllRepairShop();
     RepairShop getRepairShopByMailAddress(String mailAddress);
}
