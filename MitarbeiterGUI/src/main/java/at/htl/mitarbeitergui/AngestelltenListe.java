        package at.htl.mitarbeitergui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collection;

public class AngestelltenListe {

    private static final AngestelltenListe INSTANCE = new AngestelltenListe();

    private final ObservableList<Mitarbeiter> mitarbeiterList = FXCollections.observableArrayList();

    private AngestelltenListe() {
    }

    public static AngestelltenListe getInstance() {
        return INSTANCE;
    }

    public ObservableList<Mitarbeiter> getObservableList() {
        return mitarbeiterList;
    }

    public void add(Mitarbeiter m) {
        mitarbeiterList.add(m);
    }

    public void remove(Mitarbeiter m) {
        mitarbeiterList.remove(m);
    }


    public void addBeispielDaten() {
        /*
    protected String _mitarbeiterNAME;
    protected static int _static_ID = 0;
    protected int _mitarbeiterID;
    protected Gehalt _gehalt;
    */


        mitarbeiterList.add(new Arbeiter("Hans Müller", new Gehalt(20, Gehaltstyp.L, 160)));
        mitarbeiterList.add(new Angestellter("Anna Schmidt", new Gehalt(3000, Gehaltstyp.G, "2-4")));
        mitarbeiterList.add(new Arbeiter("Peter Meier", new Gehalt(22, Gehaltstyp.L, 150)));


    }
}
