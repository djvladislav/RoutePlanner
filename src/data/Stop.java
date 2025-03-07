package data;


import models.Transfer;
import java.util.ArrayList;
import java.util.List;

public class Stop      {
private String id;
private String name;
private String type;
private double lat;
private double lon;
private boolean lastStop;
private List<NextStop> nextStops;
private Transfer transfer;


    public Stop(String id,String name,String type,double lat, double lon,boolean lastStop){
        this.id=id;
        this.name=name;
        this.type=type;
        this.lat=lat;
        this.lon=lon;
        this.lastStop=lastStop;
        nextStops=new ArrayList<NextStop>();
    }




    //                                      getter methods

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public boolean isLastStop() {
        return lastStop;
    }

    public List<NextStop> getNextStops() {
        return nextStops;
    }

    public Transfer getTransfer() {
        return transfer;
    }


    //                                       setter methods

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLastStop(boolean lastStop) {
        this.lastStop = lastStop;
    }

    public void setNextStops(List<NextStop> nextStops) {
        this.nextStops = nextStops;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

}
