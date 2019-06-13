public enum Sorts {
	QuickSort("QuickSort"),
	InseretionSort("Insertion Sort"),
	SelectionSort("Selection Sort"),
	BubbleSort("Bubble Sort");

	private String sortName;

	Sorts(String sort) { sortName = sort; }

	public String getName() { return this.sortName; }

	public Sorts getSort(String string) {
		switch (string)
		{
			case "QuickSort":
				return QuickSort;
			case "Insertion Sort":
				return InseretionSort;
			case "Selection Sort":
				return SelectionSort;
			case "Bubble Sort":
				return BubbleSort;
		}
		return null;
	}
}