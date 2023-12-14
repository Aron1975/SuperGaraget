package SuperGarage;

import java.time.LocalDate;

public class Motorcykel implements Fordon{

    private String regNr;
    private double pris = 50;

    private LocalDate incheckningstid;

    public Motorcykel(String regNr, LocalDate incheckningstid) {
        this.regNr = regNr;
        this.incheckningstid = incheckningstid;
    }

    @Override
    public String toString(){
        return ("Motorcykel, " + this.regNr + ", " + incheckningstid);
    }

    @Override
    public LocalDate getIncheckningstid(){
        return incheckningstid;
    }

    public String getRegNr(){
        return this.regNr;
    }

    public double getPris(){
        return this.pris;
    }
}
