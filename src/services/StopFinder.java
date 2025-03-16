package services;
import data.Stop;

import java.util.List;

/*
This class will be finding the closest stop to the user
 */
public class StopFinder {

    public static Stop findNearestStop(double userX, double userY, List<Stop> stops ) {
        Stop nearestStop = null;
        double minDistance = Double.MAX_VALUE;

        for (Stop stop : stops) {
            double distance = DistanceCalculator.calculateDistance(userX, userY, stop.getLat(), stop.getLon());
            if (distance < minDistance) {
                minDistance = distance;
                nearestStop = stop;
            }
        }

        return nearestStop;
    }

     public static Stop findStopById(List<Stop> stops, String stopId) {
        for (Stop stop : stops) {
            if (stop.getId().equals(stopId)) {
                return stop;
            }
        }
        return null;
    }

}
