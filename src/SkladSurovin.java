public class SkladSurovin {
    private int plast=10000;
    private int vlasy=1000;

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
    public void pridejVlasy(int cislo) {this.vlasy+=cislo;}
    public void pridejPlast(int cislo) {this.plast+=cislo;}

    public int getPlast() {
        return plast;
    }

    public int getVlasy() {
        return vlasy;
    }
}

