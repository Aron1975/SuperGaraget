package SuperGarage;

import java.time.LocalDateTime;

public class Bat implements Fordon{

    String regNr;

    double pris = 100;

    LocalDateTime incheckningstid;

    public Bat(String regNr) {
        this.regNr = regNr;
        setDate();
    }

    @Override
    public void skrivUtPrisPerDag() {
        System.out.println("Båt: " + this.pris + "kr/dag");
    }

    @Override
    public void setDate(){
        this.incheckningstid = LocalDateTime.now();
    }
}
