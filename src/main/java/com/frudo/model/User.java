package com.frudo.model;

import org.springframework.data.annotation.Id;

/**
 * Created by abhimanyus on 11/26/17.
 */
public class User implements IUser {

    @Id
    String userId;
    String userName;
    Number mobileNumber;
    String address;
    String email;
    Boolean isDriver;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Number getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Number mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getDriver() {
        return isDriver;
    }

    public void setDriver(Boolean driver) {
        isDriver = driver;
    }
}
