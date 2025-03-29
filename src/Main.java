import data.Stop;
import data.City;
import models.Passenger;
import models.Student;
import models.Taxi;
import models.Teacher;
import services.Dijkstra;
import services.StopFinder;
import services.DistanceCalculator;
import data.jsonReader;
import models.Elderly;
import java.util.List;
import java.util.Map;
import services.PaymentMethod;
import models.Student;
public class Main {
    public static void main(String[] args) {

        // 1. JSON verisini oku
        City city = jsonReader.readCity("C:\\Users\\mervan\\Desktop\\proprolab\\veri.json.txt");
        if (city == null) {
            System.out.println("⚠️ Şehir verisi yüklenemedi. Lütfen 'veri.json' dosyasının doğru yerde olduğundan emin olun.");
            return;
        }

        List<Stop> allStops = city.getStops();

        double userLat = 11.66;
        double userLon = 29.85;
        double targetLat = 40.82;
        double targetLon = 37.00;

        Stop startStop = StopFinder.findNearestStop(userLat, userLon, allStops);
        Stop targetStop = StopFinder.findNearestStop(targetLat, targetLon, allStops);

        System.out.println("\n📍 En yakın durak: " + startStop.getName() + " (" + startStop.getId() + ")");
        System.out.println("🎯 Hedef durak: " + targetStop.getName() + " (" + targetStop.getId() + ")");



        Passenger passenger = new Student(
                "Ahmet",
                20,
                20.0,   // nakit
                50.0,   // kredi kartı limiti
                30.0,   // kentkart
                PaymentMethod.KENTKART  // ödeme yöntemi
        );
        System.out.println("\n👤 Yolcu Bilgileri:");
        System.out.println("👤 Ad: " + passenger.getName());
        System.out.println("💵 Nakit: " + passenger.getCashBalance() + " TL");
        System.out.println("💳 Kredi Kartı: " + passenger.getCreditCardLimit() + " TL");
        System.out.println("🪙 KentKart: " + passenger.getKentKartBalance() + " TL");
        System.out.println("🧾 Ödeme Yöntemi: " + passenger.getPaymentMethod());


        Taxi taxi = new Taxi();

        double distanceToStart = DistanceCalculator.calculateDistance(userLat, userLon, startStop.getLat(), startStop.getLon());
        boolean startByTaxi = distanceToStart > 3.0;

        double totalFare = 0;
        int totalTime = 0;
        double totalDistance = 0;

        if (startByTaxi) {
            double taxiFareStart = taxi.calculateFare(distanceToStart);
            int estimatedTimeStart = (int)(distanceToStart / 0.5); // Ortalama hız: 30 km/saat = 0.5 km/dk
            totalTime += estimatedTimeStart;

            System.out.println("\n🚖 Başlangıç durağına taksi ile gidiliyor.");
            System.out.println("📏 Mesafe: " + String.format("%.2f", distanceToStart) + " km");
            System.out.println("💰 Ücret: " + String.format("%.2f", taxiFareStart) + " TL");

            totalFare += taxiFareStart;
            totalDistance += distanceToStart;
        } else {
            System.out.println("🚶 Yürüyerek başlangıç durağına ulaşıldı.");
        }


        Map<Stop, Stop> previous = Dijkstra.findShortestPathByCost(allStops, startStop, targetStop, passenger);
        List<Stop> route = Dijkstra.getShortestPath(previous, startStop, targetStop);

        System.out.println("\n🛤 Rota:");
        for (Stop stop : route) {
            System.out.println("➡️ " + stop.getName() + " (" + stop.getId() + ")");
        }

        for (int i = 0; i < route.size() - 1; i++) {
            Stop from = route.get(i);
            Stop to = route.get(i + 1);

            var next = from.getNextStopTo(to);
            if (next != null) {
                totalFare += passenger.applyDiscount((float) next.getUcret());
                totalTime += next.getSure();
                totalDistance += next.getMesafe();
            } else if (from.getTransfer() != null && from.getTransfer().getTransferStopId().equals(to.getId())) {
                totalFare += from.getTransfer().getTransferStopUcret();
                totalTime += from.getTransfer().getTransferStopSure();
            }
        }

        double distanceToTarget = DistanceCalculator.calculateDistance(targetLat, targetLon, targetStop.getLat(), targetStop.getLon());
        boolean endByTaxi = distanceToTarget > 3.0;

        if (endByTaxi) {
            double taxiFareEnd = taxi.calculateFare(distanceToTarget);
            int estimatedTimeEnd = (int)(distanceToTarget / 0.5); // Ortalama hız: 30 km/saat = 0.5 km/dk
            totalTime += estimatedTimeEnd;

            System.out.println("\n🚖 Hedef durağından hedefe taksi ile gidiliyor.");
            System.out.println("📏 Mesafe: " + String.format("%.2f", distanceToTarget) + " km");
            System.out.println("💰 Ücret: " + String.format("%.2f", taxiFareEnd) + " TL");

            totalFare += taxiFareEnd;
            totalDistance += distanceToTarget;
        } else {
            System.out.println("🚶 Yürüyerek hedef konuma ulaşıldı.");
        }


        System.out.println("\n📊 Toplam Yolculuk Özeti:");
        System.out.println("⏳ Süre: " + totalTime + " dk");
        System.out.println("📏 Mesafe: " + String.format("%.2f", totalDistance) + " km");
        System.out.println("💰 Ücret: " + String.format("%.2f", totalFare) + " TL");

        // Alternatif Rotalar
        Map<Stop, Stop> byTimePrev = Dijkstra.findShortestPathByTime(allStops, startStop, targetStop);
        List<Stop> byTimeRoute = Dijkstra.getShortestPath(byTimePrev, startStop, targetStop);

        Map<Stop, Stop> byCostPrev = Dijkstra.findShortestPathByCost(allStops, startStop, targetStop, passenger);
        List<Stop> byCostRoute = Dijkstra.getShortestPath(byCostPrev, startStop, targetStop);

        Map<Stop, Stop> byTransferPrev = Dijkstra.findShortestPathWithTransfers(allStops, startStop, targetStop, passenger);
        List<Stop> byTransferRoute = Dijkstra.getShortestPath(byTransferPrev, startStop, targetStop);

        System.out.println("\n🛤 Alternatif Rotalar:");
        System.out.println("🔹 En Hızlı Rota: " + byTimeRoute.size() + " durak");
        System.out.println("🔹 En Ucuz Rota: " + byCostRoute.size() + " durak");
        System.out.println("🔹 En Az Aktarmalı Rota: " + byTransferRoute.size() + " durak");
    }
}
/*import gui.MainFrame;

public class Main {
    public static void main(String[] args) {
        new MainFrame(); // Swing penceresini başlatır
    }
}*/
