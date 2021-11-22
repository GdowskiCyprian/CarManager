package com.engineer.carmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name = "FuelTank")
public class FuelTank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFuelTank;
    @Enumerated(value = EnumType.STRING)
    private typeOfFuel typeOfFuel;
    private double capacity;
    @ManyToOne
    @JsonIgnoreProperties(value = {"yearOfManufacture", "manufacturer", "model","version", "displacement", "power", "mileage", "client"}, allowGetters = false)
    private Car car;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuelTank")
    @JsonIgnore
    private Set<Refuel> refuels;

    public long getIdFuelTank() {
        return idFuelTank;
    }

    public void setIdFuelTank(long idFuelTank) {
        this.idFuelTank = idFuelTank;
    }

    public com.engineer.carmanager.models.typeOfFuel getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(com.engineer.carmanager.models.typeOfFuel typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Set<Refuel> getRefuels() {
        return refuels;
    }

    public void setRefuels(Set<Refuel> refuels) {
        this.refuels = refuels;
    }

    public FuelTank() {
    }

    public FuelTank(com.engineer.carmanager.models.typeOfFuel typeOfFuel, double capacity, Car car) {
        this.typeOfFuel = typeOfFuel;
        this.capacity = capacity;
        this.car = car;

    }
}
