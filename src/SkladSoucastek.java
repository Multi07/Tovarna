import java.util.Random;

public class SkladSoucastek {
    private int hlava =0;
    private int telo=0;
    private int ruka=0;
    private int noha=0;
    private int panenka;

    public void VytvorHlavu() {
        hlava++;
    }
    public void VytvorTelo() {
        telo++;
    }
    public void VytvorRuka() {
        ruka++;
    }
    public void VytvorNoha() {
        noha++;
    }
    public synchronized boolean Vytvorpanenku() {
        if (hlava >=1 && telo >=1 && ruka >=1 && noha >=1) {
            hlava--;
            telo--;
            ruka--;
            noha--;
            panenka++;
            return true;
        }
        return false;
    }

    public synchronized int Kontrola() {
        return panenka/4;
    }

    public synchronized int getPanenka() {
        return panenka;
    }
}