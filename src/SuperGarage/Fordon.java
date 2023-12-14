package SuperGarage;

import java.time.LocalDate;

public interface Fordon {

    String toString();

    LocalDate getIncheckningstid();

    String getRegNr();

    double getPris();
}
