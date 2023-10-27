import java.util.List;

public class Banka {
    private Long brojRacuna;
    protected List<Korisnik> korisnici;
    protected List<Uposlenik> uposlenici;

    Banka() {
        brojRacuna = 0l;
    }
    public Korisnik kreirajNovogKorisnika(String ime, String prezime) {
        Korisnik k = new Korisnik(ime, prezime);
        korisnici.add(k);
        return k;
    }
    public Uposlenik kreirajNovogUposlenika(String ime, String prezime) {
        Uposlenik k = new Uposlenik(ime, prezime);
        uposlenici.add(k);
        return k;
    }
    public Racun kreirajRacunZaKorisnika(Korisnik k) {
        Racun r = new Racun(brojRacuna, k);
        k.dodajRacun(r);
        return r;
    }
}
