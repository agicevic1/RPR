public class Korisnik extends Osoba{
    protected Racun racun;
    Korisnik(String ime, String prezime) {
        super(ime, prezime);
    }
    public void dodajRacun(Racun racun) {
        this.racun = racun;
    }
}
