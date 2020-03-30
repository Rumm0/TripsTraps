
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Esimene mängija:");
        String nimi = sc.nextLine();
        System.out.println("Teine mängija:");
        String nimi2 = sc.nextLine();
        ArrayList<Mängija> mängijad = Alustaja(nimi, nimi2);
        MänguLaud laud = new MänguLaud();

        //mainloop
        //läbi = true kui mäng lõppeb
        //esimese_käik on mängijate vahel alterneermiseks
        //mäng lõppeb viigiga kui käigu_nr = 9

        boolean läbi = false;
        boolean esimese_käik = true;
        int käigu_nr = 0;
        System.out.println(laud.toString());
        while (!läbi) {
            käigu_nr += 1;
            if (esimese_käik) {
                boolean korrektne_käik = false;
                while (!korrektne_käik) {
                    korrektne_käik = MänguLaud.käik(laud, mängijad.get(0));
                    esimese_käik = false;
                }
                if (kontroll(laud)) {
                    System.out.println("Võitja on " + mängijad.get(0).nimi);
                    läbi = true;
                }
            } else if (!esimese_käik) {
                boolean korrektne_käik = false;
                while (!korrektne_käik) {
                    korrektne_käik = MänguLaud.käik(laud, mängijad.get(1));
                    esimese_käik = true;
                }
                if (kontroll(laud)) {
                    System.out.println("Võitja on " + mängijad.get(1).nimi);
                    läbi = true;
                }
            }
            if (käigu_nr == 9) {
                System.out.println("Viik!");
                läbi = true;
            }
        }
    }

    //See meetod võtab parameetritena mängijate sisestatud nimed, valib suvaliselt alustaja ning teeb kaks mängijat
    //ja väljastab nad arraylistis.
    public static ArrayList<Mängija> Alustaja(String nimi, String nimi2) {
        int alustaja = (int) (Math.random() * 2);
        Mängija esimene;
        Mängija teine;
        if (alustaja == 0) {
            esimene = new Mängija( 'X', nimi);
            teine = new Mängija( 'O', nimi2);
        } else {
            esimene = new Mängija('X', nimi2);
            teine = new Mängija( 'O', nimi);
        }
        ArrayList<Mängija> mängijad = new ArrayList<>();
        mängijad.add(0, esimene);
        mängijad.add(1, teine);
        return mängijad;
    }
    //Meetod kontrollib kas antud laual on üks mängijatest võitnud
    public static boolean kontroll(MänguLaud laud) {
        for (int i = 0; i < 3; i++) {
            //Ridade kontroll
            if (laud.laud[i][0] == laud.laud[i][1] && laud.laud[i][1] == laud.laud[i][2] && laud.laud[i][0] != '\u0000') {
                return true;
            }//Veergude kontroll
            if (laud.laud[0][i] == laud.laud[1][i] && laud.laud[1][i] == laud.laud[2][i] && laud.laud[0][i] != '\u0000') {
                return true;
            }
        }//Diagonaalide kontrollid
        if (laud.laud[0][0] == laud.laud[1][1] && laud.laud[1][1] == laud.laud[2][2] && laud.laud[1][1] != '\u0000') {
            return true;
        }
        if (laud.laud[0][2] == laud.laud[1][1] && laud.laud[1][1] == laud.laud[2][0] && laud.laud[1][1] != '\u0000') {
            return true;
        }
        return false;

    }
}

