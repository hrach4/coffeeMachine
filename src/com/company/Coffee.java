package com.company;

public class Coffee {
    private int water, milk, coffeebeans, price;

    public Coffee() {
    }

    public Coffee(int water, int milk, int coffeebeans, int price) {
        this.water = water;
        this.milk = milk;
        this.coffeebeans = coffeebeans;
        this.price = price;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeebeans() {
        return coffeebeans;
    }

    public int getPrice() {
        return price;
    }
}
