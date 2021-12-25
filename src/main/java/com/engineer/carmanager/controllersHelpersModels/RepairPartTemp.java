package com.engineer.carmanager.controllersHelpersModels;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class RepairPartTemp {
    private String partname;
    private String partdescription;
    private double partprice;
    private MultipartFile partfile;
    private Long idRepair;

    public MultipartFile getPartfile() {
        return partfile;
    }

    public void setPartfile(MultipartFile partfile) {
        this.partfile = partfile;
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public String getPartdescription() {
        return partdescription;
    }

    public void setPartdescription(String partdescription) {
        this.partdescription = partdescription;
    }

    public double getPartprice() {
        return partprice;
    }

    public void setPartprice(double partprice) {
        this.partprice = partprice;
    }

    public Long getIdRepair() {
        return idRepair;
    }

    public void setIdRepair(Long idRepair) {
        this.idRepair = idRepair;
    }

    public RepairPartTemp() {
    }
}
//
//interface RepairPart{
//    partname:string;
//    partdescription:string;
//    partprice:number;
//    partfile:File | null;
//    idRepair:number;
//}
