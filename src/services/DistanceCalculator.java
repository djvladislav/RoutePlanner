package services;

public class DistanceCalculator {

    public static double calculateDistance(double x1, double y1, double x2, double y2) { // i'll be using simple  euclidean distance formula
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }


}
