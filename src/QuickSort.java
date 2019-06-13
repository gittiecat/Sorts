public class QuickSort {

    static void quick(int[] array, int start, int finish) {

    }

    private static void partition(int[] array, int point1, int point2) {
        int pivot = (point1 - point2)/2;
        Sort.insert(array, pivot, point2);
    }
}
