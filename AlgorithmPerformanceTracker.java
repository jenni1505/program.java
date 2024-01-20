import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgorithmPerformanceTracker {
    private Map<String, List<AlgorithmPerformance>> algorithmPerformance;
    private String arrayType;

    public AlgorithmPerformanceTracker(String arrayType) {
        this.algorithmPerformance = new HashMap<>();
        this.arrayType = arrayType;
    }

    public void trackAlgorithm(String algorithmName, long executionTime) {
        // Tarkistaa onko algoritmi jo tallennettu
        if (!algorithmPerformance.containsKey(algorithmName)) {
            algorithmPerformance.put(algorithmName, new ArrayList<>());
        }
        // Lisää suoritusajan listalle
        algorithmPerformance.get(algorithmName).add(new AlgorithmPerformance(arrayType, algorithmName, executionTime));
    }

    public List<AlgorithmPerformance> getPerformanceData() {
        List<AlgorithmPerformance> performances = new ArrayList<>();
        for (Map.Entry<String, List<AlgorithmPerformance>> entry : algorithmPerformance.entrySet()) {
            performances.addAll(entry.getValue());
        }
        return performances; // Lisätty return-lause
    }
    
    public static class AlgorithmPerformance {
        String arrayType;
        String algorithmName;
        long executionTime;

        public AlgorithmPerformance(String arrayType, String algorithmName, long executionTime) {
            this.arrayType = arrayType;
            this.algorithmName = algorithmName;
            this.executionTime = executionTime;
        }

        // Getters
        public String getArrayType() {
            return arrayType;
        }
        public String getAlgorithmName() {
            return algorithmName;
        }

        public long getExecutionTime() {
            return executionTime;
        }
    }

}