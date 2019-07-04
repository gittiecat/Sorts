import javax.swing.*;
import java.awt.*;

public class Drawing extends AbstractDrawing {

    private static int[] currentState;

    public void upd() {

    }

//    static void drawUpdate() {
//        int[] prevState = currentState;
//        int[] newState = Sort.getArray();
//        for (int i = 0; i < Sort.getArray().length; i++) {
//            if (prevState[i] != newState[i]) {
//                g.setColor(Color.WHITE);
//                g.drawLine(i,0,i,prevState[i]);
//                g.setColor(getColor(i, newState));
//                g.drawLine(i, 0, i, newState[i]);
//            }
//        }
//    }

    static void getPrevState(int[] array) {
        currentState = array;
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
}