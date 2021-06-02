package com.xulelin.model;

import java.util.Date;

public class User {

    private int id;
    private String Username;
    private String Password;
    private String Email;
    private String Gender;
    private java.util.Date BirthDate;

    //construction
    public User() {
    }//full

    public User(int id, String Username, String Password, String Email, String Gender, Date BirthDate) {
        this.id = id;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Gender = Gender;
        this.BirthDate = BirthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Gender='" + Gender + '\'' +
                ", BirthDate=" + BirthDate +
                '}';
    }
}
