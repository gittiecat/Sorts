public class InsertionSort extends Sort{

    static void sort(int[] array) {
        for (int i = 1; i < getArray().length; i++) {
            int key = i - 1;
            while (array[i] < array[key]) {
                if (key != 0 && array[i] < array[key - 1]) {key--;}
                else {Sort.insert(array,i,key);}
            }
        }
    }
}