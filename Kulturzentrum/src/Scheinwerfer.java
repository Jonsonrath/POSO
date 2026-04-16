import java.util.ArrayList;
import java.util.List;

public class Scheinwerfer extends Geraet implements IReservierbar, IBewertbar{

	private double _lumen;
	private String _eventname;
	private List<Integer> _bewertungen;
	
	public Scheinwerfer(double lumen){
		_lumen = lumen;
		_bewertungen = new ArrayList<Integer>();
	}
	public void setLumen(double lumen){
		_lumen = lumen;
	}
	public double getLumen(){
		return _lumen;
	}
	
	@Override
	public void reservieren(String eventname) {
		_eventname = eventname;
	}
	
	@Override
	public boolean istReserviert() {
		return _eventname != null;
	}
	
	@Override
	public void clearReserviert() {
		_eventname = null;
	}
	
	@Override
	public void addBewertung(int bewertung) {
		_bewertungen.add(bewertung);
	}
	
	public Integer getBewertung(int index) {
		return _bewertungen.get(index);
	}
	@Override
	public double getDurchschnitt(){
		double durchschnitt = 0;
		for(Integer bewertung : _bewertungen){
			durchschnitt += bewertung;
		}
		durchschnitt /= _bewertungen.size();
		return durchschnitt;
	}
	public List<Integer> getBewertungen() {
		return _bewertungen;
	}

}
