import java.util.Random;

public class DHlava extends Delnik {
    private final int pocet_Panenek;
    private int pocet_hlav;
    private int pauza=0;
    Random randint = new Random();

    public DHlava(String name1, SkladSurovin sklad, SkladSoucastek skladSoucastek, int pocet_Panenek) {
        super(name1, sklad, skladSoucastek);
        this.pocet_Panenek = pocet_Panenek;
    }

    private final int Pocet_Plastu =10;
    private int Pocet_Vlasu;

    public int getPocet_hlav() {
        return pocet_hlav;
    }

    @Override
    public void run() {
        while (super.getSkladSoucastek().getPanenka()<pocet_Panenek) {
            if (super.getSkladSoucastek().getHlava()>50) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("na Skladě je zbytečně moc rukou, Výroba se zastavuje");
            }
            if (pocet_hlav%3==0 && pocet_hlav>0 && pauza<1) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(super.getName1()+" si dává pauzu");
                pauza++;
            }
            else {
                int TypVlasu = randint.nextInt(100);
                pauza=0;
                System.out.println("Výrobce " + super.getName1() + " vyrábí hlavy");
                if (TypVlasu<=50) {
                    Pocet_Vlasu=3;
                } else if (TypVlasu>51 && TypVlasu<90) {
                    Pocet_Vlasu=1;
                } else {
                    Pocet_Vlasu=0;
                }
                if (super.getSklad().uberPlast(Pocet_Plastu) && getSklad().uberVlasy(Pocet_Vlasu)) {
                    super.getSkladSoucastek().VytvorHlavu();
                    System.out.println("Výrobce "+super.getName1()+ " Dokončil hlavu");
                    pocet_hlav++;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Výrobce hlav čeká na Materiál");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (pocet_hlav%3==0) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(super.getName1()+" si dává pauzu");
                }
            }



        }
    }
}