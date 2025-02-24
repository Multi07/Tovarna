public class SkladSurovin {
    private int plast=10000;
    private int vlasy=1000;
    private int karton=600;

    public synchronized boolean uberPlast(int cislo) {
        if (plast >= cislo) {
            plast-=cislo;
            return true;
        }
        return false;
        }
    public synchronized boolean uberVlasy(int cislo) {
        if (vlasy >= cislo) {
            vlasy-=cislo;
            return true;
        }
        return false;
    }
    public synchronized boolean uberKarton(int cislo) {
        if (karton >= cislo) {
            karton-=cislo;
            return true;
        }
        return false;
    }
    public void pridejVlasy(int cislo) {this.vlasy+=cislo;}
    public void pridejPlast(int cislo) {this.plast+=cislo;}
    public void pridejKarton(int cislo) {this.karton+=cislo;}

    public int getPlast() {
        return plast;
    }

    public int getVlasy() {
        return vlasy;
    }

    public int getKarton() {
        return karton;
    }
}

