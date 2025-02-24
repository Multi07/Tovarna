import java.util.Random;

public class BaliciStanice extends Delnik {
    private final int pocet_Panenek;
    private int pocet_Zabalenych;
    Random rand = new Random();
    private int pauza=0;
    int rand_int1 = rand.nextInt(1000);
    int rand_int2 = rand.nextInt(100);
    private final int Pocet_Kartonu =10;

    public BaliciStanice(String name1, SkladSurovin sklad, SkladSoucastek skladSoucastek, int pocet_Panenek) {
        super(name1, sklad, skladSoucastek);
        this.pocet_Panenek = pocet_Panenek;
    }

    public int getPocet_Zabalenych() {
        return pocet_Zabalenych;
    }

    @Override
    public void run() {
        while (super.getSkladSoucastek().getPanenka()<pocet_Panenek) {
            if (pocet_Zabalenych % 3 == 0 && pocet_Zabalenych > 0 && pauza<1) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(super.getName1() + " si dává pauzu");
                pauza++;
            }
            else {
                pauza=0;
                if (super.getSklad().uberKarton(Pocet_Kartonu)) {
                    System.out.println("Balící Stanice " + super.getName1() + " začíná balit panenku");
                    super.getSkladSoucastek().ZabalPanenku();
                    System.out.println("Balící Stanice " + super.getName1() + " Zabalil Panenku");
                    pocet_Zabalenych++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Výrobce rukou čeká na Materiál");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("--------------------------------------------------------");
                System.out.println("Skladník " + super.getName1() + " se vrátil s materiálem");
                System.out.println("--------------------------------------------------------");
                super.getSklad().pridejPlast(rand_int1);
                super.getSklad().pridejVlasy(rand_int2);
            }
        }
    }
}