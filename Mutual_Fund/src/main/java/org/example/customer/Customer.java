package org.example.customer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
    String name;
    int age;
    String panCard;

    String username;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    String password;

    String email;
    String Address;
    int pincode;

    public ArrayList<Portfolio> getUserFunds() {
        return UserFunds;
    }

    ArrayList<Portfolio> UserFunds;
    int amount;

    public Customer(String name, int age, String panCard, String username, String password, String email, String address, int pincode, ArrayList<Portfolio> userFunds, int amount) {
        this.name = name;
        this.age = age;
        this.panCard = panCard;
        this.username = username;
        this.password = password;
        this.email = email;
        Address = address;
        this.pincode = pincode;
        UserFunds = userFunds;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }



    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPanCard() {
        return panCard;
    }


    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return Address;
    }

    public int getPincode() {
        return pincode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", panCard='" + panCard + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", Address='" + Address + '\'' +
                ", pincode=" + pincode +
                ", UserFunds=" + UserFunds +
                ", amount=" + amount +
                '}';
    }
}
