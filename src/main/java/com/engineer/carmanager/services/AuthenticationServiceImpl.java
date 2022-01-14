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
            return "Wrong email or Password";
        }
    }

    @Override
    public String registerClient(String email, String password, String name, String surname, int phoneNumber, Long idRepairShop) {
        if(authRepository.findAll().stream().noneMatch(Auth -> Auth.getMailAddress().equals(email))){
            Auth auth = new Auth(email, passwordConfig.passwordEncoder().encode( password), "CLIENT");
            authRepository.save(auth);
            RepairShop repairShop = repairShopRepository.findAll().stream().filter(RepairShop -> RepairShop.getIdRepairShop().equals(idRepairShop)).findFirst().get();
            Client client = new Client(phoneNumber, name, surname, repairShop, auth);
            clientRepository.save(client);
            return "Client registration successfull";
        }
        else{
            return "Email is already taken";
        }


    }

    @Override
    public String registerRepairShop(String email, String password, String name, int phoneNumber, int nip) {
        if(authRepository.findAll().stream().noneMatch(Auth -> Auth.getMailAddress().equals(email))){
            Auth auth = new Auth(email,passwordConfig.passwordEncoder().encode( password), "REPAIR_SHOP");
            authRepository.save(auth);
            RepairShop repairShop = new RepairShop(phoneNumber, name, nip, auth);
            repairShopRepository.save(repairShop);
            return "Repair Shop registration successfull";
        }
        else{
            return "Email is already taken";
        }
    }

    @Override
    public String changePassword(String email, String oldPassword, String newPassword) {
        if(repairShopRepository.findAll().stream()
                .anyMatch(RepairShop -> RepairShop.getAuth().getMailAddress().equals(email))){
            RepairShop repairShop = repairShopRepository.findAll().stream()
                    .filter(RepairShop -> RepairShop.getAuth().getMailAddress().equals(email)).findFirst().get();
            if(

                    passwordConfig.passwordEncoder().matches(oldPassword, repairShop.getAuth().getPassword())
            )
            {
                repairShop.getAuth().setPassword(passwordConfig.passwordEncoder().encode(newPassword));
                repairShopRepository.save(repairShop);
                return "Password changed successfully";
            }
            else{
                return "Please check your credentials";
            }
        }
        else if(clientRepository.findAll().stream()
                .anyMatch(Client -> Client.getAuth().getMailAddress().equals(email))){
            Client client = clientRepository.findAll().stream()
                    .filter(Client -> Client.getAuth().getMailAddress().equals(email)).findFirst().get();
            if(

                    passwordConfig.passwordEncoder().matches(oldPassword, client.getAuth().getPassword())
            )
            {
                client.getAuth().setPassword(passwordConfig.passwordEncoder().encode(newPassword));
                System.out.println(passwordConfig.passwordEncoder().encode(newPassword));
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
