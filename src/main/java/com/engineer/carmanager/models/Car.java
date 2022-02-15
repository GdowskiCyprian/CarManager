package com.engineer.carmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCar;
    private int yearOfManufacture;
    private String manufacturer;
    private String model;
    private String version;
    private int displacement;
    private int power;
    private int mileage;
    @ManyToOne
    @JsonIgnoreProperties(value = {"phoneNumber", "password",
            "mailAddress","name", "repairShop", "surname"},
            allowGetters = false)
    private Client client;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    @JsonIgnore
    private Set<FuelTank> fuelTanks;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    @JsonIgnore
    private Set<Repair> repairs;

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car() {
    }

    public Car(int yearOfManufacture, String manufacturer, String model, String version, int displacement, int power, int mileage, Client client) {
        this.yearOfManufacture = yearOfManufacture;
        this.manufacturer = manufacturer;
        this.model = model;
        this.version = version;
        this.displacement = displacement;
        this.power = power;
        this.mileage = mileage;
        this.client = client;
    }

    public Car(Long idCar, int yearOfManufacture, String manufacturer, String model, String version, int displacement, int power, int mileage) {
        this.idCar = idCar;
        this.yearOfManufacture = yearOfManufacture;
        this.manufacturer = manufacturer;
        this.model = model;
        this.version = version;
        this.displacement = displacement;
        this.power = power;
        this.mileage = mileage;
    }

}
