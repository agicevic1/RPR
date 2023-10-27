public class Racun {
    protected Long brojRacuna;
    protected Osoba korisnikRacuna;
    protected boolean odobrenjePrekoracenja;
    protected Double stanjeRacuna;
    Racun (Long brojRacuna, Osoba korisnikRacuna) {
        this.brojRacuna = brojRacuna;
        this.korisnikRacuna = korisnikRacuna;
        odobrenjePrekoracenja = false;
        stanjeRacuna = 0.;
    }
    private boolean provjeriOdobrenjePrekoracenja(Double isplata) {
        return stanjeRacuna >= isplata || odobrenjePrekoracenja;
    }
    public boolean izvrsiUplatu(Double uplata) {
        stanjeRacuna = stanjeRacuna + uplata;
        return stanjeRacuna >= 0;
    }
    public boolean izvrsiIsplatu(Double isplata) {
        if(provjeriOdobrenjePrekoracenja(isplata))
            return false;
        return true;
    }
    public void odobriPrekoracenje() {
        odobrenjePrekoracenja = true;
    }
}
