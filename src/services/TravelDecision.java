package services;
import data.Stop;
/*
In this class i will be making a function that decides if it makes more sense to walk to the bus station, rather than going with taxi
 */
public class TravelDecision {

    private static final double maxDistance=0.5;// in kilometers
    public static boolean shouldWalk(double userX,double userY,Stop nearestStop){

        double distance=DistanceCalculator.calculateDistance(userX,userY,nearestStop.getLat(),nearestStop.getLon());

        return maxDistance>distance; // if the distance is less than 500 meters, the boolean will return 1, meaning user can walk to the stop

    }

}
