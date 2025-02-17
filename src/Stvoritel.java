import java.util.Random;

public class Stvoritel extends Delnik {
    private int pocet_Panenek=0;
    private int VyrobenePanenky=0;
    Random rand = new Random();
    public Stvoritel(String name1, SkladSurovin sklad, SkladSoucastek skladSoucastek, int pocet_Panenek) {
        super(name1, sklad, skladSoucastek);
        this.pocet_Panenek = pocet_Panenek;
    }
    @Override
    public void run() {
        while (super.getSkladSoucastek().getPanenka()<pocet_Panenek) {
            int randomInt = rand.nextInt(10000);
            System.out.println("Stvoritel " + super.getName1() + " vyrábí Panenku");
            if (super.getSkladSoucastek().Vytvorpanenku()) {
                VyrobenePanenky++;
                System.out.println("------------------------------------------------");
                System.out.println("Stvoritel "+super.getName1()+ " Dokončil Panenku, celkový počet: "+ super.getSkladSoucastek().getPanenka());
                System.out.println("------------------------------------------------");
            } else {
                System.out.println("Stvoritel "+super.getName1()+" čeká na Materiál");
                try {
                    Thread.sleep(randomInt);
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

    public int getVyrobenePanenky() {
        return VyrobenePanenky;
    }
}
