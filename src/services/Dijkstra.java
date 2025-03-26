package services;
import data.Stop;
import data.NextStop;
import models.Passenger;

import java.util.*;


/*
These 3 functions currently return the same value, but if there will be more stops in the future, these functions will also be useful.
or maybe not idk its 4am
 */

public class Dijkstra {

    public static Map<Stop, Stop> findShortestPathByTime(List<Stop> stops, Stop start, Stop target) {
        Map<Stop, Double> times = new HashMap<>();
        Map<Stop, Stop> previousStops = new HashMap<>();
        PriorityQueue<Stop> queue = new PriorityQueue<>(Comparator.comparing(times::get));

        for (Stop stop : stops) {
            times.put(stop, Double.MAX_VALUE);
            previousStops.put(stop, null);
        }
        times.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Stop currentStop = queue.poll();
            if (currentStop.equals(target)) break;

            // normal route
            for (NextStop connection : currentStop.getNextStops()) {
                Stop nextStop = StopFinder.findStopById(stops, connection.getStopId());
                if (nextStop == null)
                    continue;

                double newTime = times.get(currentStop) + connection.getSure();

                if (newTime < times.get(nextStop)) {
                    times.put(nextStop, newTime);
                    previousStops.put(nextStop, currentStop);
                    queue.add(nextStop);
                }
            }

            // check transfer
            if (currentStop.getTransfer() != null) {
                Stop transferStop = StopFinder.findStopById(stops, currentStop.getTransfer().getTransferStopId());
                if (transferStop != null) {
                    double transferTime = times.get(currentStop) + currentStop.getTransfer().getTransferStopSure(); // Aktarma süresini ekle
                    if (transferTime < times.get(transferStop)) {
                        times.put(transferStop, transferTime);
                        previousStops.put(transferStop, currentStop);
                        queue.add(transferStop);
                    }
                }
            }
        }
        return previousStops;
    }

    public static Map<Stop, Stop> findShortestPathByCost(List<Stop> stops, Stop start, Stop target, Passenger passenger) {
        Map<Stop, Double> costs = new HashMap<>();
        Map<Stop, Stop> previousStops = new HashMap<>();
        PriorityQueue<Stop> queue = new PriorityQueue<>(Comparator.comparing(costs::get));

        for (Stop stop : stops) {
            costs.put(stop, Double.MAX_VALUE);
            previousStops.put(stop, null);
        }
        costs.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Stop currentStop = queue.poll();
            if (currentStop.equals(target))
                break;

            // normal route
            for (NextStop connection : currentStop.getNextStops()) {
                Stop nextStop = StopFinder.findStopById(stops, connection.getStopId());
                if (nextStop == null)
                    continue;

                double discountedFare = passenger.applyDiscount((float) connection.getUcret());
                double newCost = costs.get(currentStop) + discountedFare;


                if (newCost < costs.get(nextStop)) {
                    costs.put(nextStop, newCost);
                    previousStops.put(nextStop, currentStop);
                    queue.add(nextStop);
                }
            }

            // check transfer
            if (currentStop.getTransfer() != null) {
                Stop transferStop = StopFinder.findStopById(stops, currentStop.getTransfer().getTransferStopId());
                if (transferStop != null) {

                    double transferCost = costs.get(currentStop) + currentStop.getTransfer().getTransferStopUcret();

                    if (transferCost < costs.get(transferStop)) {
                        costs.put(transferStop, transferCost);
                        previousStops.put(transferStop, currentStop);
                        queue.add(transferStop);
                    }
                }
            }
        }
        return previousStops;
    }

    public static Map<Stop, Stop> findShortestPathWithTransfers(List<Stop> stops, Stop start, Stop target, Passenger passenger) {
        Map<Stop, Double> costs = new HashMap<>();
        Map<Stop, Stop> previousStops = new HashMap<>();
        PriorityQueue<Stop> queue = new PriorityQueue<>(Comparator.comparing(costs::get));

        for (Stop stop : stops) {
            costs.put(stop, Double.MAX_VALUE);
            previousStops.put(stop, null);
        }
        costs.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Stop currentStop = queue.poll();
            if (currentStop.equals(target))
                break;


            for (NextStop connection : currentStop.getNextStops()) {

                Stop nextStop = StopFinder.findStopById(stops, connection.getStopId());

                if (nextStop == null)
                    continue;

                double discountedFare = passenger.applyDiscount((float) connection.getUcret());
                double newCost = costs.get(currentStop) + discountedFare;

                if (newCost < costs.get(nextStop)) {

                    costs.put(nextStop, newCost);
                    previousStops.put(nextStop, currentStop);
                    queue.add(nextStop);
                }
            }

            // check transfer
            if (currentStop.getTransfer() != null) {
                Stop transferStop = StopFinder.findStopById(stops, currentStop.getTransfer().getTransferStopId());
                if (transferStop != null) {
                    double transferCost = costs.get(currentStop) + currentStop.getTransfer().getTransferStopUcret();
                    if (transferCost < costs.get(transferStop)) {
                        costs.put(transferStop, transferCost);
                        previousStops.put(transferStop, currentStop);
                        queue.add(transferStop);
                    }
                }
            }
        }
        return previousStops;
    }

    public static List<Stop> getShortestPath(Map<Stop, Stop> previousStops, Stop start, Stop target) {
        List<Stop> path = new ArrayList<>();
        Stop current = target;

        while (current != null) {
            path.add(current);
            current = previousStops.get(current);
        }
        Collections.reverse(path);
        return path;
    }



}