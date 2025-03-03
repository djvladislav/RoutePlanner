package models;


public abstract class Passenger {
    private String name;
    private int age;
    private boolean isValidForDiscount;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract double applyDiscount(float cost);



}
