package at.htl.mitarbeitergui;

public class Gehalt {
    private int _lohn;
    private final Gehaltstyp _typ;
    private int _arbeitsstunden;
    private String Zeitraum;

    public Gehalt(int lohn, Gehaltstyp typ, int arbeitsstunden) {
        _lohn = lohn;
        _typ = typ;
        _arbeitsstunden = arbeitsstunden;
    }
    public Gehalt(int lohn, Gehaltstyp typ, String Zeitraum) {
        _lohn = lohn;
        _typ = typ;
        this.Zeitraum = Zeitraum;
    }

    public Gehaltstyp getTyp() {
        return _typ;
    }
    public int getLohn() {
        return _lohn;
    }
    public void setLohn(int lohn) {
        _lohn = lohn;
    }
    public int getArbeitsstunden() {
        return _arbeitsstunden;
    }
    public void setArbeitsstunden(int arbeitsstunden) {
        _arbeitsstunden = arbeitsstunden;
    }
    public int Abbrechnung(){
        int gehalt = 0;
        if(_typ == Gehaltstyp.G){
            String[] parts = Zeitraum.split("-");
            int von = Integer.parseInt(parts[0]);
            int bis =  Integer.parseInt(parts[1]);
            int monate = bis - von + 2;//+ 2 weil inklusive die beiden angegebenen monate
            if(monate < 0){
                gehalt = 0;
            }
            else if(monate > 0){
                gehalt = _lohn * monate;
            }
        }
        if(_typ == Gehaltstyp.L){
            gehalt = _lohn * _arbeitsstunden;
        }

        return gehalt;
    }
}
