import javax.swing.*;
import java.awt.*;

public class Drawing extends AbstractDrawing {

    Drawing() {
        super();
    }

    private void doSortType() {
        switch (sortTypes.getSelectedIndex())
        {
            case 0:
                BubbleSort.sort(new Sort().getArray());
                break;
            case 1:
                InsertionSort.sort(new Sort().getArray());
                break;
            case 2: System.out.println("no such sort");
            break;
            case 3: System.out.println("no such sort");
            break;
        }
    }
    void addListeners() {
        buttonShuffle.addActionListener(e -> Sort.shuffle(new Sort().getArray()));
        buttonSort.addActionListener(e -> doSortType());
    }
}