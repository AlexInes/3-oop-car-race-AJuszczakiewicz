package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Vehicle> vehicles = new ArrayList<>();
    private static Weather weather = new Weather();

    

    public static void main(String[] args) {
        Race race = new Race(10);
        race.simulateRace(50);
        race.printRaceResults();

    }

    public Race(int numOfVehiclesEachType){
        this.vehicles = createVehicles(numOfVehiclesEachType);
    }

    public static List<Vehicle> createVehicles(int numOfVehiclesEachType){
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < numOfVehiclesEachType; i++) {
            for (Vehicle.VehiclesCreator creator: Vehicle.VehiclesCreator.values()) {
                vehicles.add(creator.createVehicle());
            }
        }
        return vehicles;

    }

    public void simulateRace(int hoursOfRace){
        for (int i = 0; i < 50 ; i++) {
            weather.setRaining();
            for (Vehicle vehicle: vehicles) {
                vehicle.moveForAnHour(this);
            }
        }
    }

    public void printRaceResults(){
        for (Vehicle vehicle: vehicles) {
            System.out.println(vehicle.getType()+" " + vehicle.getName() + " travelled " + vehicle.getDistanceTravelled());
        }
    }

    public boolean isThereABrokenTruck(){
        for (Vehicle vehicle: vehicles) {
            if(vehicle instanceof Truck){
                if(((Truck) vehicle).isBroken()){
                    return true;
                }
            }
        }
        return false;
    }

    public Weather getWeather(){ return weather; }
}
