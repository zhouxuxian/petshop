package com.java;

import com.java.domain.*;
import com.java.shop.MyPetShop;

public class Test {
    public static void main(String[] args) throws Exception {

        MyPetShop myPetShop = new MyPetShop(2000,50);
        myPetShop.addGood(new Dog("哈士奇",500.0,1000.0));
        myPetShop.addGood(new Dog("萨摩耶",400.0,800.0));
        myPetShop.addGood(new Vaccine(0,500.0,600.0));
        myPetShop.addGood(new Vaccine(1,400.0,700.0));
        myPetShop.addGood(new Cat("蓝猫",800.0,800.0));//资金不足 无法进购
        Animal animal = myPetShop.soldAnimal("哈士奇");
        Animal animal1 = myPetShop.soldAnimal("dbaod");//购买不存在的宠物
        myPetShop.immunized(animal,0);
        System.out.println();
        myPetShop.immunized(animal,1);//重复注射疫苗

        SetMeal setMeat1 = new SetMeal(1, "哈士奇", 1, 100);
        SetMeal setMeat2 = new SetMeal(2, "萨摩耶", 1, 100);
        myPetShop.soldMeat(setMeat1);//非法的套餐
        myPetShop.soldMeat(setMeat2);

        myPetShop.shunted(animal,1);
        myPetShop.shunted(new Snack("dd",500.0,600.0),6);//寄养危险动物



    }
}
