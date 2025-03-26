package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Ulaşım Rota Planlayıcı");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));

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

                // Geçici çıktı
                System.out.println("✅ Yolcu oluşturuldu: " + passenger.getName());
                System.out.println("➡️ Başlangıç: " + lat + ", " + lon);
                System.out.println("➡️ Hedef: " + destLat + ", " + destLon);

                // Bir sonraki adım: burada rota hesaplamayı çağıracağız

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doğru doldurun!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Formu yerleştir
        add(nameLabel);      add(nameField);
        add(ageLabel);       add(ageField);
        add(typeLabel);      add(typeCombo);
        add(latLabel);       add(latField);
        add(lonLabel);       add(lonField);
        add(destLatLabel);   add(destLatField);
        add(destLonLabel);   add(destLonField);
        add(new JLabel());   add(submitButton);

        setVisible(true);
    }
}
