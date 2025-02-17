public class DNohy extends Delnik{
    private final int POCET_GRAMU_PLASTU = 30;
    private int pocet_Panenek;
    public DNohy(String name1, SkladSurovin sklad, SkladSoucastek skladSoucastek, int pocet_Panenek) {
        super(name1, sklad, skladSoucastek);
        this.pocet_Panenek = pocet_Panenek;
    }


    @Override
    public void run(){
        while (super.getSkladSoucastek().getPanenka()<pocet_Panenek) {
            System.out.println("Výrobce " + super.getName1() + " vyrábí ruce");
            if (super.getSklad().uberPlast(POCET_GRAMU_PLASTU)) {
                super.getSkladSoucastek().VytvorNoha();
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
