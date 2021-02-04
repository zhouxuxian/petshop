package com.java.domain;

public class SetMeal {
    private int id;
    private String animalName;
    private int vaccineId;
    private double price;

    @Override
    public String toString() {
        return "套餐{" +
                "id=" + id +
                ", animalName=" + animalName +
                ", vaccineId=" + vaccineId +
                ", price=" + price +
                '}';
    }

    public SetMeal(int id, String animalName, int vaccineId, double price) {
        this.id = id;
        this.animalName = animalName;
        this.vaccineId = vaccineId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



}
