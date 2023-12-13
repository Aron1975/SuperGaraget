package SuperGarage;

import java.time.LocalDate;

public interface Fordon {

    public String toString();

    public LocalDate getIncheckningstid();

    public String getRegNr();

    public double getPris();
}
