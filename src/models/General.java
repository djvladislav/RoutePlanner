package models;

import services.PaymentMethod;

public class General extends Passenger {

    public General(String name, int age, double cash, double credit, double kentkart, PaymentMethod method) {
        super(name, age, cash, credit, kentkart, method);
    }

    @Override
    public double applyDiscount(float cost) {
        return cost; // İndirim yok
    }
}
