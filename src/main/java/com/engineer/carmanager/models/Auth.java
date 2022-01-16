package com.engineer.carmanager.models;

import javax.persistence.*;

@Entity
@Table(name="auth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authid;
    private String mailAddress;
    private String password;
    private String role;

    public Auth() {

    }

    public Long getAuthid() {
        return authid;
    }

    public void setAuthid(Long authid) {
        this.authid = authid;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Auth(String mailAddress, String password, String role) {
        this.mailAddress = mailAddress;
        this.password = password;
        this.role = role;
    }

}
