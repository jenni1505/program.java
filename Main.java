import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valitse järjestys: 1: Nouseva, 2: Laskeva, 3: Satunnainen");
        
        int valinta = scanner.nextInt();
        int[] taulukko;

        if (valinta == 1) {
            taulukko = ArrayUtils.createAscendingTable(10000);
            System.out.println("Nousevan järjestyksen taulukko:");
        } else if (valinta == 2) {
            taulukko = ArrayUtils.createDescendingTable(10000);
            System.out.println("Laskevan järjestyksen taulukko:");
        } else {
            System.out.println("Satunnaisesti generoitu taulukko:");
            taulukko = ArrayUtils.createRandomIntArray(10000, 10000);
        }

        // Luo lista eri lajittelualgoritmeista
        List<SortAlgorithm> algorithms = new ArrayList<>();
        algorithms.add(new BubbleSort());
        algorithms.add(new ShellSort());
        algorithms.add(new QuickSort());
        algorithms.add(new MergeSort());
        algorithms.add(new SelectionSort());

        AlgorithmPerformanceTracker tracker = new AlgorithmPerformanceTracker(valinta == 1 ? "Nouseva" : valinta == 2 ? "Laskeva" : "Random");
        
        // Suorita jokainen lajittelualgoritmi ja mittaa suoritusaika
        for (SortAlgorithm algorithm : algorithms) {
            int[] arrayCopy = taulukko.clone();
            long startTime = System.nanoTime();
            algorithm.sort(arrayCopy);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;

            System.out.println(algorithm.getClass().getSimpleName() + " suoritusaika: " + executionTime + "ns");

            // Tallenna suoritusaika seurantaan
            tracker.trackAlgorithm(algorithm.getClass().getSimpleName(), executionTime);
        }

        //hae suoritusaikojen tiedot
        List<AlgorithmPerformanceTracker.AlgorithmPerformance> flatList = tracker.getPerformanceData();

        // Kirjoitetaan data CSV-tiedostoon
        String csvFilePath = "AlgoPerformance.csv";

        // Kirjoita data CSV-tiedostoon vain, jos käyttäjä ei halua tyhjentää sitä. Tyhjennys ei käytössä. 
        CsvWriter.writeToCsv(csvFilePath, flatList);
        scanner.close();
}
}

