package SuperGarage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Moped implements Fordon{

    String regNr;
    String owner;

    double pris = 20;

    LocalDate incheckningstid;

    public Moped(String regNr, LocalDate incheckningstid) {
        this.regNr = regNr;
        this.incheckningstid = incheckningstid;
    }

    @Override
    public void skrivUtPrisPerDag() {
        System.out.println("Moped: " + this.pris + "kr/dag");
    }

    @Override
    public String toString(){
        return ("Moped, " + this.regNr + ", " + incheckningstid);
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
