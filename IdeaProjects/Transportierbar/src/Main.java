//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Tisch myTisch = new Tisch("Tisch-01", false, 20.5f, 1.5f, 0.8f, 0.75f);
    Schaf mySchaf = new Schaf("Schaf-Alpha", true, 35.0f, 1.2f, 0.5f, 0.9f);
    Sessel mySessel = new Sessel("Sessel-X", false, 15.0f, 1.0f, 0.7f, 1.0f);
    Gabel myGabel = new Gabel("Gabel-123", true, 2.0f, 0.3f, 0.1f, 0.02f);

    InterfaceTest tester = new InterfaceTest();

    System.out.println("--- Tisch ---");
    System.out.println("Transport machbar: " + tester.transportMachbar(myTisch));
    System.out.println("Volumen: " + tester.berechne_Volumen(myTisch));
    System.out.println("Beschriftung: " + tester.erstelleBeschriftung(myTisch));
    System.out.println();

    System.out.println("--- Schaf ---");
    System.out.println("Transport machbar: " + tester.transportMachbar(mySchaf));
    System.out.println("Volumen: " + tester.berechne_Volumen(mySchaf));
    System.out.println("Beschriftung: " + tester.erstelleBeschriftung(mySchaf));
    System.out.println();

    System.out.println("--- Sessel ---");
    System.out.println("Transport machbar: " + tester.transportMachbar(mySessel));
    System.out.println("Volumen: " + tester.berechne_Volumen(mySessel));
    System.out.println("Beschriftung: " + tester.erstelleBeschriftung(mySessel));
    System.out.println();

    System.out.println("--- Gabel ---");
    System.out.println("Transport machbar: " + tester.transportMachbar(myGabel));
    System.out.println("Volumen: " + tester.berechne_Volumen(myGabel));
    System.out.println("Beschriftung: " + tester.erstelleBeschriftung(myGabel));


    List<Transportierbar> items = new ArrayList<>();
    items.add(myTisch);
    items.add(mySchaf);
    items.add(mySessel);
    items.add(myGabel);

    Collections.sort(items);

    System.out.println("\n--- Sortierte Liste nach Gewicht ---");
    for(Transportierbar item : items) {
        System.out.println(item.beschriftung() + " - Gewicht: " + item.gewicht());
    }


}
