public class BubbleSort extends Sort {

    static void sort(int[] array) {
        for (int i = 999; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j+1);
                }
            }
        }
    }
}