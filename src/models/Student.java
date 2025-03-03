package models;

public class Student extends Passenger {

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public double applyDiscount(float cost) {
        return cost * 0.5; // students have %50 discount
    }
}
