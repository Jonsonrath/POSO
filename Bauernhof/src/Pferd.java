public class Pferd implements Paarhufer {
	
	private String _kosename;
	private int _alter;
	private boolean _Hufeisen;
	private String _Markierung;
	private static int Anzahl = 0;
	private int ID;
	
	public Pferd(String kosename, int alter, boolean Hufeisen) {
		_kosename = kosename;
		_alter = alter;
		_Hufeisen = Hufeisen;
		ID = Anzahl;
		Anzahl++;
		
	}
	
	public String kosename() {
		return _kosename;
	}
	
	public int alter() {
		return _alter;
	}
	public boolean  Hufeisen() {
		return _Hufeisen;
	}
	
	public String Markierung() {
		return _Markierung;
	}
	public static int getAnzahl() {
		return Anzahl;
	}
	public int ID() {
		return ID;
	}
}
