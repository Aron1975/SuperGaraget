package SuperGarage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Garage {

    private static final int antalParkeringsplatser = 20;

    private int antalParkeradeFordon = 0;

    private boolean finnsPlats = false;
    private double totalPris = 0;
    List<Fordon> parkeradeBilar = new ArrayList<>();

    public Fordon checkaInFordon(String typ, String regNr) {
        Fordon f = null;
        if (typ.equalsIgnoreCase("Bil")) {
            f = new Bil(regNr);
            return new Bil(regNr);
        }
        if (typ.equalsIgnoreCase("Båt")) {
            f = new Bat(regNr);
            return new Bat(regNr);
        }
        if (typ.equalsIgnoreCase("Moped")) {
            f = new Moped(regNr);
            return new Moped(regNr);
        }
        if (typ.equalsIgnoreCase("Motorcykel")) {
            f = new Motorcykel(regNr);
            return new Motorcykel(regNr);
        }
        parkeradeBilar.add(f);
        antalParkeradeFordon++;
        return null;
    }

    public void checkaUtFordon(String regNr) {

        LocalDateTime nutid = LocalDateTime.now();
        int bilPaPlats = hittaFordon(regNr);
        totalPris = evaluatePrice(parkeradeBilar.get(bilPaPlats), kontrolleraParkeringstid(parkeradeBilar.get(bilPaPlats)));
        parkeradeBilar.remove(bilPaPlats);
    }

    public int hittaFordon(String regNr) {
        int counter = 0;
        for (Fordon f : parkeradeBilar) {
            if (f.getRegNr().equals(regNr)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    public int kontrolleraParkeringstid(Fordon f) {
        LocalDate lD = LocalDate.now();
        Period periods = Period.between(lD, f.getDate());
        return periods.getDays();
    }

    public double evaluatePrice(Fordon f, int antalDagar) {
        return (f.getPrice() * antalDagar);
    }

    public void skickaFaktura() {
        System.out.println("Ditt totalpris blir: " + totalPris + "kronor.");
        System.out.println("Fakturan skickas till fordonsägarens hemadress, välkommen åter.");
    }

    public void skrivUtIncheckadeBilar() {
        for (Fordon f : parkeradeBilar) {
            System.out.println(f.toString());
        }
    }

    public boolean kontrolleraPlats() {
        if (antalParkeradeFordon < antalParkeringsplatser) {
            return true;
        } else
            return false;
    }
}
