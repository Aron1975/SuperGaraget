package SuperGarage;

import java.time.LocalDate;

public class Moped implements Fordon {

    private final String regNr;
    private final double pris = 20;

    private final LocalDate incheckningstid;

    public Moped(String regNr, LocalDate incheckningstid) {
        this.regNr = regNr;
        this.incheckningstid = incheckningstid;
    }

    @Override
    public String toString() {
        return ("Moped, " + this.regNr + ", " + incheckningstid);
    }

    @Override
    public LocalDate getIncheckningstid() {
        return incheckningstid;
    }

    public String getRegNr() {
        return this.regNr;
    }

    public double getPris() {
        return this.pris;
    }
}
