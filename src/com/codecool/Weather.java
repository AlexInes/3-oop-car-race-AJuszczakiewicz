package com.codecool;
import static com.codecool.RandomNumberGenerator.getRandomNumberInRange;

public class Weather {
    static boolean raining = false;

    static void setRaining(){
        int chance = getRandomNumberInRange(0,100);
        if(chance <= 30){
            raining = true;
        } else {
            raining = false;
        }
    }

    static boolean isRaining(){
        return raining;
    }

}
