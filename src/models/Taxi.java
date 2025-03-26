package models;
import services.DistanceCalculator;

public class Taxi extends Vehicle {
    private static final double OPENING_FARE = 10.0;
    private static final double COST_PER_KM = 4.0;

    public double calculateFare(double distanceInKm) {
        return OPENING_FARE + (distanceInKm * COST_PER_KM);
    }

    public double calculateFareBetween(double lat1, double lon1, double lat2, double lon2) {
        double distance = DistanceCalculator.calculateDistance(lat1, lon1, lat2, lon2);
        return calculateFare(distance);
    }
}
