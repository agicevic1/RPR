package ba.unsa.etf.rpr.predavanje02;

public class Sat {

    private int sati;
    private int minute;
    private int sekunde;

    public Sat(int sati, int minute, int sekunde) {
        this.postavi(sati, minute, sekunde);
    }

    public void postavi(int sati, int minute, int sekunde) {
        this.sati = sati;
        this.minute = minute;
        this.sekunde = sekunde;
    }

    public void sledeci() {
        this.sekunde++;
        if (this.sekunde == 60) {
            this.sekunde = 0;
            this.minute++;
        }
        if (this.minute == 60) {
            this.minute = 0;
            this.sati++;
        }
        if (this.sati == 24) {
            this.sati = 0;
        }
    }

    public void prethodni() {
        this.sekunde--;
        if (this.sekunde == -1) {
            this.sekunde = 59;
            this.minute--;
        }
        if (this.minute == -1) {
            this.minute = 59;
            this.sati--;
        }
        if (this.sati == -1) {
            this.sati = 23;
        }
    }

    public void pomjeriZa(int sekunde) {
        if (sekunde > 0) {
            for (int i = 0; i < sekunde; i++) {
                this.sledeci();
            }
        } else {
            for (int i = 0; i < -sekunde; i++) {
                this.prethodni();
            }
        }
    }

    public int dajSate() {
        return this.sati;
    }

    public int dajMinute() {
        return this.minute;
    }

    public int dajSekunde() {
        return this.sekunde;
    }

    @Override
    public String toString() {
        return this.sati+":"+this.minute+":"+this.sekunde;
    }

    public static void main(String[] args) {
        Sat s = new Sat(15,30,45);
        System.out.println(s);
        s.sledeci();
        System.out.println(s);
        s.pomjeriZa(-48);
        System.out.println(s);
        s.postavi(0,0,0);
        System.out.println(s);
    }
}
