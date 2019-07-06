import javax.swing.*;
import java.awt.*;

/*
 * Implementation of different sorting algorithms
 */

public class Sort {

    private static final int arraySize = 996;
    private static int[] array = new int[arraySize];
    private static Drawing panel = new Drawing();
    private static JFrame frame = new JFrame();

    /*
     * Window dimensions
     */
    private static final int DEFAULT_WIDTH = 1120;
    private static final int DEFAULT_HEIGHT = 1026;

    static int[] getArray() { return array; }

    static void insert(int[] array, int hold, int insert) {
        Drawing.getPrevState(array);
        int holding = array[hold];
        if (hold > insert) {
            for (int i = hold - 1; i >= insert; i--) {
                array[i + 1] = array[i];
            }
        }
        else {
            for (int i = hold + 1; i <= insert; i++) {
                array[i - 1] = array[i];
            }
        }
        array[insert] = holding;
//        panel.revalidate();
        panel.repaint();
    }

    static void swap(int[] array, int hold, int swap) {
        Drawing.getPrevState(array);
        int hold1 = array[hold];
        int hold2 = array[swap];
        array[swap] = hold1;
        array[hold] = hold2;
//        panel.revalidate();
        panel.repaint();
    }

    static void shuffle(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            int randIndex = (int)(Math.random()*i);
            swap(array,randIndex, i + 1);
        }
        toString(array);
    }

    private void initialise() {
        for (int i = 0; i < getArray().length; i++) {
            array[i] = i + 1;
        }
        shuffle(getArray());
        toString(getArray());
    }

    static void toString(int[] array) {
        for (int i = 0; i < getArray().length; i++) {
            System.out.println(array[i]);
        }
    }

    static void checkRepeat(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = i; j < array.length; j++) {
                if(array[i] == array[j] && i != j) {
                    System.out.println("Repetition at (" + i + "," + j + ")!");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Sort().initialise();

        panel.addListeners();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(panel);
    }
}