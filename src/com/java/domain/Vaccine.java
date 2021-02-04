package com.java.domain;

public class Vaccine extends Goods{
    private int id;
    public Vaccine(int id, double tradePrice, double soldPrice) {
        this.id = id;
        this.tradePrice = tradePrice;
        this.soldPrice = soldPrice;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", tradePrice=" + tradePrice +
                ", soldPrice=" + soldPrice +
                '}';
    }
}
