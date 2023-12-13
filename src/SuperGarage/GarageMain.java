package SuperGarage;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GarageMain {
    Garage garage = new Garage();
    Databas databas = new Databas();
    Scanner scan = new Scanner(System.in);
    LocalDate parkeringsDatum = LocalDate.now();

    public GarageMain() {
        laddaFordon();
        välkommenOchInfo();
        garage.antalPlatserLediga();
        String s = kundEllerAnställd();
        if (s.equals("1")) {
            kund();
        } else if (s.equals("2")) {
            anställd();
        } else {
            System.out.println("Om du inte är anställd eller kund, vänligen lämna området.");
        }
        databas.saveFordon(garage.getParkeradeBilar());
    }

    public static void main(String[] args) {
        GarageMain garageMain = new GarageMain();
    }

    public String kundEllerAnställd() {
        System.out.println("Är du anställd eller kund? \nSkriv:  \n- 1 för kund. \n- 2 för anställd.");
        String aK = scan.nextLine().trim().toLowerCase();
        return aK;
    }

    public void kund() {
        while (true) {
            System.out.println("Vill du checka in eller checka ut ett fordon? \nAnge: \n- 1 för att checka in \n- 2 för att checka ut" +
                    "\n- 3 för att stänga ner programmet.");
            String inEllerUtFråga = scan.nextLine().trim().toLowerCase();
            if (inEllerUtFråga.equals("1")) {
                if (garage.kontrolleraPlats()) {

                    System.out.println("Vad har du för registreringsnummer?");
                    String regNr = scan.nextLine();
                    System.out.println("Vad har du för fordonstyp?");
                    String fordonsTyp = scan.nextLine();

                    if (garage.checkaInFordon(fordonsTyp, regNr, parkeringsDatum) == null) {
                        System.out.println("Fordonet får inte parkera här.");
                    } else {
                        System.out.println("Välkommen in och parkera!");
                    }

                } else {
                    System.out.println("Garaget är fullt, vänligen återkom i ett senare skede.");
                }
            } else if (inEllerUtFråga.equals("2")) {
                System.out.println("Vad har du för registreringsnummer?");
                String regNr = scan.nextLine();
                garage.checkaUtFordon(regNr);
                garage.skickaFaktura();
            } else if(inEllerUtFråga.equals("3")){
                System.out.println("Adjöken!");
                databas.saveFordon(garage.getParkeradeBilar());
                System.exit(0);
            }
        }
    }

    public void anställd() {
        while (true) {
            System.out.println("Vad vill du göra? Ange: \n- 1 för att söka i databas eller\n- 2 för Checka in eller checka ut en kund" +
                    "\n- 3 för att skriva ut alla fordon" + " \n- 4 för att kontrollera parkeringstid."
                    + " \n- 5 för att stänga ner programmet.");
            String sökEllerCheck = scan.nextLine().trim().toLowerCase();

            if (sökEllerCheck.equals("1")) {
                System.out.println("Vilket reg nr?");
                String regNr = scan.nextLine().trim().toUpperCase();
                int parkeringsPlats = garage.hittaFordon(regNr);
                if (parkeringsPlats == -1) {
                    System.out.println("Bilen är inte parkerad här!");
                } else {
                    System.out.println(garage.getParkeradeBilar().get(parkeringsPlats).toString());
                }
            } else if (sökEllerCheck.equals("2")) {
                kund();
            } else if (sökEllerCheck.equals("3")) {
                garage.skrivUtIncheckadeBilar();
            } else if (sökEllerCheck.equals("4")) {
                garage.kontrollerBegränsningParkeradeDagar();
            } else if (sökEllerCheck.equals("5")) {
                System.out.println("Adjöken!");
                databas.saveFordon(garage.getParkeradeBilar());
                System.exit(0);
            }else {
                System.out.println("Adjöken");
            }
        }
    }

    public void välkommenOchInfo() {
        System.out.println("Välkommen till Super Garaget!");
        System.out.println("Om något inte fungerar kontakta oss på Supergaraget AB: 076 123 45 67" + "\n" +
                "\n Garaget är öppet: Måndag-Söndag 00:00 - 23:59." +
                "\n - Obemannat 16:00 - 23:59.");
    }

    public void laddaFordon() {
        List<Fordon> test123 = databas.loadFordon();
        garage.setParkeradeBilar(test123);
    }
}
