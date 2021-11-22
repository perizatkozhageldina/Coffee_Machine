package machine;

import java.util.Scanner;

public class CoffeeMachine {

    enum StateOfCoffeeMachine {
        choosingAnAction,
        choosingAVariantOfCoffee
    }

    public static void main(String[] args) {
        start();
    }
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int[] coffee = new int[5];
        coffee[0] = 400;
        coffee[1] = 540;
        coffee[2] = 120;
        coffee[3] = 9;
        coffee[4] = 550;
        boolean flag = true;
        while (flag) {
            StateOfCoffeeMachine state = StateOfCoffeeMachine.choosingAnAction;
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String typeOfCoffee = scanner.next();
                    if (typeOfCoffee.equals("back")) {
                        continue;
                    } else {
                        state = StateOfCoffeeMachine.choosingAVariantOfCoffee;
                        buyCoffee(coffee, Integer.parseInt(typeOfCoffee));
                    }
                    break;
                case "fill":
                    fillCoffee(coffee);
                    break;
                case "take":
                    takeCoffee(coffee);
                    break;
                case "remaining":
                    printCoffeeState(coffee);
                    break;
                case "exit":
                    flag = false;
                    break;
            }
        }
    }
    public static void printCoffeeState(int[] coffee) {
        System.out.println("The coffee machine has:");
        System.out.println(coffee[0] + " ml of water");
        System.out.println(coffee[1] + " ml of milk");
        System.out.println(coffee[2] + " g of coffee beans");
        System.out.println(coffee[3] + " disposable cups");
        System.out.println("$" + coffee[4] + " of money");
    }
    public static void buyCoffee(int[] coffee, int coffeeType) {
        if (coffeeType == 1) {
            if (coffee[0] < 250) {
                System.out.println("Sorry, not enough water!");
            } else {
                if (coffee[2] < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    coffee[0] -= 250;
                    coffee[2] -= 16;
                    coffee[3] -= 1;
                    coffee[4] += 4;
                }
            }
        } else if (coffeeType == 2) {
            if (coffee[0] < 350) {
                System.out.println("Sorry, not enough water!");
            } else {
                if (coffee[1] < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    if (coffee[2] < 20) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else {
                        System.out.println("I have enough resources, making you a coffee!");
                        coffee[0] -= 350;
                        coffee[1] -= 75;
                        coffee[2] -= 20;
                        coffee[3] -= 1;
                        coffee[4] += 7;
                    }
                }
            }
        } else if (coffeeType == 3) {
            if (coffee[0] < 200) {
                System.out.println("Sorry, not enough water!");
            } else {
                if (coffee[1] < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    if (coffee[2] < 12) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else {
                        System.out.println("I have enough resources, making you a coffee!");
                        coffee[0] -= 200;
                        coffee[1] -= 100;
                        coffee[2] -= 12;
                        coffee[3] -= 1;
                        coffee[4] += 6;
                    }
                }
            }
        }
    }
    public static void fillCoffee(int[] coffee) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        coffee[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        coffee[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffee[2] += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        coffee[3] += scanner.nextInt();
    }
    public static void takeCoffee(int[] coffee) {
        System.out.println("I gave you $" + coffee[4]);
        coffee[4] = 0;
    }
}