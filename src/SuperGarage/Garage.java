package SuperGarage;

import java.util.List;

public class Garage {

    private int antalParkeringsplatser = 20;

    private int antalParkeradeFordon;

    private boolean finnsPlats = false;
    List<Fordon> parkeradeBilar;

    public Fordon checkaInFordon(String typ, String regNr) {
        if (typ.equalsIgnoreCase("Bil")) {
            return new Bil(regNr);
        }
        if (typ.equalsIgnoreCase("Båt")) {
            return new Bat(regNr);
        }
        if (typ.equalsIgnoreCase("Moped")) {
            return new Moped(regNr);
        }
        if (typ.equalsIgnoreCase("Motorcykel")) {
            return new Motorcykel(regNr);
        }
        return null;
    }

    public boolean kontrolleraPlats() {
        if (antalParkeradeFordon < antalParkeringsplatser){
            return true;
        } else
            return false;
    }
}
