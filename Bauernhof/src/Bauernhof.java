import java.util.*;

public class Bauernhof {
	
	private final Map<String, Stall> staelle = new HashMap<>();
	
	// Stall hinzufügen (erstellt Stall automatisch)
	public boolean addStall(String name) {
		if (name == null || staelle.containsKey(name)) return false;
		
		Stall stall = new Stall();
		stall.setName(name);
		staelle.put(name, stall);
		return true;
	}
	
	// Tier zu einem Stall hinzufügen
	public boolean addTier(String stallName, Tier tier) {
		Stall stall = staelle.get(stallName);
		if (stall == null || tier == null) return false;
		
		return stall.addTier(tier);
	}
	
	// Tier von einem Stall entfernen
	public boolean removeTier(String stallName, Tier tier) {
		Stall stall = staelle.get(stallName);
		if (stall == null || tier == null) return false;
		
		return stall.removeTier(tier);
	}
	
	// Tier von einem Stall zu einem anderen verschieben
	public boolean transferTier(Tier tier, String from, String to) {
		if (tier == null || from == null || to == null || from.equals(to)) return false;
		
		Stall source = staelle.get(from);
		Stall target = staelle.get(to);
		
		if (source == null || target == null || !source.exists(tier)) return false;
		
		source.removeTier(tier);
		return target.addTier(tier);
	}
	
	// Alle Tiere aus allen Ställen löschen
	public void clearAllTiere() {
		staelle.values().forEach(Stall::flush);
	}
	
	// Alle Federvieh Tiere abrufen
	public List<Federvieh> getAllFedervieh() {
		List<Federvieh> result = new ArrayList<>();
		for (Stall stall : staelle.values()) {
			for (Tier t : stall.getFederviehList()) {
				if (t instanceof Federvieh f) result.add(f);
			}
		}
		return result;
	}
	
	// Alle Paarhufer Tiere abrufen
	public List<Paarhufer> getAllPaarhufer() {
		List<Paarhufer> result = new ArrayList<>();
		for (Stall stall : staelle.values()) {
			for (Tier t : stall.getPaarhuferList()) {
				if (t instanceof Paarhufer p) result.add(p);
			}
		}
		return result;
	}
	
	// Optional: alle Stallnamen abrufen
	public List<String> getAllStallNames() {
		return new ArrayList<>(staelle.keySet());
	}
	
	// Prüfen, ob ein Stall existiert
	public boolean hasStall(String name) {
		return staelle.containsKey(name);
	}
	public Stall getStall(String name) {
		return staelle.get(name);
	}
}
