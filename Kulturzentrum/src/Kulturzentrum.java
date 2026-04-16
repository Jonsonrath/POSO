import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kulturzentrum {

	private List<Kuenstler> _kuenstlerListe;
	private List<Geraet> _geraetListe;
	
	public Kulturzentrum(){
		_kuenstlerListe = new ArrayList<>();
		_geraetListe = new ArrayList<>();
	}
	
	public void add(Kuenstler k){
		_kuenstlerListe.add(k);
	}
	public void add(Geraet g){
		_geraetListe.add(g);
	}
	public void remove(Kuenstler k){
		_kuenstlerListe.remove(k);
	}
	public void remove(Geraet g){
		_geraetListe.remove(g);
	}
	public boolean exists(Kuenstler k){
		return _kuenstlerListe.contains(k);
	}
	public boolean exists(Geraet g){
		return _geraetListe.contains(g);
	}
	public List<Kuenstler> getKuenstlerListe(){return _kuenstlerListe;}
	public List<Geraet> getGeraetListe(){return _geraetListe;}
	
	public List<IBewertbar> getAllBewertbar(){
		List<IBewertbar> bewertbarListe = new ArrayList<>();
		for(Kuenstler k : _kuenstlerListe){
			if(k instanceof IBewertbar){
				bewertbarListe.add((IBewertbar)k);
			}
		}
		for(Geraet g : _geraetListe){
			if(g instanceof IBewertbar){
				bewertbarListe.add((IBewertbar)g);
			}
		}
		return bewertbarListe;
	}
	
	public List<ITransportierbar> getAllTransportierbar(){
		List<ITransportierbar> transportierbarListe = new ArrayList<>();
		for(Kuenstler k : _kuenstlerListe){
			if(k instanceof ITransportierbar){
				transportierbarListe.add((ITransportierbar)k);
			}
		}
		for(Geraet g : _geraetListe){
			if(g instanceof ITransportierbar){
				transportierbarListe.add((ITransportierbar)g);
			}
		}
		return transportierbarListe;
	}
	
	public List<IReservierbar> getAllReservierbar(){
		List<IReservierbar> reservierbarListe = new ArrayList<>();
		for(Kuenstler k : _kuenstlerListe){
			if(k instanceof IReservierbar){
				reservierbarListe.add((IReservierbar)k);
			}
		}
		for(Geraet g : _geraetListe){
			if(g instanceof IReservierbar){
				reservierbarListe.add((IReservierbar)g);
			}
		}
		return reservierbarListe;
	}
	
	public void sortByName(){
		Collections.sort(_kuenstlerListe);
	}
	public void sortByGewicht(){
		Collections.sort(_geraetListe);
	}
	
	public boolean reserveByEvent(IReservierbar reservierbar, String eventName){
		if(_geraetListe.contains(reservierbar) || _kuenstlerListe.contains(reservierbar)){
			reservierbar.reservieren(eventName);
			return true;
		}
		
		return false;
	}
	
	public List<List<Integer>>[] getBewertungen(){
		List<List<Integer>>[] bewertungen = new ArrayList[3];
		
		bewertungen[0] = new ArrayList<>();//für kuenstler
		bewertungen[1] = new ArrayList<>();//für gereate
		
		
		
		for(Kuenstler k : _kuenstlerListe){
			if(k instanceof IBewertbar){
				IBewertbar b = (IBewertbar)k;
				bewertungen[0].add(b.getBewertungen());
			}
		}
		for(Geraet g : _geraetListe){
			if(g instanceof IBewertbar){
				IBewertbar b = (IBewertbar)g;
				bewertungen[1].add(b.getBewertungen());
			}
		}
		
		return  bewertungen;
	}

}
