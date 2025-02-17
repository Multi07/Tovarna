public class DRuce extends Delnik{
    private int pocet_Panenek;
    public DRuce(String name1, SkladSurovin sklad, SkladSoucastek skladSoucastek, int pocet_Panenek) {
        super(name1, sklad, skladSoucastek);
        this.pocet_Panenek = pocet_Panenek;
    }
    private final int Pocet_Plastu = 20;

    @Override
    public void run() {
        while (super.getSkladSoucastek().getPanenka()<pocet_Panenek) {
            System.out.println("Výrobce " + super.getName1() + " vyrábí ruce");
            if (super.getSklad().uberPlast(Pocet_Plastu)) {
                super.getSkladSoucastek().VytvorRuka();
                System.out.println("Výrobce "+super.getName1()+ " Dokončil ruce");
            } else {
                System.out.println("Výrobce rukou čeká na Materiál");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
