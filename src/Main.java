import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Kolik chcete vyrobit panenek?");
        int pocet = sc.nextInt();
        SkladSurovin sklad = new SkladSurovin();
        SkladSoucastek skladSoucastek = new SkladSoucastek();
        ArrayList<Thread> list = new ArrayList<>();
        DRuce dRuce = new DRuce("Amir", sklad, skladSoucastek, pocet);
        DNohy dNohy = new DNohy("Ameer", sklad, skladSoucastek, pocet);
        DTelo dTelo = new DTelo("Amir-Junior", sklad, skladSoucastek, pocet);
        DHlava dHlava = new DHlava("Amar", sklad, skladSoucastek, pocet);
        Stvoritel stvoritel = new Stvoritel("Amara", sklad, skladSoucastek, pocet);
        Stvoritel stvoritel2 = new Stvoritel("jihdfgjid", sklad, skladSoucastek, pocet);
        Skladnik skladnik = new Skladnik("Ameer-Junior", sklad, skladSoucastek, pocet);
        list.add(new Thread(dRuce));
        list.add(new Thread(dNohy));
        list.add(new Thread(dTelo));
        list.add(new Thread(dHlava));
        list.add(new Thread(stvoritel));
        list.add(new Thread(stvoritel2));
        list.add(new Thread(skladnik));

        for (Thread t : list) {
            t.start();
        }
        for (Thread t : list) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        }
        if (skladSoucastek.getPanenka()==pocet) {
            System.out.println("Určený počet Panenek byl vyroben, tvorba končí!!");
        }

        skladSoucastek.Kontrola();
        System.out.println("Proběhla Kontrola panenek a vadné byly vyřazeny, Zbývající počet panenek: "+(skladSoucastek.getPanenka()-skladSoucastek.Kontrola()));

        if (stvoritel.getVyrobenePanenky()> stvoritel2.getVyrobenePanenky()) {
            System.out.println(stvoritel.getName1()+" Vyrobil více Panenek, vyrobil: "+stvoritel2.getVyrobenePanenky());
        }else if (stvoritel.getVyrobenePanenky()==stvoritel2.getVyrobenePanenky()) {
            System.out.println("Stvořitelé vyrobili stejný počet panenek");
        }
        else {
            System.out.println(stvoritel2.getName1()+" Vyrobil více Panenek, vyrobil: "+stvoritel2.getVyrobenePanenky());
        }
    }
}