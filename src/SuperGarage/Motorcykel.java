package SuperGarage;

import java.time.LocalDateTime;

public class Motorcykel implements Fordon{

    String regNr;

    double pris = 50;

    LocalDateTime incheckningstid;

    public Motorcykel(String regNr) {
        this.regNr = regNr;
        setDate();
    }

    @Override
    public void skrivUtPrisPerDag() {
        System.out.println("Motorcykel: " + this.pris + "kr/dag");
    }

    @Override
    public void setDate(){
        this.incheckningstid = LocalDateTime.now();
    }
}
