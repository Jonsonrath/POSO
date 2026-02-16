import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TierTest {
	
	@Test
	void testCompareTo() {
		Huhn jung = new Huhn("Jung", 1, 10);
		Huhn alt = new Huhn("Alt", 5, 15);
		
		assertTrue(jung.compareTo(alt) < 0);
		assertTrue(alt.compareTo(jung) > 0);
		assertEquals(0, jung.compareTo(new Huhn("X", 1, 5)));
	}
}
