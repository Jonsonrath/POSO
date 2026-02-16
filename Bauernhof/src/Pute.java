public class Pute implements Federvieh, Bezeichenbar{
	private String _kosename;
	private int _alter;
	private double  _gewicht;
	
	private static int Anzahl = 0;
	private int ID;
	
	public Pute(String kosename, int alter, double gewicht) {
		_kosename = kosename;
		_alter = alter;
		_gewicht = gewicht;
		
		ID = Anzahl;
		Anzahl++;
		
	}
	public String kosename() {
		return _kosename;
	}
	public int alter() {
		return _alter;
	}
	public double getGewicht() {
		return _gewicht;
	}
	public static int getAnzahl() {
		return Anzahl;
	}
	public String getBezeichnung() {
		return ID + _kosename + _alter + _gewicht;
	}
	public int ID() {
		return ID;
	}
	
}
