package SuperGarage;

import java.time.LocalDateTime;

public class Moped implements Fordon{

    String regNr;
    String owner;

    double pris = 20;

    LocalDateTime incheckningstid;

    public Moped(String regNr) {
        this.regNr = regNr;
        setDate();
    }

    @Override
    public void skrivUtPrisPerDag() {
        System.out.println("Moped: " + this.pris + "kr/dag");
    }

    @Override
    public String toString(){
        return ("Moped, " + this.regNr);
    }

    @Override
    public void setDate(){
        this.incheckningstid = LocalDateTime.now();
    }
}
