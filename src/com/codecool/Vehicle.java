package com.codecool;

public abstract class Vehicle {
    protected String name;
    protected int speed;
    protected int distanceTravelled;

    public Vehicle(){
        this(100, 0);
    }

    public Vehicle(int speed){
        this(speed, 0);
    }

    public Vehicle(int speed, int distanceTravelled) {
        this.speed = speed;
        this.distanceTravelled = distanceTravelled;
        this.name = createName();
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public enum VehiclesCreator{
        TRUCK{@Override public Vehicle createVehicle(){return new Truck();}},
        CAR{@Override public Vehicle createVehicle(){return new Car();}},
        MOTORCYCLE{@Override public Vehicle createVehicle(){return new Motorcycle();}};

        public Vehicle createVehicle(){
            throw new UnsupportedOperationException();
        }
    }

    public abstract void moveForAnHour(Race race);

    abstract String createName();

    abstract String getType();
}
