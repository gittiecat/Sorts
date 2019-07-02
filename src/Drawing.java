import javax.swing.*;
import java.awt.*;

public class Drawing extends AbstractDrawing {

    static void updateGraph() {

    }

    private void doSortType() {
        switch (sortTypes.getSelectedIndex())
        {
            case 0:
                BubbleSort.sort(Sort.getArray());
                break;
            case 1:
                InsertionSort.sort(Sort.getArray());
                break;
            case 2: System.out.println("sort not found");
            break;
            case 3: System.out.println("sort not found");
            break;
        }
    }

    void addListeners() {
//        buttonShuffle.addActionListener(e -> shuffle());
        buttonShuffle.addActionListener(e -> System.out.println("look at me"));
        buttonSort.addActionListener(e -> doSortType());
    }

    Drawing() {
        updateGraph();
    }
}