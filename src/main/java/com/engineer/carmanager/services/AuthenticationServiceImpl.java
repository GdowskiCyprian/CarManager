package com.engineer.carmanager.services;

import com.engineer.carmanager.models.Auth;
import com.engineer.carmanager.models.Client;
import com.engineer.carmanager.models.RepairShop;
import com.engineer.carmanager.repositories.AuthRepository;
import com.engineer.carmanager.repositories.ClientRepository;
import com.engineer.carmanager.repositories.RepairShopRepository;
import com.engineer.carmanager.security.PasswordConfig;
import org.springframework.stereotype.Service;

@Service("AuthenticationService")
public class AuthenticationServiceImpl implements iAuthenticationService{

    private final ClientRepository clientRepository;
    private final RepairShopRepository repairShopRepository;
    private final AuthRepository authRepository;
    private final PasswordConfig passwordConfig;

    public AuthenticationServiceImpl(ClientRepository clientRepository, RepairShopRepository repairShopRepository, AuthRepository authRepository, PasswordConfig passwordConfig) {
        this.clientRepository = clientRepository;
        this.repairShopRepository = repairShopRepository;
        this.authRepository = authRepository;
        this.passwordConfig = passwordConfig;
    }

    @Override
    public String login(String email) {
        if(repairShopRepository.findAll().stream()
                .anyMatch(RepairShop -> RepairShop.getAuth().getMailAddress().equals(email))){

            return "REPAIR_SHOP";
        }
        else if(clientRepository.findAll().stream()
                .anyMatch(Client -> Client.getAuth().getMailAddress().equals(email)))
        {
            return "CLIENT";
        }
        else{
            return "error";
        }
    }

    @Override
    public String registerClient(String email, String password, String name, String surname, int phoneNumber, Long idRepairShop) {
        Auth auth = new Auth(email, password, "CLIENT");
        authRepository.save(auth);
        RepairShop repairShop = repairShopRepository.findAll().stream().filter(RepairShop -> RepairShop.getIdRepairShop().equals(idRepairShop)).findFirst().get();
        Client client = new Client(phoneNumber, name, surname, repairShop, auth);
        clientRepository.save(client);
        return "Client registration successfull";

    }

    @Override
    public String registerRepairShop(String email, String password, String name, int phoneNumber, int nip) {
        Auth auth = new Auth(email, password, "REPAIR_SHOP");
        RepairShop repairShop = new RepairShop(phoneNumber, name, nip, auth);
        repairShopRepository.save(repairShop);
        return "Repair Shop registration successfull";
    }

    @Override
    public String changePassword(String email, String oldPassword, String newPassword) {
        if(repairShopRepository.findAll().stream()
                .anyMatch(RepairShop -> RepairShop.getAuth().getMailAddress().equals(email))){
            RepairShop repairShop = repairShopRepository.findAll().stream()
                    .filter(RepairShop -> RepairShop.getAuth().getMailAddress().equals(email)).findFirst().get();
            if(repairShop.getAuth().getPassword().equals(passwordConfig.passwordEncoder().encode(oldPassword)))
            {
                repairShop.getAuth().setPassword(passwordConfig.passwordEncoder().encode(newPassword));
                repairShopRepository.save(repairShop);
                return "Password changed succesfully";
            }
            else{
                return "Please check your credentials";
            }
        }
        else if(clientRepository.findAll().stream()
                .anyMatch(Client -> Client.getAuth().getMailAddress().equals(email))){
            Client client = clientRepository.findAll().stream()
                    .filter(Client -> Client.getAuth().getMailAddress().equals(email)).findFirst().get();
            if(client.getAuth().getPassword().equals(passwordConfig.passwordEncoder().encode(oldPassword)))
            {
                client.getAuth().setPassword(passwordConfig.passwordEncoder().encode(newPassword));
                clientRepository.save(client);
                return "Password changed succesfully";
            }
            else{
                return "Please check your credentials";
            }
        }
        else{
            return "there was some error, check your credentials and try again";
        }
    }
}
