public class Huhn implements Federvieh, Bezeichenbar{
	private String _kosename;
	private int _alter;
	private int _eiProMonat;
	
	private static int Anzahl = 0;
	private int ID;
	
	public Huhn(String kosename, int alter, int eiProMonat) {
		_kosename = kosename;
		_alter = alter;
		_eiProMonat = eiProMonat;
		
		ID = Anzahl;
		Anzahl++;
		
	}
	@Override
	public String kosename() {
		return _kosename;
	}
	@Override
	public int alter() {
		return _alter;
	}
	public int getEiProMonat() {
		return _eiProMonat;
	}
	public static int getAnzahl() {
		return Anzahl;
	}
	
	public String getBezeichnung() {
		return ID + _kosename + _alter + _eiProMonat;
	}
	public int ID(){
		return ID;
	}
	
}
