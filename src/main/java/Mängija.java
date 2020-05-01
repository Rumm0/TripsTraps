//Selle klassi eesmärk on mängijate jaoks isendite tegemise võimalus

public class Mängija {
    public char XvõiO;
    public String nimi;

    //Kontruktor mängija jaoks, mis võtab parameetritena: milline on tema sümbol ning nimi
    public Mängija(char XvõiO, String nimi) {
        this.XvõiO = XvõiO;
        this.nimi = nimi;
    }

    public char getXvõiO() {
        return XvõiO;
    }

    public String getNimi() {
        return nimi;
    }
}
