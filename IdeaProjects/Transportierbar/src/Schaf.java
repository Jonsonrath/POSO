public class Schaf implements Transportierbar{
    private String _kennzeichnung;
    private Boolean _zerbrechlich;
    private float _gewicht;
    private float _laenge;
    private float _breite;
    private float _hoehe;

    public Schaf(String kennzeichnung, Boolean zerbrechlich, float gewicht, float laenge, float breite, float hoehe) {
        _kennzeichnung = kennzeichnung;
        _zerbrechlich = zerbrechlich;
        _gewicht = gewicht;
        _laenge = laenge;
        _breite = breite;
        _hoehe = hoehe;
    }
    @Override
    public float gewicht() {
        return _gewicht;
    }
    @Override
    public float laenge() {
        return _laenge;
    }
    @Override
    public float breite() {
        return _breite;
    }
    @Override
    public float hoehe() {
        return _hoehe;
    }
    @Override
    public boolean zerbrlich() {
        return _zerbrechlich;
    }
    @Override
    public String beschriftung() {
        return _kennzeichnung;
    }
}
