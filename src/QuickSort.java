public class QuickSort extends Sort {

    static void sort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            sort(array, p, q - 1);
            gUpdate();
            sort(array, q + 1, r);
            gUpdate();
        }
    }

    private static int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array,i,j);
                gUpdate();
            }
        }
        swap(array,i + 1, r);
//        gUpdate();
        return i + 1;
    }
}
