package com.java.domain;

import com.java.util.Utils;

import java.time.LocalDateTime;

public class Animal extends Goods {

    protected String name;

    protected boolean immune;
    //寄养时间
    protected LocalDateTime foster;
    private boolean dangerous;

    //获取寄养时间
    public String getFosterStr() {
        return Utils.format(foster);
    }

    public Animal(String name, Double tradePrice, Double soldPrice, boolean dangerous) {
        this.name = name;
        this.tradePrice = tradePrice;
        this.soldPrice = soldPrice;
        this.dangerous = dangerous;
    }

    protected LocalDateTime getFoster() {
        return foster;
    }

    public void setFoster(LocalDateTime foster) {
        this.foster = foster;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setImmune(boolean immune) {
        this.immune = immune;
    }

    public String getName() {
        return name;
    }


    public boolean isDangerous() {
        return dangerous;
    }

    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }

    public boolean isImmune() {
        return immune;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", price=" + tradePrice +
                ", immune=" + immune +
                '}';
    }
}
