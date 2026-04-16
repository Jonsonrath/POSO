//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
	
	
	Bauernhof hof = new Bauernhof();
	
	hof.addStall("Nord");
	hof.addStall("Süd");
	
	Schaf schaf1 = new Schaf("Wolle", 3, 5.0, "A");
	Schaf schaf2 = new Schaf("Flausch", 2, 4.2, "B");
	
	Pferd pferd1 = new Pferd("Blitz", 5, true);
	Pferd pferd2 = new Pferd("Sonne", 7, false);
	
	Huhn huhn1 = new Huhn("Clara", 1, 20);
	Huhn huhn2 = new Huhn("Lilly", 2, 18);
	
	Pute pute1 = new Pute("Gina", 3, 15.5);
	Pute pute2 = new Pute("Mona", 4, 16.2);
	
	hof.addTier("Nord", schaf1);
	hof.addTier("Nord", pferd1);
	hof.addTier("Nord", huhn1);
	
	hof.addTier("Süd", schaf2);
	hof.addTier("Süd", pferd2);
	hof.addTier("Süd", huhn2);
	hof.addTier("Süd", pute1);
	hof.addTier("Süd", pute2);
	
	System.out.println("Alle Ställe: " + hof.getAllStallNames());
	
	System.out.println("Alle Federvieh:");
	for (Federvieh f : hof.getAllFedervieh()) {
		System.out.println("- " + f.kosename() + ", ID=" + f.ID());
	}
	
	System.out.println("Alle Paarhufer:");
	for (Paarhufer p : hof.getAllPaarhufer()) {
		System.out.println("- " + p.kosename() + ", ID=" + p.ID());
	}
	
	System.out.println("\nTransfer Schaf1 from Nord to Süd...");
	hof.transferTier(schaf1, "Nord", "Süd");
	
	System.out.println("Federvieh in Nord: " + hof.getStall("Nord").getFederviehList().size());
	System.out.println("Paarhufer in Nord: " + hof.getStall("Nord").getPaarhuferList().size());
	
	System.out.println("Federvieh in Süd: " + hof.getStall("Süd").getFederviehList().size());
	System.out.println("Paarhufer in Süd: " + hof.getStall("Süd").getPaarhuferList().size());
	
	System.out.println("\nRemove Huhn1 from Nord...");
	hof.removeTier("Nord", huhn1);
	
	System.out.println("Federvieh in Nord after removal: " + hof.getStall("Nord").getFederviehList().size());
	
	System.out.println("\nFlush all Tiere...");
	hof.clearAllTiere();
	System.out.println("Federvieh in Nord after flush: " + hof.getStall("Nord").getFederviehList().size());
	System.out.println("Paarhufer in Süd after flush: " + hof.getStall("Süd").getPaarhuferList().size());

}
