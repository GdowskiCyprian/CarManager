package com.engineer.carmanager.controllersHelpersModels;

import com.engineer.carmanager.models.typeOfFuel;

public class FuelTankTemp {
    private typeOfFuel typeOfFuel;
    private double capacity;
    private Long idCar;

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

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }
}
