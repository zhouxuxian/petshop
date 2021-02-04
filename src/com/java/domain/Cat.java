package com.java.domain;

public class Cat extends Animal {
    public Cat(String name, Double tradePrice, Double soldPrice) {
        super(name, tradePrice, soldPrice,false);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", price=" + tradePrice ;
    }
}
