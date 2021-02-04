package com.java.shop;

import com.java.domain.Animal;
import com.java.domain.Goods;
import com.java.domain.SetMeal;
import com.java.domain.Vaccine;
import com.java.util.Utils;

import java.time.LocalDateTime;
import java.util.*;

public class MyPetShop implements PetShop {
    private double money;
    private Map<String,Animal> animalMap = new HashMap<>();
    private Map<Integer,Vaccine> vaccineMap = new HashMap<>();


    private double shuntedPrice;


    /**
     * 资金和寄养费
     *
     * @param money
     * @param shuntedPrice
     */
    public MyPetShop(double money, double shuntedPrice) {
        this.money = money;
        this.shuntedPrice = shuntedPrice;
    }

    /**
     * 获得资金余额
     *
     * @return
     */
    public double getMoney() {
        return money;
    }

    /**
     * 检查钱够不够
     */
    public void check(double price) throws Exception {
        if (money<price)
        throw new Exception("钱不够了,无法购进这个货物");
    }

    /**
     * 检查有没有名为xx的宠物
     */
    public Animal exist(String name) throws Exception {
        Animal animal= animalMap.getOrDefault(name, null);
        if (animal==null){
            throw new Exception("不存在名字为" + name + "的动物");
        }
        return animal;
    }

    /**
     * 检查有没有编号为xx的疫苗
     */

    public Vaccine exist(int id) throws Exception {
        Vaccine vaccine = vaccineMap.getOrDefault(id,null);
        if (vaccine== null){
            throw new Exception("不存在编号为为" + id + "的疫苗");
        }
        return vaccine;
    }

    /**
     * 出售套餐
     */
    @Override
    public void soldMeat(SetMeal setMeal) {
        try {
            String animalName = setMeal.getAnimalName();
            int vaccineId = setMeal.getVaccineId();
            exist(animalName);
            exist(vaccineId);
            Utils.printInfo(setMeal, setMeal.getPrice());
            money += setMeal.getPrice();
        } catch (Exception e) {
            Utils.printException(e);
        }


    }

    /**
     * 出售动物
     *
     * @param animal
     * @throws Exception
     */
    @Override
    public void soldAnimal(Animal animal) {
        animalMap.remove(animal.getName());
        Utils.printInfo(animal, animal.getSoldPrice());
    }

    public Animal soldAnimal(String name) {
        try {
            Animal animal = exist(name);
            soldAnimal(animal);
            money += animal.getSoldPrice();
            return animal;
        } catch (Exception e) {
            Utils.printException(e);
        }
        return null;
    }

    /**
     * 出售疫苗
     *
     * @param vaccine
     * @throws Exception
     */
    @Override
    public void soldVaccine(Vaccine vaccine) {
        vaccineMap.remove(vaccine.getId());
        Utils.printInfo(vaccine, vaccine.getSoldPrice());
    }

    public Vaccine soldVaccine(int vaccineId) {
        try {
            Vaccine vaccine = exist(vaccineId);
            soldVaccine(vaccine);
            money += vaccine.getSoldPrice();
            return vaccine;
        } catch (Exception e) {
            Utils.printException(e);
        }
        return null;
    }


    /**
     * 添加货物，扣除资金
     *
     * @param good
     */
    @Override
    public void addGood(Goods good) {
        try {
            check(good.getTradePrice());
            money -= good.getTradePrice();
            if (good instanceof Animal) {
                Animal animal = (Animal) good;
                animalMap.put(animal.getName(),animal);
            } else {
                Vaccine vaccine = (Vaccine) good;
                vaccineMap.put(vaccine.getId(),vaccine);
            }
            System.out.println("在" + Utils.format(LocalDateTime.now()) + "购进了" + good + "花了" + good.getTradePrice() + "元");
        } catch (Exception e) {
            Utils.printException(e);
        }


    }


    /**
     * 寄养动物
     *
     * @param animal
     * @param day
     */
    @Override
    public void shunted(Animal animal, int day) {
        try {
            if (animal.isDangerous()) {
                throw new Exception("这种动物太危险了,本店不收");
            }
            double profile = shuntedPrice * day;
            money += profile;
            animal.setFoster(LocalDateTime.now());
            System.out.println("在" + animal.getFosterStr() + "寄养了一只宠物,名字为‘"+animal.getName()+"’,盈利" + profile + "元");
        } catch (Exception e) {
            Utils.printException(e);
        }

    }

    /**
     * 打疫苗
     *
     * @param animal
     * @param vaccineId
     */
    @Override
    public void immunized(Animal animal, int vaccineId) {
        if (animal.isImmune()) {
            System.out.println("你的宠物已经打过疫苗，无需重复注射");
            return;
        }
        soldVaccine(vaccineId);
        animal.setImmune(true);
        System.out.println("您的宠物"+animal.getName()+"成功注射了编号为"+vaccineId+"的疫苗");

    }

}
