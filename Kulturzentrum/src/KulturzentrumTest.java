import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class KulturzentrumTest {
	
	private Kulturzentrum kulturzentrum;
	
	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		
		kulturzentrum = new Kulturzentrum();
		
		Scheinwerfer s1 = new Scheinwerfer(20.2);
		Scheinwerfer s2 = new Scheinwerfer(22.2);
		
		Musiker m1 = new Musiker("Musiker1", 18, "ukulele");
		Musiker m2 = new Musiker("Musiker2", 28, "gitarre");
		
		Taenzer t1 = new Taenzer("Taenzer1", 8, "KeineAhnung");
		Taenzer t2 = new Taenzer("Taenzer2", 18, "KeineAhnung");
		
		Schauspieler sch1 = new Schauspieler("Schauspieler1", 19, "Schauspielkategorie1");
		Schauspieler sch2 = new Schauspieler("Schauspieler2", 19, "Schauspielkategorie2");
		
		kulturzentrum.add(s1);
		kulturzentrum.add(s2);
		kulturzentrum.add(m1);
		kulturzentrum.add(m2);
		kulturzentrum.add(t1);
		kulturzentrum.add(t2);
		kulturzentrum.add(sch1);
		kulturzentrum.add(sch2);
		
	}
	
	@Test
	void add() {
		int beforeTotal = kulturzentrum.getKuenstlerListe().size()
				+ kulturzentrum.getGeraetListe().size();
		
		Lautsprecher l = new Lautsprecher(60);
		kulturzentrum.add(l);
		
		assertTrue(kulturzentrum.exists(l));
		
		int afterTotal = kulturzentrum.getKuenstlerListe().size()
				+ kulturzentrum.getGeraetListe().size();
		
		assertEquals(beforeTotal + 1, afterTotal);
	}
	
	@Test
	void remove() {
		Kuenstler k = kulturzentrum.getKuenstlerListe().get(0);
		
		assertTrue(kulturzentrum.exists(k));
		
		kulturzentrum.remove(k);
		
		assertFalse(kulturzentrum.exists(k));
	}
	
	@Test
	void exists() {
		Kuenstler k = kulturzentrum.getKuenstlerListe().get(0);
		assertTrue(kulturzentrum.exists(k));
		
		Lautsprecher l = new Lautsprecher(100);
		assertFalse(kulturzentrum.exists(l));
	}
	
	
	@Test
	void getAllBewertbar() {
		var bewertbar = kulturzentrum.getAllBewertbar();
		assertNotNull(bewertbar);
		assertFalse(bewertbar.isEmpty());
	}
	
	
	@Test
	void getAllTransportierbar() {
		var transportierbar = kulturzentrum.getAllTransportierbar();
		assertNotNull(transportierbar);
		assertFalse(transportierbar.isEmpty());
	}
	
	
	@Test
	void getAllReservierbar() {
		var reservierbar = kulturzentrum.getAllReservierbar();
		assertNotNull(reservierbar);
		assertFalse(reservierbar.isEmpty());
	}
	
	
	
	@Test
	void sortByName() {
		kulturzentrum.sortByName();
		
		var liste = kulturzentrum.getKuenstlerListe();
		
		for (int i = 0; i < liste.size() - 1; i++) {
			assertTrue(liste.get(i).getName()
					.compareTo(liste.get(i + 1).getName()) <= 0);
		}
	}
	
	
	@Test
	void sortByGewicht() {
		kulturzentrum.sortByGewicht();
		
		var liste = kulturzentrum.getGeraetListe();
		
		for (int i = 0; i < liste.size() - 1; i++) {
			assertTrue(liste.get(i).getGewicht()
					<= liste.get(i + 1).getGewicht());
		}
	}
	
	
	@Test
	void reserveByEvent() {
		
		Musiker m = new Musiker("name", 127,"instrument");
		
		kulturzentrum.add(m);
		
		kulturzentrum.reserveByEvent(m, "Eventname");
		
		var reservierbar = kulturzentrum.getAllReservierbar();
		
		int index = reservierbar.indexOf(m);
		
		assertTrue(reservierbar.get(index).istReserviert());
		
	}
	
	
	@Test
	void getBewertungen() {
		Musiker m = new Musiker("name", 121,"instrument");
		
		kulturzentrum.add(m);
		
		var bewertungen = kulturzentrum.getBewertungen();
		
		assertNotNull(bewertungen);
		assertEquals(3, bewertungen.length);
		
		assertNotNull(bewertungen[0]);
		assertNotNull(bewertungen[1]);
	}
	
}