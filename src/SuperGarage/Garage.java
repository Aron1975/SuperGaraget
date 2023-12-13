package SuperGarage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garage {

    private static final int antalParkeringsplatser = 20;

    private int antalParkeradeFordon = 0;

    private boolean finnsPlats = false;
    private double totalPris = 0;
    private int maxTidParkering = 365;
    private List<Fordon> parkeradeBilar = new ArrayList<>();

    public Fordon checkaInFordon(String typ, String regNr, LocalDate parkeringsDatum) {

        Scanner scan = new Scanner(System.in);

        Fordon f = null;
        regNr = regNr.toUpperCase().trim();
        if (typ.equalsIgnoreCase("Bil")) {
            f = new Bil(regNr, parkeringsDatum);
        }
        if (typ.equalsIgnoreCase("Båt")) {
            f = new Bat(regNr, parkeringsDatum);
        }
        if (typ.equalsIgnoreCase("Moped")) {
            f = new Moped(regNr, parkeringsDatum);
        }
        if (typ.equalsIgnoreCase("Motorcykel")) {
            f = new Motorcykel(regNr, parkeringsDatum);
        }


        System.out.println("Pris: " + f.getPrice() + " kr per dag.\n Skriv nej för avbryt");
        String inputUser = scan.nextLine().trim().toLowerCase();

        if (inputUser.equals("nej")) {
            System.out.println("Adjö");
            System.exit(0);
        }

        parkeradeBilar.add(f);
        antalParkeradeFordon++;
        return f;
    }

    public void checkaUtFordon(String regNr) {
        int bilPaPlats = hittaFordon(regNr);
        if (bilPaPlats == -1) {
            System.out.println("Bilen är inte parkerad här");
            System.exit(0);
        }
        totalPris = evaluatePrice(parkeradeBilar.get(bilPaPlats), kontrolleraParkeringstid(parkeradeBilar.get(bilPaPlats)));
        parkeradeBilar.remove(bilPaPlats);
    }

    public int hittaFordon(String regNr) {
        int counter = 0;
        for (Fordon f : parkeradeBilar) {
            if (f.getRegNr().equals(regNr.toUpperCase())) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    public int kontrolleraParkeringstid(Fordon f) {
        LocalDate lD = LocalDate.now();
        Period periods = Period.between(f.getDate(), lD);
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

    public void antalPlatserLediga() {
        int ledigaPlatser = antalParkeringsplatser - antalParkeradeFordon;
        System.out.println("Antal lediga platser i Garaget: " + ledigaPlatser);
        System.out.println(" ");
        ;
    }


    public List<Fordon> getParkeradeBilar() { //La till dessa
        return parkeradeBilar;
    }

    public void setParkeradeBilar(List<Fordon> parkeradeBilar) { //La till dessa
        this.parkeradeBilar = parkeradeBilar;
    }

    public int getMaxTidParkering() {
        return maxTidParkering;
    }

    public void kontrollerBegränsningParkeradeDagar() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilken fordon vill du kontrollera? (Skriv in registreringsnummer)");
        String svar = scan.nextLine();
        int i = hittaFordon(svar);
        if ( i != -1) {
            int f = kontrolleraParkeringstid(getParkeradeBilar().get(i));
            System.out.println("Kunden har parkerat: " + f + " dagar.");
            System.out.println("Kunden får stå parkerad totalt: " + (getMaxTidParkering() - f) + " dagar till.");
        }
    }
}
