package com.example.ubungsbeispieltest;

public class Router extends Geraet {
    private int anzahlPorts;


    public Router(int anzahlPorts, String ipAdress, String hersteller) {
        this.anzahlPorts = anzahlPorts;
        super(ipAdress, hersteller);
    }
    public int getAnzahlPorts() {
        return anzahlPorts;
    }
    public void setAnzahlPorts(int anzahlPorts) {
        this.anzahlPorts = anzahlPorts;
    }

    @Override
    public String toString() {
        return "Router [anzahlPorts=" + anzahlPorts + ", ipAdress=" + ipAdress + ", hersteller=" + hersteller + "]";
    }

}
