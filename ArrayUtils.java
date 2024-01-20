
    import java.util.Random;
    
    public class ArrayUtils {
        // Luo satunnaisesti generoidun taulukon
        public static int[] createRandomIntArray(int size, int max) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(max);
        }
        return array;
    }

    // Luo nousevassa järjestyksessä olevan taulukon
    public static int[] createAscendingTable(int size) {
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
        array[i] = i;
    }
    return array;
}

    // Luo laskevassa järjestyksessä olevan taulukon
    public static int[] createDescendingTable(int size) {
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
        array[i] = size - 1 - i;
    }
    return array;
    }
    }