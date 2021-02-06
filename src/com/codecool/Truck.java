package com.codecool;

import java.util.HashSet;

import static com.codecool.RandomNumberGenerator.getRandomNumberInRange;

public class Truck extends Vehicle {
    private static HashSet<Integer> nameNum = new HashSet<>();
    private int breakdownTurnsLeft;

    public Truck() {
        super();
        this.breakdownTurnsLeft = 0;
    }

    @Override
    String getType(){
        return "Truck";
    }

    @Override
    String createName() {
        Integer randomNumber;
        do {
            randomNumber = getRandomNumberInRange(0,1000);
        } while(!nameNum.add(randomNumber));
        return Integer.toString(randomNumber);
    }

    @Override
    public void moveForAnHour(Race race) {
       breakCheck();
        if(breakdownTurnsLeft == 0){
            distanceTravelled += speed;
        } else {
            breakdownTurnsLeft--;
        }
    }

    public void breakCheck(){
        if(getRandomNumberInRange(0,100) <= 5){
            breakdownTurnsLeft += 2;
        }
    }

    public boolean isBroken(){
        if(breakdownTurnsLeft != 0){
            return true;
        }
        return false;
    }

}
