public class BubbleSort extends Sort {

    public void bubble(int[] array, int start, int finish) {
        for (int i = finish; i > start; i--) {
            for (int j = start; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j+1);
                }
            }
        }
    }
}