package com.engineer.carmanager.services;

public interface iRepairPartService {
     String postRepairPart(String partname, String partdescription, Double price, Long idRepair);
     String deleteRepairPart(Long id);
}
