public interface Transportierbar extends Comparable<Transportierbar> {

    float MAX_GEWICHT_PRO_FLAECHE = 29.99F;



    float gewicht();
    float laenge();
    float breite();
    float hoehe();


    boolean zerbrlich();
    String beschriftung();

    @Override
    default int compareTo(Transportierbar other) {
        return Float.compare(this.gewicht(), other.gewicht());
    }




}
