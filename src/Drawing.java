import javax.swing.*;
import java.awt.*;

public class Drawing extends AbstractDrawing {

    static void drawUpdate() {

    }

    private void toConsole() {
        int[] array = Sort.getArray();
        for (int i = 0; i < Sort.getArray().length; i++) {
            System.out.println(array[i]);
        }
    }

    private void doSortType() {
        switch (sortTypes.getSelectedIndex())
        {
            case 0:
                BubbleSort.sort(Sort.getArray());
                toConsole();
                break;
            case 1:
                InsertionSort.sort(Sort.getArray());
                toConsole();
                break;
            case 2: System.out.println("sort not found");
            break;
            case 3: System.out.println("sort not found");
            break;
        }
    }

    void addListeners() {
        buttonShuffle.addActionListener(e -> Sort.shuffle(Sort.getArray()));
        buttonSort.addActionListener(e -> doSortType());
    }

    Drawing() {

    }
}