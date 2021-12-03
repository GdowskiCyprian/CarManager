package com.engineer.carmanager;

import com.engineer.carmanager.models.*;
import com.engineer.carmanager.repositories.*;
import com.engineer.carmanager.security.PasswordConfig;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

@Component
public class TestDataInjection implements ApplicationListener<ContextRefreshedEvent> {
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;
    private final FuelTankRepository fuelTankRepository;
    private final RefuelRepository refuelRepository;
    private final RepairPartRepository repairPartRepository;
    private final RepairRepository repairRepository;
    private final RepairShopRepository repairShopRepository;
    private final PasswordConfig passwordConfig;
    private final AuthRepository authRepository;

    public TestDataInjection(CarRepository carRepository, ClientRepository clientRepository, FuelTankRepository fuelTankRepository, RefuelRepository refuelRepository, RepairPartRepository repairPartRepository, RepairRepository repairRepository, RepairShopRepository repairShopRepository, PasswordConfig passwordConfig, AuthRepository authRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
        this.fuelTankRepository = fuelTankRepository;
        this.refuelRepository = refuelRepository;
        this.repairPartRepository = repairPartRepository;
        this.repairRepository = repairRepository;
        this.repairShopRepository = repairShopRepository;
        this.passwordConfig = passwordConfig;
        this.authRepository = authRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        Auth auth1 = new Auth("repairShopEmail", passwordConfig.passwordEncoder().encode("repairShopPassword"), "REPAIR_SHOP");
//        Auth auth2 = new Auth("clientEmail",passwordConfig.passwordEncoder().encode("clientPassword"), "CLIENT" );
//        authRepository.save(auth1);
//        authRepository.save(auth2);
//        RepairShop repairShop = new RepairShop(662211349, "repairShopName", 12345678, auth1);
//        repairShopRepository.save(repairShop);
//        Client client = new Client(112233445, "clientName", "clientSurname",repairShop, auth2);
//        clientRepository.save(client);
//        Car car = new Car(2012,"CarManufacturer", "CarModel", "CarVersion", 1999, 199,199999, client);
//        carRepository.save(car);
//        FuelTank fuelTank = new FuelTank(typeOfFuel.PETROL, 65, car);
//        fuelTankRepository.save(fuelTank);
//        Refuel refuel = new Refuel(typeOfFuel.PETROL, 28, 142, fuelTank);
//        refuelRepository.save(refuel);
//        Date now = new Date(System.currentTimeMillis());
//        Repair repair = new Repair(now, "RepairName", "RepairDescription", car);
//        repairRepository.save(repair);
//        RepairPart repairPart = new RepairPart("RepairPartName", "RepairPartDescription", 19, repair);
//        repairPartRepository.save(repairPart);


    }


}
