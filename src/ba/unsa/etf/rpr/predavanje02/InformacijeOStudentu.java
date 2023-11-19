package ba.unsa.etf.rpr.predavanje02;

public class InformacijeOStudentu extends LicneInformacije implements MozeOcijeniti {
    private String godinaStudija;
    private String brojIndexa;

    InformacijeOStudentu(String ime, String prezime, String godinaStudija, String brojIndexa) {
        super(ime, prezime);
        this.godinaStudija = godinaStudija;
        this.brojIndexa = brojIndexa;
    }
    @Override
    public Ocjena ocijeni(int ocjena) {
        Ocjena o = new Ocjena(this, ocjena);
        return o;
    }
    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }
    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }
    public String getGodinaStudija() {
        return godinaStudija;
    }
    public String getBrojIndexa() {
        return brojIndexa;
    }
}
