package SuperGarage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Motorcykel implements Fordon{

    String regNr;
    String owner;

    double pris = 50;

    LocalDate incheckningstid;

    public Motorcykel(String regNr, LocalDate incheckningstid) {
        this.regNr = regNr;
        this.incheckningstid = incheckningstid;
    }

    @Override
    public void skrivUtPrisPerDag() {
        System.out.println("Motorcykel: " + this.pris + "kr/dag");
    }

    @Override
    public String toString(){
        return ("Motorcykel, " + this.regNr + ", " + incheckningstid);
    }

    @Override
    public LocalDate getDate(){
        return incheckningstid;
    }

    public String getRegNr(){
        return this.regNr;
    }

    public double getPrice(){
        return this.pris;
    }
}
