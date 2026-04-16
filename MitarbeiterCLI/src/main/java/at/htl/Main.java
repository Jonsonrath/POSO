package at.htl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {



        Arbeiter Ludwig =   new Arbeiter("Franz Ludwig Broschegg", new Gehalt(6, Gehaltstyp.L, 40));
        Arbeiter Max    =   new Arbeiter("Maximilian Mörschbacher", new Gehalt(12, Gehaltstyp.L, 80));

        Angestellter Felix = new Angestellter("Felix Reiter", new Gehalt(2000, Gehaltstyp.G));
        Angestellter Julius = new Angestellter("Julius Steiner", new Gehalt(2000, Gehaltstyp.G));

        System.out.println("Ludwig Broschegg" + Ludwig.abbrechnen(""));

        System.out.println("Max Mörschbacher" +  Max.abbrechnen(""));
        System.out.println("Felix Reiter" +  Felix.abbrechnen("4-6"));
        System.out.println("Julius Steiner" +   Julius.abbrechnen("4-6"));



    }
}
