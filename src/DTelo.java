public class DTelo extends Delnik {
    private final int pocet_Panenek;
    private int pocet_tel;
    private int pauza=0;
    public DTelo(String name1, SkladSurovin sklad, SkladSoucastek skladSoucastek, int pocet_Panenek) {
        super(name1, sklad, skladSoucastek);
        this.pocet_Panenek = pocet_Panenek;
    }
    private final int Pocet_Plastu = 50;

    public int getPocet_tel() {
        return pocet_tel;
    }

    @Override
    public void run() {
        while (super.getSkladSoucastek().getPanenka()<pocet_Panenek) {
            if (super.getSkladSoucastek().getTelo()>50) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("na Skladě je zbytečně moc rukou, Výroba se zastavuje");
            }
            if (pocet_tel%3==0 && pocet_tel >0 && pauza<1) {
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
            System.out.println("Výrobce " + super.getName1() + " vyrábí tělo");
            if (super.getSklad().uberPlast(Pocet_Plastu)) {
                super.getSkladSoucastek().VytvorTelo();
                System.out.println("Výrobce "+super.getName1()+ " Dokončil tělo");
                pocet_tel++;
                try {
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Výrobce těl čeká na Materiál");
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
