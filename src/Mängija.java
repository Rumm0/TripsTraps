//Selle klassi eesmärk on mängijate jaoks isendite tegemise võimalus

public class Mängija {
    public boolean Alustab;
    public int XvõiO;
    public String nimi;
    //Kontruktor mängija jaoks, mis võtab parameetritena: Kas ta alustab, milline on tema sümbol ning nimi
    public Mängija(boolean Alustab, int XvõiO, String nimi){
        this.Alustab = Alustab;
        this.XvõiO = XvõiO;
        this.nimi = nimi;
    }

    public int getXvõiO() {
        return XvõiO;
    }

    public String getNimi() {
        return nimi;
    }
}
