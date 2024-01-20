import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {
    private static boolean headerWritten = false; // Add this flag

    public static void writeToCsv(String filePath, List<AlgorithmPerformanceTracker.AlgorithmPerformance> performances) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Check if the header has been written before
            if (!headerWritten) {
                writer.write("Taulukko, Algoritmi, Toteustusaika ");
                writer.newLine();
                headerWritten = true; // Set the flag to true after writing the header
            }

            for (AlgorithmPerformanceTracker.AlgorithmPerformance perf : performances) {
                // Päivitä datan kirjoitusjärjestys
                writer.write(perf.arrayType + "," + perf.algorithmName + "," + perf.executionTime);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // resetFile-metodi tyhjentää tiedoston
    public static void resetFile(String filePath) {
        try (FileWriter fw = new FileWriter(filePath, false)) {
            // Kirjoittamalla merkkijonon, tiedosto tyhjennetään
            fw.write(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*Kuuluu Mainiin, jos tätä haluaa käyttää.
System.out.println("Haluatko tyhjentää CSV-tiedoston? (kyllä/ei)");
        scanner.nextLine();  // Tyhjentää rivinvaihdon merkin seuraavalta syöttöriviltä
        String vastaus = scanner.nextLine();

        if ("kyllä".equalsIgnoreCase(vastaus)) {
            CsvWriter.resetFile(csvFilePath);
            System.out.println("Tiedosto tyhjennetty.");
        } else*/