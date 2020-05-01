//Selle klassiga koostame isendi mängulaua jaoks ja meetodi käikude tegemiseks
public class MänguLaud {
    public char[][] laud;
    public Mängija aktiivne;

    public MänguLaud() {
        this.laud = new char[3][3]; //3x3 list, millel käike teha
    }

    public Mängija getAktiivne() {
        return aktiivne;
    }

    public void setAktiivne(Mängija aktiivne) {
        this.aktiivne = aktiivne;
    }

    public char[][] getLaud() {
        return laud;
    }

    // Meetod aktiveeritud meetodi test.press sees
    // Võtab argumentideks Mängulaua, Mängija, ja valitud kohale vastava arvu
    // Tagastab true kui käik läks läbi ja false kui kohal on juba sümbol
    public static boolean käik(MänguLaud laud, Mängija mängija, int käik) {
        //Scanner sc = new Scanner(System.in);
        if (laud.getLaud()[((käik - 1) / 3)][(käik - 1) % 3] == 0) {
            laud.getLaud()[((käik - 1) / 3)][(käik - 1) % 3] = mängija.getXvõiO();
            return true;
        } else {
            System.out.println("Sinna on juba käidud! Proovi uuesti!");
            return false;
        }
    }

    @Override
    public String toString() {
        return ((laud[0][0]) + "|" + (laud[0][1]) + "|" + (laud[0][2]) + "\n" +
                "-".repeat(5) + "\n" +
                (laud[1][0]) + "|" + (laud[1][1]) + "|" + (laud[1][2]) + "\n" +
                "-".repeat(5) + "\n" +
                (laud[2][0]) + "|" + (laud[2][1]) + "|" + (laud[2][2]));
    }
}



