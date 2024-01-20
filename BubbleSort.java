public class BubbleSort implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        internalBubbleSort(array);
    }

    // sisäinen BubbleSort-toteutus
    private void internalBubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Vaihda arr[j+1] ja arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}



