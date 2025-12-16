package at.htl.adventskalenderr;

import java.util.Date;

public class AdventskalenderChecker {

    Date heute;

    AdventskalenderChecker() {
        heute = new Date();
    }


    public boolean gueltigesDatum(Date date1, Boolean cheatmode) {
        heute = new Date(); //weil wenn mehrere tage das programm durchläuft dann hat man das falsche datum wenn man das nicht updated weil nur oben datum geholt wird einmal beim starten
        System.out.println("heutiges datum: " + heute.getDate());
        System.out.println("zu prüfendes datum: " + date1.getDate());

        if(cheatmode) {
            return true;
        }

        int h = heute.getDate();
        int d = date1.getDate();

        if(h >= d) {
            return true;
        } else {
            return false;
        }


    }
}
