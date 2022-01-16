package com.engineer.carmanager.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@Entity
@Table(name = "refuel")
public class Refuel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idRefuel;
    @Enumerated(value = EnumType.STRING)
    private typeOfFuel typeOfFuel;
    private double volume;
    private double price;
    @ManyToOne
    @JsonIgnoreProperties(value = {"typeOfFuel", "capacity", "car"}, allowGetters = false)
    private FuelTank fuelTank;

    public Long getIdRefuel() {
        return idRefuel;
    }

    public void setIdRefuel(Long idRefuel) {
        this.idRefuel = idRefuel;
    }

    public com.engineer.carmanager.models.typeOfFuel getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(com.engineer.carmanager.models.typeOfFuel typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
    }

    public Refuel() {
    }

    public Refuel(com.engineer.carmanager.models.typeOfFuel typeOfFuel, double volume, double price, FuelTank fuelTank) {
        this.typeOfFuel = typeOfFuel;
        this.volume = volume;
        this.price = price;
        this.fuelTank = fuelTank;
    }
}
