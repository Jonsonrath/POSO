public interface Tier extends Comparable<Tier> {
	String kosename();
	int alter();
	int ID();
	
	@Override
	default int compareTo(Tier other) {
		return Integer.compare(this.alter(), other.alter());
	}
}
