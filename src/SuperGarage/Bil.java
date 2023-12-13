package SuperGarage;

import java.time.LocalDate;

public class Bil implements Fordon{

    String regNr;
    double pris = 70;

    LocalDate incheckningstid;

    public Bil(String regNr, LocalDate incheckningstid) {
        this.regNr = regNr;
        this.incheckningstid = incheckningstid;
    }

    @Override
    public String toString(){
        return ("Bil, " + this.regNr + ", " + incheckningstid);
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
