package SuperGarage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Fordon {
    public void skrivUtPrisPerDag();
    public String toString();

    public void setDate();

    public LocalDate getDate();

    public String getRegNr();

    public double getPrice();
}
