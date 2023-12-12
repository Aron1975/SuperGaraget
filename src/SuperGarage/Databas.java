package SuperGarage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Databas {
    private final List<Fordon> parkeradeBilar = new ArrayList<>();

    public void saveFordon(List<Fordon> vehicles) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/SuperGarage/bilar.txt"))) {
            for (Fordon parkeradeB : vehicles) {
                writer.write(parkeradeB.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ödet var min väg");
        }
    }

    public List<Fordon> loadFordon() {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/SuperGarage/bilar.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] tempDelar = line.split(", ");

                String fordonsTyp = tempDelar[0];
                String regNummer = tempDelar[1];
                LocalDate parkeringsDatum = LocalDate.parse(tempDelar[2]);

                if (fordonsTyp.equals("Bil")) {
                    parkeradeBilar.add(new Bil(regNummer, parkeringsDatum));
                }
                if (fordonsTyp.equals("Båt")) {
                    parkeradeBilar.add(new Bat(regNummer, parkeringsDatum));
                }
                if (fordonsTyp.equals("Moped")) {
                    parkeradeBilar.add(new Moped(regNummer, parkeringsDatum));
                }
                if (fordonsTyp.equals("Motorcykel")) {
                    parkeradeBilar.add(new Motorcykel(regNummer, parkeringsDatum));
                }

            }
        } catch (IOException e) {
            System.out.println("Sören life");
        }

        return parkeradeBilar;
    }
}


