public class SelectionSort extends Sort{

	static void sort(int[] array) {
		for (int i = 0; i < Sort.getArray().length; i++) {
			int min = i;
			for (int j = i + 1; j < Sort.getArray().length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			Sort.swap(Sort.getArray(), i, min);
			panel.paintImmediately(10,0, 1006,1026);
		}
	}
}
