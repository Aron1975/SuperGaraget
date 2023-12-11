package SuperGarage;

public class GarageMain {

    public static void main(String[] args) {

        Garage superGarage = new Garage();
        Fordon fordon1 = superGarage.createFordon("bil", "PPP100");
        Fordon fordon2 = superGarage.createFordon("båt", "Darling");
        Fordon fordon3 = superGarage.createFordon("Motorcykel", "ZZM600");
        Fordon fordon4 = superGarage.createFordon("Moped", "BRR050");

        fordon1.skrivUtPrisPerDag();
        fordon2.skrivUtPrisPerDag();
        fordon3.skrivUtPrisPerDag();
        fordon4.skrivUtPrisPerDag();
    }
}
