package com.java.shop;

import com.java.domain.Animal;
import com.java.domain.Goods;
import com.java.domain.SetMeal;
import com.java.domain.Vaccine;

public interface PetShop {
    /**
     * 出售
      */
    void soldMeat(SetMeal setMeal);
    void soldAnimal(Animal animal);
    void soldVaccine(Vaccine vaccine);
    /**
     * 进货
     */
    void addGood(Goods goods) throws Exception;

    /**
     * 寄养
     */
    void shunted(Animal animal,int day);
    /**
     * 打疫苗
     */
    void immunized(Animal animal,int vaccineId);
}
