import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StallTest {
	
	private Stall stall;
	
	@BeforeEach
	void setUp() {
		stall = new Stall();
		stall.setName("TestStall");
	}
	
	@Test
	void testAddFedervieh() {
		assertEquals(0, stall.getAnzahlFedervieh());
		
		Huhn h = new Huhn("Chickong", 2, 20);
		assertTrue(stall.addTier(h));
		
		assertEquals(1, stall.getAnzahlFedervieh());//weil vielleicht gibts duplikate wenn schlecht gecoded
		assertTrue(stall.getFederviehList().contains(h));
	}
	
	@Test
	void testAddPaarhufer() {
		Schaf s = new Schaf("Wolle", 3, 5.0, "A");
		
		assertTrue(stall.addTier(s));
		assertEquals(1, stall.getAnzahlPaarhufer());
		assertTrue(stall.getPaarhuferList().contains(s));
	}
	
	@Test
	void testRemoveTier() {
		Huhn h = new Huhn("Test", 1, 10);
		stall.addTier(h);
		
		assertTrue(stall.removeTier(h));
		assertEquals(0, stall.getAnzahlFedervieh());
	}
	
	@Test
	void testExists() {
		Schaf s = new Schaf("Flausch", 2, 4.2, "B");
		
		assertFalse(stall.exists(s));
		stall.addTier(s);
		assertTrue(stall.exists(s));
	}
	
	@Test
	void testFlush() {
		stall.addTier(new Huhn("A", 1, 10));
		stall.addTier(new Schaf("B", 2, 4.0, "X"));
		
		assertTrue(stall.flush());
		assertEquals(0, stall.getAnzahlFedervieh());
		assertEquals(0, stall.getAnzahlPaarhufer());
	}
}
