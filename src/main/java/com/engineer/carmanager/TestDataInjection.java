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
import java.sql.Date;

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

    public TestDataInjection(CarRepository carRepository, ClientRepository clientRepository, FuelTankRepository fuelTankRepository, RefuelRepository refuelRepository, RepairPartRepository repairPartRepository, RepairRepository repairRepository, RepairShopRepository repairShopRepository, PasswordConfig passwordConfig) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
        this.fuelTankRepository = fuelTankRepository;
        this.refuelRepository = refuelRepository;
        this.repairPartRepository = repairPartRepository;
        this.repairRepository = repairRepository;
        this.repairShopRepository = repairShopRepository;
        this.passwordConfig = passwordConfig;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
     /*   RepairShop repairShop = new RepairShop(662211349,"repairShopEmail", passwordConfig.passwordEncoder().encode("repairShopPassword"), "repairShopName", 12345678);
        repairShopRepository.save(repairShop);
        Client client = new Client(112233445,"clientEmail", passwordConfig.passwordEncoder().encode("clientPassword"), "clientName", "clientSurname",repairShop);
        clientRepository.save(client);
        Car car = new Car(2012,"CarManufacturer", "CarModel", "CarVersion", 1999, 199,199999, client);
        carRepository.save(car);
        FuelTank fuelTank = new FuelTank(typeOfFuel.PETROL, 65, car);
        fuelTankRepository.save(fuelTank);
        Refuel refuel = new Refuel(typeOfFuel.PETROL, 28, 142, fuelTank);
        refuelRepository.save(refuel);
        Date now = new Date(System.currentTimeMillis());
        Repair repair = new Repair(now, "RepairName", "RepairDescription", car);
        repairRepository.save(repair);
        //dodawanie pliku do obiektu
        File file = new File("/Users/savadrox/OneDrive/CarManager/src/main/resources/test.jpg");
        byte[] picInBytes = new byte[(int) file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(picInBytes);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        RepairPart repairPart = new RepairPart("RepairPartName", "RepairPartDescription", 19, repair);
        repairPartRepository.save(repairPart);

*/
    }


}
/*SQL CODE TO APPLY AFTER DATABASE RESET

CREATE TABLE `carmanager`.`auth` (
  `mail_address` VARCHAR(50) NOT NULL,
  `password` VARCHAR(250) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`mail_address`));


delimiter #
CREATE TRIGGER insertToAuthfromRepairShop
AFTER INSERT ON repair_shop
FOR EACH ROW
BEGIN
INSERT INTO auth(mail_address, password, role)
VALUES (new.mail_address, new.password, 'REPAIR_SHOP')
ON DUPLICATE KEY UPDATE password = new.password;
END;
delimiter;
delimiter #
CREATE TRIGGER insertToAuthfromClient
AFTER INSERT ON client
FOR EACH ROW
BEGIN
INSERT INTO auth(mail_address, password, role)
VALUES (new.mail_address, new.password, 'CLIENT')
ON DUPLICATE KEY UPDATE password = new.password;
END;
delimiter;



 */
