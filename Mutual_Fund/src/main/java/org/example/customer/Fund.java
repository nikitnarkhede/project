package org.example.customer;

import java.math.BigDecimal;

public class Fund {
    String Name;
    int NAV;

    public Fund(String name, int NAV) {
        Name = name;
        this.NAV = NAV;
    }

    public String getName() {
        return Name;
    }

    public void setNAV(int NAV) {
        this.NAV = NAV;
    }

    public int getNAV() {
        return NAV;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "Name='" + Name + '\'' +
                ", NAV=" + NAV +
                '}';
    }
}
