package com.engineer.carmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "RepairShop")
public class RepairShop{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRepairShop;
    private int phoneNumber;
    private String mailAddress;
    private String password;
    private String name;
    private int nip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repairShop")
    @JsonIgnore
    private Set<Client> clients;

    public Long getIdRepairShop() {
        return idRepairShop;
    }

    public void setIdRepairShop(Long idRepairShop) {
        this.idRepairShop = idRepairShop;
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

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public RepairShop() {
    }

    public RepairShop(int phoneNumber, String mailAddress, String password, String name, int nip) {
        this.phoneNumber = phoneNumber;
        this.mailAddress = mailAddress;
        this.password = password;
        this.name = name;
        this.nip = nip;
    }
}
