public class Mischpult implements ITransportierbar{

	private int _anzahlKanaele;
	
	private int _transportgewicht;
	
	public Mischpult(int anzahlKanaele){
		_anzahlKanaele = anzahlKanaele;
	}
	public int getAnzahlKanaele(){
		return _anzahlKanaele;
	}
	public void setAnzahlKanaele(int anzahlKanaele){
		_anzahlKanaele = anzahlKanaele;
	}
	
	@Override
	public int getTransportGewicht(){
		return _transportgewicht;
	}
	

}
