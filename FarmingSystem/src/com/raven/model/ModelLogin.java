/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.io.InputStream;

/**
 *
 * @author MTUMANGAN
 */
public class ModelLogin {

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public ModelLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public ModelLogin() {
    }

    private String email;
    private String password;
    private String userType;
    private InputStream userImage;

    public InputStream getUserImage() {
        return userImage;
    }

    public void setUserImage(InputStream userImage) {
        this.userImage = userImage;
    }
}
