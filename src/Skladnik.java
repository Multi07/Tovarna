import java.util.Random;

public class Skladnik extends Delnik {
    private int pocet_Panenek;
    public Skladnik(String name1, SkladSurovin sklad, SkladSoucastek skladSoucastek, int pocet_Panenek) {
        super(name1, sklad, skladSoucastek);
        this.pocet_Panenek = pocet_Panenek;
    }
    Random rand = new Random();
    int rand_int1 = rand.nextInt(1000);
    int rand_int2 = rand.nextInt(100);

    @Override
    public void run() {
        while (super.getSkladSoucastek().getPanenka()<pocet_Panenek) {
            System.out.println("Skladník " + super.getName1() + " Zajel pro materiál");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("--------------------------------------------------------");
            System.out.println("Skladník " + super.getName1() + " se vrátil s materiálem");
            System.out.println("--------------------------------------------------------");
            super.getSklad().pridejPlast(rand_int1);
            super.getSklad().pridejVlasy(rand_int2);
        }
    }
}