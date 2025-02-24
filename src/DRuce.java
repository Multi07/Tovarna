public class DRuce extends Delnik{
    private final int pocet_Panenek;
    private int pocet_rukou;
    private int pauza =0;
    public DRuce(String name1, SkladSurovin sklad, SkladSoucastek skladSoucastek, int pocet_Panenek) {
        super(name1, sklad, skladSoucastek);
        this.pocet_Panenek = pocet_Panenek;
    }
    private final int Pocet_Plastu = 20;

    public int getPocet_rukou() {
        return pocet_rukou;
    }

    @Override
    public void run() {
        while (super.getSkladSoucastek().getPanenka()<pocet_Panenek) {
            if (super.getSkladSoucastek().getRuka()>50) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("na Skladě je zbytečně moc rukou, Výroba se zastavuje");
            }
        if (pocet_rukou%3==0 && pocet_rukou >0 && pauza<1) {
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
            System.out.println("Výrobce " + super.getName1() + " vyrábí ruce");
            if (super.getSklad().uberPlast(Pocet_Plastu)) {
                super.getSkladSoucastek().VytvorRuka();
                System.out.println("Výrobce "+super.getName1()+ " Dokončil ruce");
                pocet_rukou++;
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
            }
        }
    }
}
