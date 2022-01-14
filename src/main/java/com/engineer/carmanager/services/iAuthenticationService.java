package com.engineer.carmanager.services;



public interface iAuthenticationService {
     String login(String email);
     String registerClient(String email, String password, String name, String surname, int phoneNumber, Long idRepairShop);
     String registerRepairShop(String email, String password, String name, int phoneNumber, int nip);
     String changePassword(String email, String oldPassword, String newPassword);
}
