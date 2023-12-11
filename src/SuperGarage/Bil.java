package SuperGarage;

import java.time.LocalDateTime;

public class Bil implements Fordon{

    String regNr;

    double pris = 70;

    LocalDateTime incheckningstid;

    public Bil(String regNr) {
        this.regNr = regNr;
        setDate();
    }

    @Override
    public void skrivUtPrisPerDag() {
        System.out.println("Bil: " + this.pris + "kr/dag");
    }

    @Override
    public void setDate(){
        this.incheckningstid = LocalDateTime.now();
    }
}
