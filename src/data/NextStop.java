package data;


public class NextStop {
    private String stopId;
    private double mesafe; // had to change some variables into Turkish because original data.json has mix of Turkish and English
    private int sure;
    private double ucret;


    public NextStop(String stopId, double distance, int time, double fare) {
        this.stopId = stopId;
        this.mesafe = distance;
        this.sure = time;
        this.ucret = fare;
    }


    //                                      getter methods

    public String getStopId() {
        return stopId;
    }

    public double getMesafe() {
        return mesafe;
    }

    public int getSure(){
        return sure;
    }

    public double getUcret(){
        return ucret;
    }

    //                                      setter methods

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public void setMesafe(double mesafe) {
        this.mesafe = mesafe;
    }

    public void setSure(int sure) {
        this.sure = sure;
    }

    public void setUcret(double ucret) {
        this.ucret = ucret;
    }

}
