public class ShellSort implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        int n = array.length;

        // Aloita suuresta aukosta ja pienennä aukkoa joka kierroksella
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Tee gapped elementin lajittelu määritellylle aukolle.
            // Elementit array[gap..n-1] ovat jo oikeassa järjestyksessä.
            for (int i = gap; i < n; i += 1) {
                // Tallenna nykyinen elementti ja etsi sen paikka
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                // Laita temp (alkuperäinen array[i]) oikeaan paikkaan
                array[j] = temp;
            }
        }
    }
}

