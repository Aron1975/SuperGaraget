package SuperGarage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Moped implements Fordon{

    String regNr;
    String owner;

    double pris = 20;

    LocalDate incheckningstid;

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
        return ("Moped, " + this.regNr + ", " + incheckningstid);
    }

    @Override
    public void setDate(){
        this.incheckningstid = LocalDate.now();
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
