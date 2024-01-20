public class SelectionSort implements SortAlgorithm {
    public void sort(int[] array) {
        // Selection Sort -lajittelualgoritmi
            int n = array.length;
        
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
        
                for (int j = i + 1; j < n; j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }
        
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        
    }


