package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Auth;
import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.repositories.AuthRepository;
import com.engineer.carmanager.repositories.RepairShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RepairShopService")
public class RepairShopServiceImpl implements iRepairShopService{

    private final RepairShopRepository repairShopRepository;
    private final AuthRepository authRepository;

    public RepairShopServiceImpl(RepairShopRepository repairShopRepository, AuthRepository authRepository) {
        this.repairShopRepository = repairShopRepository;
        this.authRepository = authRepository;
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

    @Override
    public String deleteRepairShop(Long id) {
        String returnMessage = "Repair shop deleted";
        try{
            Auth auth = repairShopRepository.getById(id).getAuth();
            repairShopRepository.deleteById(id);
            authRepository.deleteById(auth.getAuthid());
        }
        catch(Exception e){
            returnMessage = "Repair shop delete unsuccessful";
        }
        return returnMessage;
    }
}
