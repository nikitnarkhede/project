package org.example.customer;

import java.util.ArrayList;
import java.util.List;

public class FundManager {

    String name;
    String username;
    Fund fund;

    public Fund getFund() {
        return fund;
    }

    public FundManager( String name, String username, Fund fund, String password) {

        this.name = name;
        this.username = username;
        this.fund = fund;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    String password;

    @Override
    public String toString() {
        return "FundManager{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", fund=" + fund +
                ", password='" + password + '\'' +
                '}';
    }
}
