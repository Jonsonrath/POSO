public class Lautsprecher extends Geraet implements ITransportierbar, IReservierbar{

	private double _maximaleLautstaerke;
	private String _eventname;
	private int _transportgewicht;
	
	
	public Lautsprecher(double maximaleLautstaerke){
		_maximaleLautstaerke = maximaleLautstaerke;
	}
	public double getMaximaleLautstaerke(){
		return _maximaleLautstaerke;
	}
	public void setMaximaleLautstaerke(double lautstaerke){
		_maximaleLautstaerke = lautstaerke;
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
	public int getTransportGewicht(){
		return _transportgewicht;
	}

}
