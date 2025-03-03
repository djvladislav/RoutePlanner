package models;

public class General extends Passenger {

    public General(String name,int age)
    {
        super(name,age);
    }

    @Override
    public double applyDiscount(float cost) {
        return cost; // no discount for "normal" people
    }
}
