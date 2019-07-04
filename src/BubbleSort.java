public class BubbleSort extends Sort {

    static void sort(int[] array) {
        for (int i = Sort.getArray().length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j+1);
                }
            }
        }
    }
}