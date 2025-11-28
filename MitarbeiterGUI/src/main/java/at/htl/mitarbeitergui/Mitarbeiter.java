package at.htl.mitarbeitergui;

public class Mitarbeiter {
    protected String _mitarbeiterNAME;
    protected static int _static_ID = 0;
    protected int _mitarbeiterID;
    protected Gehalt _gehalt;

    protected Mitarbeiter(String mitarbeiterName, Gehalt gehalt){
        _mitarbeiterNAME = mitarbeiterName;
        _mitarbeiterID = _static_ID++;
        _gehalt = gehalt;
    }

    public String getName(){
        return _mitarbeiterNAME;
    }

    public Integer getID(){
        return _mitarbeiterID;
    }

//tableview braucht String
    public String getTyp(){
        return _gehalt.getTyp().toString();
    }

    public void setName(String mitarbeiterName){
        _mitarbeiterNAME = mitarbeiterName;
    }

    public void setID(int mitarbeiterID){
        _mitarbeiterID = mitarbeiterID;
    }

    public int getBetrag(String dummy){
        return _gehalt.Abbrechnung();
    }

    public Integer getBetrag(){
        return _gehalt.Abbrechnung();
    }

}
