package models;

import services.PaymentMethod;

public class Teacher extends Passenger {

    public Teacher(String name, int age, double cash, double credit, double kentkart, PaymentMethod method) {
        super(name, age, cash, credit, kentkart, method);
    }

    @Override
    public double applyDiscount(float cost) {
        return cost * 0.75; // %25 indirim
    }
}
