package com.engineer.carmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
@Entity
@Table(name = "Repair")
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRepair;
    private LocalDate date;
    private String name;
    private String description;

    @ManyToOne
    @JsonIgnoreProperties(value = {"yearOfManufacture", "manufacturer", "model","version", "displacement", "power", "mileage", "client"}, allowGetters = false)
    private Car car;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repair")

    private Set<RepairPart> repairParts;

    public long getIdRepair() {
        return idRepair;
    }

    public void setIdRepair(long idRepair) {
        this.idRepair = idRepair;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Set<RepairPart> getRepairParts() {
        return repairParts;
    }

    public void setRepairParts(Set<RepairPart> repairParts) {
        this.repairParts = repairParts;
    }

    public Repair() {
    }

    public Repair(LocalDate date, String name, String description, Car car) {
        this.date = date;
        this.name = name;
        this.description = description;
        this.car = car;
    }
}
