package ba.unsa.etf.rpr.predavanje02;

import java.util.List;
import java.util.ArrayList;

public class KolekcijaPoruka {
    private List<String> poruke = new ArrayList<String>();

    KolekcijaPoruka(List<?> kolekcija) {
        for (Object x : kolekcija) {
            if (x instanceof Predstavljivo) {
                poruke.add(((Predstavljivo) x).predstavi());
            }
        }
    }
    public List<String> getPoruke() {
        return poruke;
    }

}
