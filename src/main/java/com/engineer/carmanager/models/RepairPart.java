package com.engineer.carmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class RepairPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRepairPart;
    private String name;
    private String description;
    private double price;
    @Lob
    private byte[] image;

    @ManyToOne
    @JsonIgnoreProperties(value = {"date", "name", "description","car"}, allowGetters = false)
    private Repair repair;

    public RepairPart(String repairPartName, String repairPartDescription, int price, Repair repair) {
    }

    public long getIdRepairPart() { return idRepairPart; }

    public void setIdRepairPart(long idRepairPart) {
        this.idRepairPart = idRepairPart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public RepairPart() {
    }

    public RepairPart(String name, String description, double price, Repair repair) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.repair = repair;
    }

    public RepairPart(String name, String description, double price, byte[] image, Repair repair) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.repair = repair;
    }
}
