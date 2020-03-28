import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Esimene mängija:");
        String nimi = sc.nextLine();
        System.out.println("Teine mängija:");
        String nimi2 = sc.nextLine();
        ArrayList<Mängija> mängijad = Alustaja(nimi,nimi2);
        MänguLaud laud = new MänguLaud();
        //Siit peaks algama mängu loop, while, milles siis kasutab meetodit käik() kordamööda mängijatel,
        //kuni rida või diagonaal olemas.

    }
    //See meetod võtab parameetritena mängijate sisestatud nimed, valib suvaliselt alustaja ning teeb kaks mängijat
    //ja väljastab nad arraylistis.
    public static ArrayList<Mängija> Alustaja(String nimi, String nimi2) {
        int alustaja = (int) (Math.random() * 2);
        Mängija esimene;
        Mängija teine;
        if (alustaja == 0) {
            esimene = new Mängija(true, 1, nimi);
            teine = new Mängija(false, 2, nimi2);
        } else {
            esimene = new Mängija(false, 1, nimi);
            teine = new Mängija(true, 2, nimi2);
        }
        ArrayList<Mängija> mängijad = new ArrayList<>();
        mängijad.add(0, esimene);
        mängijad.add(1, teine);
        return mängijad;
    }
}

