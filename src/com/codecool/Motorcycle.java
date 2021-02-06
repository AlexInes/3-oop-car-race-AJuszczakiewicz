package com.codecool;

import static com.codecool.RandomNumberGenerator.getRandomNumberInRange;

public class Motorcycle extends Vehicle {
    private static int nameNumber = 0;

    public Motorcycle() {
        super();
    }

    @Override
    String createName(){
        nameNumber++;
        return "Motorcycle" + (nameNumber );
    }

    @Override
    public void moveForAnHour(Race race) {
        if(race.getWeather().isRaining()){
            speed -= getRandomNumberInRange(5,50);
        } else {
            speed = 100;
        }
        distanceTravelled+= speed;
    }

    @Override
    String getType(){
        return "Motorcycle";
    }

}
