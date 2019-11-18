package com.myapp.entity;
import javax.persistence.*;
import javax.persistence.Entity;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String address;
    @Column
    private String cityRegion;
    @Column
    private String cCNumber;
    public String getCityRegion() {
        return cityRegion;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCityRegion(String cityRegion) {
        this.cityRegion = cityRegion;
    }

    public String getcCNumber() {
        return cCNumber;
    }

    public void setcCNumber(String cCNumber) {
        this.cCNumber = cCNumber;
    }
}
