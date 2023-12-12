package SuperGarage;

public class GarageMain {

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
