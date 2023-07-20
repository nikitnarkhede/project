package org.example.customer;

public class Portfolio {


    public int getSize() {
        return size;
    }

    String Name;
        int size;
        int NAV;

    public Portfolio(String name, int size, int NAV) {
        Name = name;
        this.size = size;
        this.NAV = NAV;
    }

    public String getName() {
            return Name;
        }

        public int getNAV() {
            return NAV;
        }

    public void setName(String name) {
        Name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "Name='" + Name + '\'' +
                ", size=" + size +
                ", NAV=" + NAV +
                '}';
    }

    public void setNAV(int NAV) {
        this.NAV = NAV;
    }
}


