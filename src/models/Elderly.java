package models;

public class Elderly extends Passenger {

    public Elderly(String name,int age) {
        super(name,age);
    }

    @Override
    public double applyDiscount(float cost) {

        return 0; // free public transportation for elderly people
    }
}
