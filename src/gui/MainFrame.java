/*package gui;

import javax.swing.*;
import java.awt.*;
import services.routeCalculator;
import models.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Ulaşım Rota Planlayıcı");
        setSize(1000, 800); // Harita boyutunu büyütüyoruz
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Harita paneli
        MapPanel mapPanel = new MapPanel();
        add(mapPanel, BorderLayout.CENTER);

        // Diğer form bileşenlerini yerleştir
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2, 10, 10));

        // Form elemanları
        JLabel nameLabel = new JLabel("Ad:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Yaş:");
        JTextField ageField = new JTextField();
        JLabel typeLabel = new JLabel("Yolcu Tipi:");
        String[] passengerTypes = {"Öğrenci", "Yaşlı", "Genel", "Öğretmen"};
        JComboBox<String> typeCombo = new JComboBox<>(passengerTypes);
        JLabel latLabel = new JLabel("Başlangıç Enlem:");
        JTextField latField = new JTextField();
        JLabel lonLabel = new JLabel("Başlangıç Boylam:");
        JTextField lonField = new JTextField();
        JLabel destLatLabel = new JLabel("Hedef Enlem:");
        JTextField destLatField = new JTextField();
        JLabel destLonLabel = new JLabel("Hedef Boylam:");
        JTextField destLonField = new JTextField();
        JButton submitButton = new JButton("Rota Hesapla");

        // Formu yerleştir
        inputPanel.add(nameLabel);      inputPanel.add(nameField);
        inputPanel.add(ageLabel);       inputPanel.add(ageField);
        inputPanel.add(typeLabel);      inputPanel.add(typeCombo);
        inputPanel.add(latLabel);       inputPanel.add(latField);
        inputPanel.add(lonLabel);       inputPanel.add(lonField);
        inputPanel.add(destLatLabel);   inputPanel.add(destLatField);
        inputPanel.add(destLonLabel);   inputPanel.add(destLonField);
        inputPanel.add(new JLabel());   inputPanel.add(submitButton);

        add(inputPanel, BorderLayout.WEST);

        // Rota hesapla ve haritayı güncelle
        submitButton.addActionListener(e -> {
            try {
                // Formdan veri al
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String type = (String) typeCombo.getSelectedItem();
                double lat = Double.parseDouble(latField.getText());
                double lon = Double.parseDouble(lonField.getText());
                double destLat = Double.parseDouble(destLatField.getText());
                double destLon = Double.parseDouble(destLonField.getText());

                // Örnek bakiye ve ödeme yöntemi
                double cash = 20.0, credit = 50.0, kentkart = 40.0;
                services.PaymentMethod paymentMethod = services.PaymentMethod.KENTKART;

                // Yolcu nesnesini oluştur
                models.Passenger passenger;

                switch (type) {
                    case "Öğrenci":
                        passenger = new models.Student(name, age, cash, credit, kentkart, paymentMethod);
                        break;
                    case "Yaşlı":
                        passenger = new models.Elderly(name, age, cash, credit, kentkart, paymentMethod);
                        break;
                    case "Öğretmen":
                        passenger = new models.Teacher(name, age, cash, credit, kentkart, paymentMethod);
                        break;
                    default:
                        passenger = new models.General(name, age, cash, credit, kentkart, paymentMethod);
                }

                // Rota hesapla
                routeCalculator.RouteResult result = routeCalculator.calculateOptimalRoute(
                        lat, lon,
                        destLat, destLon,
                        passenger,
                        new data.jsonReader().readCity("C:\\Users\\mervan\\Desktop\\proprolab\\veri.json.txt").getStops()
                );

                // Rota listesini al
                java.util.List<data.Stop> rota = result.getFullRoute();

                // Ekrana yaz
                System.out.println("📍 Rota Başlangıç: " + result.getStartStop().getName());
                System.out.println("🎯 Rota Hedef: " + result.getTargetStop().getName());
                System.out.println("\n🛤 Rota Durakları:");
                for (data.Stop durak : rota) {
                    System.out.println("➡️ " + durak.getName() + " (" + durak.getId() + ")");
                }

                // Haritada rota çiz
                java.util.List<GeoPosition> route = new ArrayList<>();
                for (data.Stop stop : rota) {
                    route.add(new GeoPosition(stop.getLat(), stop.getLon())); // Durakları GeoPosition'a dönüştür
                }
                mapPanel.drawRoute(route, Color.RED); // Örnek olarak kırmızı renkte çiziyoruz

                // Durakları ekle (gerçek durak verileri ile)
                java.util.List<GeoPosition> waypoints = new ArrayList<>();
                for (data.Stop stop : rota) {
                    waypoints.add(new GeoPosition(stop.getLat(), stop.getLon()));
                }
                mapPanel.addWaypoints(waypoints);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doğru doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
*/