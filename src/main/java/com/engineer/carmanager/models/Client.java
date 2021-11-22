package com.engineer.carmanager.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name = "Client")
@JsonIgnoreProperties(value = "password")
public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private int phoneNumber;
    private String mailAddress;
    private String password;
    private String name;
    private String Surname;
    @ManyToOne
    @JsonIgnoreProperties(value = {"phoneNumber", "password", "mailAddress","name", "nip"}, allowGetters = false)
    private RepairShop repairShop;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    @JsonIgnore
    private Set<Car> cars;

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

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
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

    public Client(int phoneNumber, String mailAddress, String password, String name, String surname, RepairShop repairShop) {
        this.phoneNumber = phoneNumber;
        this.mailAddress = mailAddress;
        this.password = password;
        this.name = name;
        Surname = surname;
        this.repairShop = repairShop;

    }
}
