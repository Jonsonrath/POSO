import java.util.ArrayList;
import java.util.List;

public class Schauspieler extends Kuenstler implements IReservierbar, IBewertbar{
	private String _spezialgebiet;
	private String _eventname;
	private List<Integer> _bewertungen;
	
	public Schauspieler(String name, int alter, String spezialgebiet){
		super(name, alter);
		_spezialgebiet = spezialgebiet;
		_bewertungen = new ArrayList<Integer>();
	}
	@Override
	public String getBeschreibung(){
		return _name + _alter + _spezialgebiet;
	}
	@Override
	protected void setTyp(){
		_typ = "Kuenstler";
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
}
