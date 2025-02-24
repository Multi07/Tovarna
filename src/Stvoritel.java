import java.util.Random;

public class Stvoritel extends Delnik {
    private final int pocet_Panenek;
    private int VyrobenePanenky=0;
    private int pauza=0;
    Random rand = new Random();
    public Stvoritel(String name1, SkladSurovin sklad, SkladSoucastek skladSoucastek, int pocet_Panenek) {
        super(name1, sklad, skladSoucastek);
        this.pocet_Panenek = pocet_Panenek;
    }
    @Override
    public void run() {
        while (super.getSkladSoucastek().getPanenka()<pocet_Panenek) {
            if (VyrobenePanenky%3==0 && VyrobenePanenky>0 && pauza<1) {
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
            System.out.println("Stvoritel " + super.getName1() + " vyrábí Panenku");
            if (super.getSkladSoucastek().Vytvorpanenku()) {
                VyrobenePanenky++;
                System.out.println("------------------------------------------------");
                System.out.println("Stvoritel "+super.getName1()+ " Dokončil Panenku, celkový počet: "+ (super.getSkladSoucastek().getPanenka()));
                System.out.println("------------------------------------------------");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Stvoritel "+super.getName1()+" čeká na Materiál");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            }
        }
    }

    public int getVyrobenePanenky() {
        return VyrobenePanenky;
    }
}
