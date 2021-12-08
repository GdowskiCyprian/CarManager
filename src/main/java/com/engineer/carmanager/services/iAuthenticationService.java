package com.engineer.carmanager.services;



public interface iAuthenticationService {
    public String login(String email);
    public String registerClient(String email, String password, String name, String surname, int phoneNumber, Long idRepairShop);
    public String registerRepairShop(String email, String password, String name, int phoneNumber, int nip);
    public String changePassword(String email, String oldPassword, String newPassword);
}
