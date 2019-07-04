public class QuickSort extends Sort {

    static void sort(int[] array, int start, int finish) {

    }

    private static void partition(int[] array, int point1, int point2) {
        int pivot = (point1 - point2)/2;
        insert(array, pivot, point2);
    }
}
