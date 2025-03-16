package data;

public class Transfer {
    private String transferStopId;
    private double transferStopUcret;
    private int transferStopSure;

    public Transfer(String transferStopId, double transferStopUcret, int transferStopSure) {
        this.transferStopId =transferStopId;
        this.transferStopUcret = transferStopUcret;
        this.transferStopSure = transferStopSure;
    }

    //                                      getter methods
    public String getTransferStopId() {
        return transferStopId;
    }

    public int getTransferStopSure() {
        return transferStopSure;
    }

    public double getTransferStopUcret() {
        return transferStopUcret;
    }

    //                                      setter methods

    public void setTransferStopUcret(double transferStopUcret) {
        this.transferStopUcret = transferStopUcret;
    }


    public void setTransferStopId(String transferStopId) {
        this.transferStopId = transferStopId;
    }

    public void setTransferStopSure(int transferStopSure) {
        this.transferStopSure = transferStopSure;
    }

}
