import java.util.ArrayList;
import java.util.List;

public class Stall {
	private final List<Federvieh> federviehList =  new ArrayList<>();
	private final List<Paarhufer> paarhuferList = new ArrayList<>();
	
	private String _name;
	
	public Stall(){
		_name = null;
	}
	
	public void setName(String name) {
		if(_name == null){
			_name = name;
		}
	}
	
	public boolean addTier(Tier t){
		if(t instanceof Federvieh){
			federviehList.add((Federvieh)t);
			return true;
		}
		else if(t instanceof Paarhufer){
			paarhuferList.add((Paarhufer) t);
			return true;
		}
		return false;
	}
	public boolean removeTier(Tier t){
		if(t instanceof Federvieh){
			federviehList.remove((Federvieh)t);
			return true;
		}
		else if(t instanceof Paarhufer){
			paarhuferList.remove((Paarhufer) t);
			return true;
		}
		return false;
	}
	public List<Federvieh> getFederviehList() {
		return federviehList;
	}
	public List<Paarhufer> getPaarhuferList() {
		return paarhuferList;
	}
	public boolean flush(){
		federviehList.clear();
		paarhuferList.clear();
		if(federviehList.isEmpty() && paarhuferList.isEmpty()){
			return true;
		}
		return false;
	}
	public boolean flushPaarhufer(){
		paarhuferList.clear();
		if(paarhuferList.isEmpty()){
			return true;
		}
		return false;
	}
	public boolean flushFedervieh(){
		federviehList.clear();
		if(federviehList.isEmpty()){
			return true;
		}
		return false;
	}
	public boolean exists(Tier t){
		if(t instanceof Federvieh){
			return federviehList.contains((Federvieh)t);
		}
		else if(t instanceof Paarhufer){
			return paarhuferList.contains((Paarhufer) t);
		}
		return false;
	}
	public int getAnzahlFedervieh(){
		return federviehList.size();
	}
	public int getAnzahlPaarhufer(){
		return paarhuferList.size();
	}
	
	
	
	
}
