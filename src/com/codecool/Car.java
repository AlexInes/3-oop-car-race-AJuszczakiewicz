package com.codecool;

import java.util.Random;

import static com.codecool.RandomNumberGenerator.getRandomNumberInRange;

public class Car extends Vehicle {

    private static final String[] carNames = { "Silver", "Patron", "Prestige", "Bliss", "Catalyst", "Blend", "Desire",
            "Blizzard", "Sprite", "Apex", "Purity", "Vagabond", "Augury", "Nimbus", "Reach", "Inferno", "Aura",
            "Dynamo", "Titan", "Majesty"};


    public Car() {
        super(rollSpeed());
    }

    @Override
    String createName(){
        Random generator = new Random();
        int randomIndex = generator.nextInt(carNames.length);
        int randomIndex2 = generator.nextInt(carNames.length);
        return carNames[randomIndex] + " " + carNames[randomIndex2];
    }

    @Override
    String getType(){
        return "Car";
    }

    @Override
    public void moveForAnHour(Race race) {
        this.distanceTravelled += speed;
        if(race.isThereABrokenTruck()) {
            this.speed = 75;
        } else {
            this.speed = rollSpeed();
        }
    }

    private static int rollSpeed(){
        return getRandomNumberInRange(80, 110);
    }
}
