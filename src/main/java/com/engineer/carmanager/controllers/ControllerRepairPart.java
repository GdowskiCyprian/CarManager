package com.engineer.carmanager.controllers;


import com.engineer.carmanager.models.RepairPart;
import com.engineer.carmanager.models.RepairPartTemp;
import com.engineer.carmanager.services.iRepairPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/repairParts")
public class ControllerRepairPart {

    @Autowired
    @Qualifier("RepairPartService")
    iRepairPartService iRepairPartService;

    @GetMapping(value = "/repairPartAll")
    public List<RepairPart> getRepairParts() {
        return iRepairPartService.getAllRepairPart();
    }

    @GetMapping(path = "/{repairPartID}")
    public RepairPart getRepairPartById(@PathVariable("repairPartID") Long id) {
        return iRepairPartService.getRepairPartById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/postRepairPart", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void postRepairPart(@RequestParam(value = "partfile") MultipartFile multipartfile){
//        System.out.println(repairPartTemp.getPartname());
//        System.out.println(repairPartTemp.getPartdescription());
//        System.out.println(repairPartTemp.getPartprice());
//        System.out.println(repairPartTemp.getPartfile());
//        System.out.println(repairPartTemp.getIdRepair());
        //iRepairPartService.postRepairPart(repairPartTemp);
        System.out.println(multipartfile);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteRepairPart/{id}")
    public void deleteRepairPart(@PathVariable Long id){
        System.out.println(id);
        iRepairPartService.deleteRepairPart(id);
    }
}
