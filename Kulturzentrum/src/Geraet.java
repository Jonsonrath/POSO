public abstract class Geraet {
	
	protected String _inventarnummer;
	protected double _gewicht;
	protected double _stromverbrauch;
	protected String _kategorie;
	
	protected void setKategorie(){
		_kategorie = "Geraet";
	}
	public String getKategorie(){
		return _kategorie;
	}
	public String getInventarnummer(){
		return _inventarnummer;
	}
	public String getBeschreibung(){
		return _inventarnummer + _kategorie + _gewicht + _stromverbrauch;
	}
	public double getGewicht(){
		return _gewicht;
	}
	public double getStromverbrauch(){
		return _stromverbrauch;
	}
	public void setGewicht(double gewicht){
		_gewicht = gewicht;
	}
	public void setStromverbrauch(double stromverbrauch){
		_stromverbrauch = stromverbrauch;
	}
	public void setInventarnummer(String inventarnummer){
		_inventarnummer = inventarnummer;
	}
	
	
}
