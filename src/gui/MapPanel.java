/*package gui;

import org.jdesktop.swingx.JXMapViewer;
import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.jdesktop.swingx.mapviewer.Waypoint;
import org.jdesktop.swingx.mapviewer.DefaultWaypoint;

import org.jdesktop.swingx.painter.Painter;
import org.jdesktop.swingx.painter.LinePainter;
import org.jdesktop.swingx.mapviewer.RoutePainter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MapPanel extends JPanel {
    private JXMapViewer mapViewer;

    public MapPanel() {
        setLayout(new BorderLayout());

        // Harita oluştur
        mapViewer = new JXMapViewer();
        mapViewer.setPreferredSize(new Dimension(800, 600));

        // OpenStreetMap kullan
        mapViewer.setTileSource(new org.jdesktop.swingx.tiles.OpenStreetMapTileSource());

        // Başlangıç konumunu set et
        mapViewer.setAddressLocation(new GeoPosition(40.77, 29.92)); // Örnek koordinatlar

        add(mapViewer, BorderLayout.CENTER);
    }

    // Rota çizmek için fonksiyon
    public void drawRoute(List<GeoPosition> route, Color routeColor) {
        // Rota segmentlerini çiz
        RoutePainter routePainter = new RoutePainter(route, routeColor);
        mapViewer.setOverlayPainter(routePainter);
    }

    // Durakları göstermek için fonksiyon
    public void addWaypoints(List<GeoPosition> waypoints) {
        for (GeoPosition point : waypoints) {
            Waypoint waypoint = new DefaultWaypoint(point);
            mapViewer.addWaypoint(waypoint);
        }
    }
}*/
