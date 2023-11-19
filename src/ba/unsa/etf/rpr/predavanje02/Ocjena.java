package ba.unsa.etf.rpr.predavanje02;

public class Ocjena {
    private LicneInformacije osoba;
    private int ocjena;

    Ocjena(LicneInformacije osoba, int ocjena) {
        this.osoba = osoba;
        setOcjena(ocjena);
    }
    public void setOcjena(int ocjena) throws IllegalArgumentException {
        if (ocjena > 0 && ocjena <= 10) {
            this.ocjena = ocjena;
        } else {
            throw new IllegalArgumentException("Ocjena mora biti izmedju 1 i 10!");
        }
    }
    public int getOcjena() {
        return ocjena;
    }
}
