package com.java.domain;

public class Snack extends Animal {


    public Snack(String name, Double tradePrice, Double soldPrice) {
        super(name,tradePrice,soldPrice,true);

    }

    @Override
    public String toString() {
        return "Snack{" +
                "name='" + name + '\'' +
                ", price=" + tradePrice ;
    }
}
