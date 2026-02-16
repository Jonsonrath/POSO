public class Taenzer extends Kuenstler implements ITransportierbar{
	
	private int _transportgewicht;
	private String _tanzstil;
	
	public Taenzer(String name, int alter, String tanzstil){
		super(name, alter);
		_tanzstil = tanzstil;
	}
	@Override
	public String getBeschreibung(){
		return _name + _alter + _tanzstil;
	}
	@Override
	protected void setTyp(){
		_typ = "Taenzer";
	}
	@Override
	public int getTransportGewicht(){
		return _transportgewicht;
	}
	
	
}
