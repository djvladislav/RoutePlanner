package models;

import services.PaymentMethod;

public class Elderly extends Passenger {

    private int remainingFreeTrips = 20; // 20 ücretsiz seyahat hakkı

    public Elderly(String name, int age, double cash, double credit, double kentkart, PaymentMethod method) {
        super(name, age, cash, credit, kentkart, method);
    }

    @Override
    public double applyDiscount(float cost) {
        if (remainingFreeTrips > 0) {
            remainingFreeTrips--;
            System.out.println("🧓 Ücretsiz seyahat hakkı kullanıldı. Kalan: " + remainingFreeTrips);
            return 0;
        } else {
            System.out.println("🧓 Ücretsiz seyahat hakkı kalmadı. Normal ücret uygulanıyor.");
            return cost;
        }
    }

    public int getRemainingFreeTrips() {
        return remainingFreeTrips;
    }
}
