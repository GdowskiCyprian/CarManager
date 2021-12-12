package com.engineer.carmanager.controllersHelpersModels;

public class ClientTemp {
    private String email;
    private String password;
    private String name;
    private String surname;
    private int phoneNumber;
    private Long idRepairShop;

    public ClientTemp(String email, String password, String name, String surname, int phoneNumber, Long idRepairShop) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.idRepairShop = idRepairShop;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getIdRepairShop() {
        return idRepairShop;
    }

    public void setIdRepairShop(Long idRepairShop) {
        this.idRepairShop = idRepairShop;
    }
}
