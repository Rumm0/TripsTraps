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
}



