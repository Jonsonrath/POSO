package at.htl;

public class Mitarbeiter {
    protected String _mitarbeiterNAME;
    protected static int _static_ID = 0;
    protected int _mitarbeiterID;
    protected Gehalt _gehalt;

    protected Mitarbeiter(String mitarbeiterName, Gehalt gehalt){
        _mitarbeiterNAME = mitarbeiterName;
        _mitarbeiterID = _static_ID;
        _gehalt = gehalt;
        _static_ID++;
    }

    public String getMitarbeiterName(){
        return _mitarbeiterNAME;
    }
    public int getMitarbeiterID(){
        return _mitarbeiterID;
    }
    public void setMitarbeiterName(String mitarbeiterName){
        _mitarbeiterNAME = mitarbeiterName;
    }
    public void setMitarbeiterID(int mitarbeiterID){
        _mitarbeiterID = mitarbeiterID;
    }
    public int abbrechnen(String s){
        return _gehalt.Abbrechnung(s);
    }





}
