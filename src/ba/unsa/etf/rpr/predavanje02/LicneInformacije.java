package ba.unsa.etf.rpr.predavanje02;

public class LicneInformacije {
    private String ime, prezime;

    LicneInformacije(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    public String getIme() {
        return ime;
    }
    public String getPrezime() {
        return prezime;
    }
}
