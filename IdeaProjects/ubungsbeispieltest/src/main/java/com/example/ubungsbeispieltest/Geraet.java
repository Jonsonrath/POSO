package com.example.ubungsbeispieltest;

public class Geraet {

    protected String ipAdress;
    protected String hersteller;



    public Geraet(String ipAdress, String hersteller) {

        this.ipAdress = ipAdress;
        this.hersteller = hersteller;

    }

    protected String getIpAdress() {
        return ipAdress;
    }
    protected String getHersteller() {
        return hersteller;
    }
    protected void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }
    protected void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    @Override
    public String toString() {
        return "Geraet [ipAdress=" + ipAdress + ", hersteller=" + hersteller + "]";
    }


}
