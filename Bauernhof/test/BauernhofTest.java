import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BauernhofTest {
	
	private Bauernhof hof;
	
	@BeforeEach
	void setUp() {
		hof = new Bauernhof();
		hof.addStall("Nord");
		hof.addStall("Süd");
	}
	
	@Test
	void testAddStall() {
		assertTrue(hof.addStall("West"));
		assertFalse(hof.addStall("West")); // doppelt
		assertFalse(hof.addStall(null));
	}
	
	@Test
	void testAddTier() {
		Huhn h = new Huhn("Clara", 1, 20);
		
		assertTrue(hof.addTier("Nord", h));
		assertFalse(hof.addTier("Unbekannt", h));
		assertFalse(hof.addTier("Nord", null));
	}
	
	@Test
	void testTransferTier() {
		Schaf s = new Schaf("Wolle", 3, 5.0, "A");
		
		hof.addTier("Nord", s);
		
		assertTrue(hof.transferTier(s, "Nord", "Süd"));
		assertEquals(0, hof.getStall("Nord").getAnzahlPaarhufer());
		assertEquals(1, hof.getStall("Süd").getAnzahlPaarhufer());
	}
	
	@Test
	void testRemoveTier() {
		Huhn h = new Huhn("Lilly", 2, 18);
		hof.addTier("Nord", h);
		
		assertTrue(hof.removeTier("Nord", h));
		assertEquals(0, hof.getStall("Nord").getAnzahlFedervieh());
	}
	
	@Test
	void testGetAllFedervieh() {
		hof.addTier("Nord", new Huhn("A", 1, 10));
		hof.addTier("Süd", new Pute("B", 2, 15));
		
		assertEquals(2, hof.getAllFedervieh().size());
	}
	
	@Test
	void testClearAllTiere() {
		hof.addTier("Nord", new Huhn("A", 1, 10));
		hof.addTier("Süd", new Schaf("B", 2, 4.0, "X"));
		
		hof.clearAllTiere();
		
		assertEquals(0, hof.getStall("Nord").getAnzahlFedervieh());
		assertEquals(0, hof.getStall("Süd").getAnzahlPaarhufer());
	}
}
