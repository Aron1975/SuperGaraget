package SuperGarage;

import java.util.Scanner;

public class GarageMain {
    Garage garage = new Garage();
    Scanner scan = new Scanner(System.in);

    public GarageMain() {
        System.out.println("Välkommen till Super Garaget!");
        System.out.println("Om något inte fungerar kontakta oss på Supergaraget AB: 076 123 45 67");
        kundEllerAnställd();
        if (kundEllerAnställd().equals("kund")) {
            kund();
        } else if (kundEllerAnställd().equals("anställd")) {
            anställd();
        } else {
            System.out.println("Om du inte är anställd eller kund, vänligen lämna området.");
        }
    }

    public String kundEllerAnställd() {
        System.out.println("Är du anställd eller kund? (skriv kund eller anställd)");
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

                Fordon fordon = garage.checkaInFordon(fordonsTyp, regNr);

                System.out.println("Välkommen in och parkera!");

            } else {
                System.out.println("Garaget är fullt, vänligen återkom i ett senare skede.");
            }
        } else if (inEllerUtFråga.equals("ut")){
            System.out.println("Vad har du för registreringsnummer?");
            String regNr = scan.nextLine();
            garage.checkaUtFordon(regNr);
            garage.skickaFaktura();
        }
    }

    public void anställd() {
        System.out.println();
    }

    public static void main(String[] args) {

        Garage superGarage = new Garage();
        Fordon fordon1 = superGarage.checkaInFordon("bil", "PPP100");
        Fordon fordon2 = superGarage.checkaInFordon("båt", "Darling");
        Fordon fordon3 = superGarage.checkaInFordon("Motorcykel", "ZZM600");
        Fordon fordon4 = superGarage.checkaInFordon("Moped", "BRR050");
        fordon1.skrivUtPrisPerDag();
        fordon2.skrivUtPrisPerDag();
        fordon3.skrivUtPrisPerDag();
        fordon4.skrivUtPrisPerDag();
        System.out.println(fordon1 instanceof Bat);
        System.out.println(fordon2.toString());
        System.out.println(fordon3.toString());
    }
}
