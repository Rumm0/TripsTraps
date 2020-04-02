import java.util.Scanner;
import static java.lang.Integer.parseInt;

//Selle klassiga koostame isendi mängulaua jaoks ja meetodi käikude tegemiseks
public class MänguLaud {
    public char[][] laud;
    public MänguLaud(){
        this.laud = new char[3][3]; //3x3 list, millel käike teha
    }

    public char[][] getLaud() {
        return laud;
    }
    // See meetod võtab kasutajalt sisendi, kuhu ta oma sümboli panna tahab, ning muudab vastaval laua indexil 0'i kas siis 1'ks
    //või 2'ks, olenevalt mängijast. Kui antud laua indexile on juba käik tehtud, siis tagastab meetod false.
    public static boolean käik(MänguLaud laud, Mängija mängija){
        Scanner sc = new Scanner(System.in);

        //Try Catch loop erindite püüdmiseks
        boolean tehtud = false;
        while (!tehtud){
            try {
                System.out.println("Tee oma käik "+ mängija.nimi + " (1-9)↗");
                int käik = parseInt(sc.nextLine());
                if (laud.getLaud()[((käik-1)/3)][(käik-1)%3] == 0){
                    laud.getLaud()[((käik-1)/3)][(käik-1)%3] = mängija.getXvõiO();
                    tehtud = true;
                }
                else {
                    System.out.println("Sinna on juba käidud! Proovi uuesti!");
                    tehtud = true;
                    return false;
                }
            }catch (Exception x){
                System.out.println("Vigane sisend. Proovi uuesti");
            }
        }
        System.out.println(laud.toString());
        return true;
    }

    @Override
    public String toString() {
        return ((laud[2][0]) + "|" + (laud[2][1]) + "|" + (laud[2][2]) + "\n" +
                "-".repeat(5) + "\n" +
                (laud[1][0]) + "|" + (laud[1][1]) + "|" + (laud[1][2]) + "\n" +
                "-".repeat(5) + "\n" +
                (laud[0][0]) + "|" + (laud[0][1]) + "|" + (laud[0][2]));
    }
}
