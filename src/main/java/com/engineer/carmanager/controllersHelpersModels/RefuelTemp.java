package com.engineer.carmanager.controllersHelpersModels;

import com.engineer.carmanager.models.typeOfFuel;

public class RefuelTemp {
    private typeOfFuel typeOfFuel;
    private double volume;
    private double price;
    private Long idCar;

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

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }
}
