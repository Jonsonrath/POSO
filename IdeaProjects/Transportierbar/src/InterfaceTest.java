public class InterfaceTest {



    public boolean transportMachbar(Transportierbar t){

        float gewicht = t.gewicht();

        float laenge = t.laenge();
        float breite = t.breite();
        float hoehe = t.hoehe();

        float gewicht_pro_flaeche = gewicht / (laenge * breite);

        if(gewicht_pro_flaeche < t.MAX_GEWICHT_PRO_FLAECHE) {
            return true;
        }

        return false;
    }

    public float berechne_Volumen(Transportierbar t){

        float laenge = t.laenge();
        float breite = t.breite();
        float hoehe = t.hoehe();

        return laenge * breite * hoehe;
    }

    public String erstelleBeschriftung(Transportierbar t){
        String text = t.beschriftung();
        if(t.zerbrlich()){
            return "Zerbrechlich\t---\t" + text;
        }
        return "\t\t\t\t\t" + text;
    }
}
