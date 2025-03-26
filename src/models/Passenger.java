package models;

import services.PaymentMethod;

public abstract class Passenger {
    protected String name;
    protected int age;
    protected double cashBalance;
    protected double creditCardLimit;
    protected double kentKartBalance;
    protected PaymentMethod paymentMethod;

    // Constructor
    public Passenger(String name, int age, double cash, double credit, double kentkart, PaymentMethod method) {
        this.name = name;
        this.age = age;
        this.cashBalance = cash;
        this.creditCardLimit = credit;
        this.kentKartBalance = kentkart;
        this.paymentMethod = method;
    }

    // Abstract method to be implemented by subclasses
    public abstract double applyDiscount(float cost);

    // Getter - Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public double getCreditCardLimit() {
        return creditCardLimit;
    }

    public void setCreditCardLimit(double creditCardLimit) {
        this.creditCardLimit = creditCardLimit;
    }

    public double getKentKartBalance() {
        return kentKartBalance;
    }

    public void setKentKartBalance(double kentKartBalance) {
        this.kentKartBalance = kentKartBalance;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
