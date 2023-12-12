package SuperGarage;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GarageMain {
    Garage garage = new Garage();
    Databas databas = new Databas(); //Simon
    Scanner scan = new Scanner(System.in);
    LocalDate parkeringsDatum = LocalDate.now(); //Simon

    public GarageMain() {
        laddaFordon();
        //garage.checkaInFordon("Bil", "ABC123", parkeringsDatum); //Skickar in parkeringsDatum
       // garage.checkaInFordon("Båt", "APA139", parkeringsDatum);
       // garage.checkaInFordon("Båt", "APA139", parkeringsDatum);

        System.out.println("Välkommen till Super Garaget!");
        System.out.println("Om något inte fungerar kontakta oss på Supergaraget AB: 076 123 45 67");

        String s = kundEllerAnställd();
        if (s.equals("1")) {
            kund();
        } else if (s.equals("2")) {
            anställd();
        } else {
            System.out.println("Om du inte är anställd eller kund, vänligen lämna området.");
        }
        databas.saveFordon(garage.getParkeradeBilar()); //Sparar ner i fil.
    }

    public static void main(String[] args) {
        GarageMain garageMain = new GarageMain();
    }

    public String kundEllerAnställd() {
        System.out.println("Är du anställd eller kund? Skriv 1 för kund och 2 för anställd");
        String aK = scan.nextLine().trim().toLowerCase();
        return aK;
    }

    public void kund() {
        System.out.println("Vill du checka in eller checka ut ett fordon? (skriv in eller ut)");
        String inEllerUtFråga = scan.nextLine().trim().toLowerCase();
        if (inEllerUtFråga.equals("in")) {
            if (garage.kontrolleraPlats()) {

                System.out.println("Vad har du för registreringsnummer?");
                String regNr = scan.nextLine();
                System.out.println("Vad har du för fordonstyp?");
                String fordonsTyp = scan.nextLine();

                if (garage.checkaInFordon(fordonsTyp, regNr, parkeringsDatum) == null) {
                    System.out.println("Fordonet får inte parkera här.");
                    System.exit(0);
                }

                System.out.println("Välkommen in och parkera!");

            } else {
                System.out.println("Garaget är fullt, vänligen återkom i ett senare skede.");
            }
        } else if (inEllerUtFråga.equals("ut")) {
            System.out.println("Vad har du för registreringsnummer?");
            String regNr = scan.nextLine();
            garage.checkaUtFordon(regNr);
            garage.skickaFaktura();
        }
    }

    public void anställd() {
        System.out.println("Vad vill du göra?\nAnge 1 för att söka i databas eller\n2 för Checka in eller checka ut en kund" +
                "\n3 för att skriva ut alla fordon");
        String sökEllerCheck = scan.nextLine().trim().toLowerCase();

        if (sökEllerCheck.equals("1")) {
            System.out.println("Vilket reg nr?");
            String regNr = scan.nextLine().trim().toUpperCase();
            int parkeringsPlats = garage.hittaFordon(regNr);
            if (parkeringsPlats == -1) {
                System.out.println("Bilen är inte parkerad här");
                System.exit(0);
            }
            System.out.println(garage.getParkeradeBilar().get(parkeringsPlats).toString()); //Stämmer detta?
        } else if (sökEllerCheck.equals("2")) {
            kund();
        } else if (sökEllerCheck.equals("3")) {
            garage.skrivUtIncheckadeBilar();
        } else {
            System.out.println("Adjöken");
        }

    }

    public void laddaFordon(){
        List<Fordon> test123 = databas.loadFordon(); //Tester xpdpxodpx
       // for (Fordon vehicle : test123) { //Utskrift test1337
        //    System.out.println("TestBilar: " + vehicle);
       // }
        garage.setParkeradeBilar(test123);
    }
}
