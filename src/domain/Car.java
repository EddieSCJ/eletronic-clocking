package domain;

import java.util.List;

public class Car {

    private String name;
    private Double maxVelocity;
    private Integer maxPassengers;
    private List<Passenger> passengers;

    public Car(String name, Double maxVelocity, Integer maxPassengers, List<Passenger> passengers) {
        this.name = name;
        this.maxVelocity = maxVelocity;
        this.maxPassengers = maxPassengers;
        this.passengers = passengers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxVelocity() {
        return maxVelocity;
    }

    public void setMaxVelocity(double maxVelocity) {
        this.maxVelocity = maxVelocity;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

}