public class DNohy extends Delnik {
    private final int POCET_GRAMU_PLASTU = 30;
    private final int pocet_Panenek;
    private int pocet_nohou;
    private int pauza=0;

    public DNohy(String name1, SkladSurovin sklad, SkladSoucastek skladSoucastek, int pocet_Panenek) {
        super(name1, sklad, skladSoucastek);
        this.pocet_Panenek = pocet_Panenek;
    }

    public int getPocet_nohou() {
        return pocet_nohou;
    }

    @Override
    public void run() {
        while (super.getSkladSoucastek().getPanenka() < pocet_Panenek) {
            if (super.getSkladSoucastek().getNoha()>50) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("na Skladě je zbytečně moc rukou, Výroba se zastavuje");
            }
            if (pocet_nohou % 3 == 0 && pocet_nohou > 0 && pauza<1) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(super.getName1() + " si dává pauzu");pauza++;
            }
            else {
                pauza=0;
                System.out.println("Výrobce " + super.getName1() + " vyrábí ruce");
                if (super.getSklad().uberPlast(POCET_GRAMU_PLASTU)) {
                    super.getSkladSoucastek().VytvorNoha();
                    System.out.println("Výrobce " + super.getName1() + " Dokončil ruce");
                    pocet_nohou++;
                    try {
                        Thread.sleep(500);
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
                if (pocet_nohou % 3 == 0) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(super.getName1() + " si dává pauzu");
                }
            }

        }
    }
}