public abstract class Kuenstler {
	protected String _name;
	protected int _alter;
	protected String _typ;
	
	public Kuenstler(String name, int alter) {
		_name = name;
		_alter = alter;
		setTyp();
	}
	
	public String getTyp(){
		return _typ;
	}
	protected void setTyp(){
		_typ = "";
	}
	
	public String getName() {
		return _name;
	}
	public int getAlter() {
		return _alter;
	}
	public String getBeschreibung(){
		return _name + _alter;
	}
	
	
}
