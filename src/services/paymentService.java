package services;

import models.Passenger;

public class paymentService {

    public static boolean pay(Passenger passenger, double amount) {
        PaymentMethod method = passenger.getPaymentMethod();

        switch (method) {
            case CASH:
                if (passenger.getCashBalance() >= amount) {
                    passenger.setCashBalance(passenger.getCashBalance() - amount);
                    return true;
                }
                break;
            case CREDIT_CARD:
                if (passenger.getCreditCardLimit() >= amount) {
                    passenger.setCreditCardLimit(passenger.getCreditCardLimit() - amount);
                    return true;
                }
                break;
            case KENTKART:
                if (passenger.getKentKartBalance() >= amount) {
                    passenger.setKentKartBalance(passenger.getKentKartBalance() - amount);
                    return true;
                }
                break;
        }

        System.out.println("❌ Ödeme yapılamadı. Yetersiz bakiye!");
        return false;
    }
}
