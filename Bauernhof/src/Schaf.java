public class Schaf implements Paarhufer, Bezeichenbar{
	
	private String _kosename;
	private int _alter;
	private double _wollvollumen;
	private String _Markierung;
	private static int Anzahl = 0;
	private int ID;
	
	public Schaf(String kosename, int alter, double wollvollumen, String Markierung) {
		_kosename = kosename;
		_alter = alter;
		_wollvollumen = wollvollumen;
		_Markierung = Markierung;
		ID = Anzahl;
		Anzahl++;
		
	}
	
	
	public String kosename() {
		return _kosename;
	}
	public int alter() {
		return _alter;
	}
	public double wollvollumen() {
		return _wollvollumen;
	}
	public String Markierung() {
		return _Markierung;
	}
	public static int getAnzahl() {
		return Anzahl;
	}
	
	public String getBezeichnung() {
		return ID + _kosename + _alter + _wollvollumen + _Markierung;
	}
	
	public int ID() {
		return ID;
	}
	
	
	
	
}
