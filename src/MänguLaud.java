import java.util.Scanner;
import static java.lang.Integer.parseInt;

//Selle klassiga koostame isendi mängulaua jaoks ja meetodi käikude tegemiseks
public class MänguLaud {
    public int laud[][];
    public MänguLaud(){
        this.laud = new int[3][3]; //3x3 list, millel käike teha
    }

    public int[][] getLaud() {
        return laud;
    }
    // See meetod võtab kasutajalt sisendi, kuhu ta oma sümboli panna tahab, ning muudab vastaval laua indexil 0'i kas siis 1'ks
    //või 2'ks, olenevalt mängijast. Kui antud laua indexile on juba käik tehtud, siis tagastab meetod false.
    public static boolean käik(MänguLaud laud, Mängija mängija){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tee oma käik");
        int käik = parseInt(sc.nextLine());
        if (laud.getLaud()[((käik-1)/3)][(käik-1)%3] == 0){
            laud.getLaud()[((käik-1)/3)][(käik-1)%3] = mängija.getXvõiO();}
        else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
