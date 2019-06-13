public class InsertionSort extends Sort{

    static void insertion(int[] array, int start, int finish) {
        for (int i = start + 1; i < finish; i++) {
            int key = i - 1;
            while (array[i] < array[key]) {
                if (key != 0 && array[i] < array[key - 1]) {key--;}
                else {Sort.insert(array,i,key);}
            }
        }
    }
}