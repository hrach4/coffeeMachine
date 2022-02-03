package com.company;

import java.util.Scanner;

public class CoffeeMachine {
    Scanner scan = new Scanner(System.in);
    private int water, milk, coffeebeans, cups, balanse;

    public CoffeeMachine(int water, int milk, int coffeebeans, int cups, int balanse) {
        this.water = water;
        this.milk = milk;
        this.coffeebeans = coffeebeans;
        this.cups = cups;
        this.balanse = balanse;
    }

    Coffee espresso = new Coffee(250, 0, 16, 4);
    Coffee latte = new Coffee(350, 75, 20, 7);
    Coffee cappuccino = new Coffee(200, 100, 12, 6);


    public String chooseAction() {
        System.out.println("If you want buy coffee input 'buy\nIf you are a special worker and you think that it is time to fill out all the supplies for the coffee machine, input 'fill'\nIf you are another special worker and it is time to take the money from the coffee machine, input 'take'");
        String str = scan.next();
        if (str.equals("exit")) {
            System.exit(0);
        }
        return str;
    }

    public void tascmanage(String chooseaction) {
        switch (chooseaction) {
            case "buy":
                Coffee SelectedCoffee = selectCoffee();
                int SelectedAmunt = selectAmountOfCups();
                if (CheckResources(SelectedCoffee, SelectedAmunt)) {
                    sellcoffee(SelectedCoffee, SelectedAmunt);
                } else {
                    System.out.println("Sorry, I don't have enough resources to fulfill your order");
                }
                break;
            case "fill":
                fill();
                break;
            case "take":
                balanse = 0;
                break;
        }
    }

    private void fill() {
        System.out.println("how much water do you want to add");
        water += scan.nextInt();
        System.out.println("how much milk do you want to add");
        milk += scan.nextInt();
        System.out.println("how much coffeebeans do you want to add");
        coffeebeans += scan.nextInt();
        System.out.println("how much cups do you want to add");
        cups += scan.nextInt();

    }

    private Coffee selectCoffee() {
        System.out.println("choose the coffee\n1--espresso\n2--latte\n3--cappuccino");
        switch (scan.nextInt()) {
            case 1:
                return espresso;
            case 2:
                return latte;
            case 3:
                return cappuccino;
        }
        return espresso;
    }

    private int selectAmountOfCups() {
        System.out.println("how many cups of coffee do you want");
        return scan.nextInt();
    }

    private void sellcoffee(Coffee selectCoffee, int selectAmount) {
        water -= selectAmount * selectCoffee.getWater();
        milk -= selectAmount * selectCoffee.getMilk();
        coffeebeans -= selectAmount * selectCoffee.getCoffeebeans();
        cups -= selectAmount;
        balanse += selectAmount * selectCoffee.getPrice();
    }


    public boolean CheckResources(Coffee coffee, int selectAmountOfCups) {
        int watercoefficient = water / coffee.getWater();
        int milkcoefficient = 10000000;
        if (coffee.getMilk() != 0) {
            milkcoefficient = milk / coffee.getMilk();
        }
        int coffeebeanscoefficient = coffeebeans / coffee.getCoffeebeans();
        int resoult = watercoefficient;
        if (resoult > milkcoefficient) {
            resoult = milkcoefficient;
        }
        if (resoult > coffeebeanscoefficient) {
            resoult = coffeebeanscoefficient;
        }
        if (resoult > cups) {
            resoult = cups;
        }

        if (selectAmountOfCups > resoult) {
            return false;
        }

        return true;
    }

    public void display() {
        System.out.println("water--" + water + "\nmilk--" + milk + "\ncoffeebeans--" + coffeebeans + "\ncups--" + cups + "\nbalance--" + balanse);
    }
}
