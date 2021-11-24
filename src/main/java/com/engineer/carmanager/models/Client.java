package com.engineer.carmanager.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private int phoneNumber;
    private String name;
    private String surname;
    @ManyToOne
    @JsonIgnoreProperties(value = {"phoneNumber", "password", "mailAddress","name", "nip"}, allowGetters = false)
    private RepairShop repairShop;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    @JsonIgnore
    private Set<Car> cars;
    @OneToOne
    private Auth auth;

    public Client(int phoneNumber, String name, String surname, RepairShop repairShop, Auth auth) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.surname = surname;
        this.repairShop = repairShop;
        this.auth = auth;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public RepairShop getRepairShop() {
        return repairShop;
    }

    public void setRepairShop(RepairShop repairShop) {
        this.repairShop = repairShop;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Client() {
    }




}
