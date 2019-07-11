//public class HeapSort extends Sort {
//
//	static void sort(int[] array) {
//		buildMaxHeap(array);
//		for (int i = array.length - 1; i >= 2; i--) {
//			swap(array,i,1);
//			maxHeapify(array,0);
//		}
//	}
//
//	private static void buildMaxHeap(int[] array) {
//		for (int i = (array.length / 2); i >= 1; i--) {
//			maxHeapify(array, i);
//		}
//	}
//
//	private static void maxHeapify(int[] array, int i) {
//		int l = 2*i + 1;
//		int r = 2*i + 2;
//		int max = i;
//		if (l < array.length && array[l] > array[max]) { max = l; }
//		if (r < array.length && array[r] > array[max]) { max = r; }
//		if (max != i) {
//			swap(array, i, max);
//			gUpdate();
//			maxHeapify(array, max);
//		}
//	}
//}

public class HeapSort extends Sort {
	static void sort(int[] array) {
		for (int i = array.length / 2 - 1; i >= 0; i--)
			heapify(array, i);
		for (int i = array.length - 1; i >= 0; i--) {
			swap(array,i,0);
			gUpdate();

			heapify(array, 0);
		}
	}

	private static void heapify(int[] array, int i) {
		int largest = i;  // Initialize largest as root
		int l = 2 * i + 1;  // left = 2*i + 1
		int r = 2 * i + 2;  // right = 2*i + 2

		if (l < array.length && array[l] > array[largest])
			largest = l;
		if (r < array.length && array[r] > array[largest])
			largest = r;
		if (largest != i) {
			swap(array, i, largest);
			gUpdate();

			heapify(array, largest);
		}
	}
}
