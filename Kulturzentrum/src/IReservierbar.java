public interface IReservierbar {
	void reservieren(String eventname);
	boolean istReserviert();
	void clearReserviert();
	
	
}
