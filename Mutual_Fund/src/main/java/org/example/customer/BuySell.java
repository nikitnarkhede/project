package org.example.customer;

public class BuySell {
    int buysellstatus;
    String name;
    int size;
    int amount;

    @Override
    public String toString() {
        return "BuySell{" +
                "buysellstatus=" + buysellstatus +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", amount=" + amount +
                '}';
    }

    public BuySell(int buysellstatus, String name, int size, int amount) {
        this.buysellstatus = buysellstatus;
        this.name = name;
        this.size = size;
        this.amount = amount;
    }

    public int getBuysellstatus() {
        return buysellstatus;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getAmount() {
        return amount;
    }
}
