package com.example.ubungsbeispieltest;

public class Switch extends Geraet {
    private boolean managed;

    public Switch(String ipAdress, String hersteller, boolean managed) {
        this.managed = managed;
        super(ipAdress, hersteller);
    }

    public boolean isManaged() {
        return managed;
    }
    public void setManaged(boolean managed) {
        this.managed = managed;
    }

    @Override
    public String toString() {
        return "Switch [managed=" + managed + ", ipAdress=" + ipAdress + ", hersteller=" + hersteller + "]";
    }

}
