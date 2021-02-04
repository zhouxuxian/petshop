package com.java.domain;

public class Dog extends Animal {

    public Dog(String name, Double tradePrice, Double soldPrice) {
        super(name, tradePrice, soldPrice, false);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", price=" + tradePrice ;
    }
}
