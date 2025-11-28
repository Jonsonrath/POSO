package at.htl.adventskalenderr;

import java.util.Date;

public class AdventskalenderChecker {

    Date heute;

    AdventskalenderChecker() {
        heute = new Date();
    }


    public boolean gueltigesDatum(Date date1, Boolean cheatmode) {

        if(date1.before(heute) || date1.equals(heute) || cheatmode == true) {
            return true;
        } else {
            return false;
        }


    }
}
