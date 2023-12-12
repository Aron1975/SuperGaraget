package SuperGarage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bil implements Fordon{

    String regNr;
    String owner;

    double pris = 70;

    LocalDate incheckningstid;

    public Bil(String regNr, LocalDate incheckningstid) {
        this.regNr = regNr;
        this.incheckningstid = incheckningstid;
    }

    @Override
    public void skrivUtPrisPerDag() {
        System.out.println("Bil: " + this.pris + "kr/dag");
    }

    @Override
    public String toString(){
        return ("Bil, " + this.regNr + ", " + incheckningstid);
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
