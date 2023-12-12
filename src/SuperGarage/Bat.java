package SuperGarage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bat implements Fordon{

    String regNr;
    String owner;

    double pris = 100;

    LocalDate incheckningstid;

    public Bat(String regNr) {
        this.regNr = regNr;
        setDate();
    }

    @Override
    public void skrivUtPrisPerDag() {
        System.out.println("Båt: " + this.pris + "kr/dag");
    }

    @Override
    public String toString(){
        return ("Båt, " + this.regNr);
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
