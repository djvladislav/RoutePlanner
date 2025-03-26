package services;

import data.Stop;
import models.Passenger;

import java.util.List;
import java.util.Map;

public class routeCalculator {

    private static final double TAKSI_ESIK_MESAFE = 3.0; // km

    public static RouteResult calculateOptimalRoute(
            double userLat,
            double userLon,
            double destLat,
            double destLon,
            Passenger passenger,
            List<Stop> allStops
    ) {
        Stop startNearest = StopFinder.findNearestStop(userLat, userLon, allStops);
        Stop targetNearest = StopFinder.findNearestStop(destLat, destLon, allStops);

        boolean taxiStartNeeded = DistanceCalculator.calculateDistance(userLat, userLon, startNearest.getLat(), startNearest.getLon()) > TAKSI_ESIK_MESAFE;
        boolean taxiEndNeeded = DistanceCalculator.calculateDistance(destLat, destLon, targetNearest.getLat(), targetNearest.getLon()) > TAKSI_ESIK_MESAFE;

        // Şimdilik sadece süreye göre rota hesaplıyoruz
        Map<Stop, Stop> previousStops = Dijkstra.findShortestPathByTime(allStops, startNearest, targetNearest);
        List<Stop> route = Dijkstra.getShortestPath(previousStops, startNearest, targetNearest);

        RouteResult result = new RouteResult();
        result.setStartStop(startNearest);
        result.setTargetStop(targetNearest);
        result.setFullRoute(route);
        result.setTaxiNeededAtStart(taxiStartNeeded);
        result.setTaxiNeededAtEnd(taxiEndNeeded);

        return result;
    }

    // Sonucu taşıyacak basit yardımcı sınıf (istersen dışarı çıkarılabilir)
    public static class RouteResult {
        private Stop startStop;
        private Stop targetStop;
        private List<Stop> fullRoute;
        private boolean taxiNeededAtStart;
        private boolean taxiNeededAtEnd;

        public Stop getStartStop() {
            return startStop;
        }

        public void setStartStop(Stop startStop) {
            this.startStop = startStop;
        }

        public Stop getTargetStop() {
            return targetStop;
        }

        public void setTargetStop(Stop targetStop) {
            this.targetStop = targetStop;
        }

        public List<Stop> getFullRoute() {
            return fullRoute;
        }

        public void setFullRoute(List<Stop> fullRoute) {
            this.fullRoute = fullRoute;
        }

        public boolean isTaxiNeededAtStart() {
            return taxiNeededAtStart;
        }

        public void setTaxiNeededAtStart(boolean taxiNeededAtStart) {
            this.taxiNeededAtStart = taxiNeededAtStart;
        }

        public boolean isTaxiNeededAtEnd() {
            return taxiNeededAtEnd;
        }

        public void setTaxiNeededAtEnd(boolean taxiNeededAtEnd) {
            this.taxiNeededAtEnd = taxiNeededAtEnd;
        }
    }
}
