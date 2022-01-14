package com.engineer.carmanager.services;

public interface iRepairPartService {
     void postRepairPart(String partname, String partdescription, Double price, Long idRepair);
     void deleteRepairPart(Long id);
}
