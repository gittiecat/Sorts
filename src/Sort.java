import javax.swing.*;

/*
 * Implementation of different sorting algorithms
 */

public class Sort {

    private static final int arraySize = 996;
    private static int[] array = new int[arraySize];
    static Drawing panel = new Drawing();
    static JFrame frame = new JFrame();
    private static int counter = 0;

    /*
     * Window dimensions
     */
    public static final int DEFAULT_WIDTH = 1127;
    public static final int DEFAULT_HEIGHT = 1026;

    static int[] getArray() { return array; }

    public static void gUpdate() {
        panel.paintImmediately(10,0, 1006,1026);
        try {
            Thread.sleep(1);
        }
        catch (InterruptedException e){

        }
    }

    static void insert(int[] array, int hold, int insert) {
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
        gUpdate();
    }

    static void swap(int[] array, int hold, int swap) {
        int hold1 = array[hold];
        int hold2 = array[swap];
        array[swap] = hold1;
        array[hold] = hold2;
        if (counter%500 == 0) { gUpdate(); counter = 0; }
        counter++;
    }

    static void shuffle(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            int randIndex = (int)(Math.random()*i);
            swap(array,randIndex, i + 1);
            gUpdate();
        }
    }

    private void initialise() {
        for (int i = 0; i < getArray().length; i++) {
            array[i] = (int)(Math.random()*getArray().length + 1);
//            array[i] = i + 1;
        }
        shuffle(getArray());
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
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        DrawingRunnable d = new DrawingRunnable(DEFAULT_WIDTH, DEFAULT_HEIGHT, frame, panel);
        Thread dt = new Thread(d);

        dt.start();
    }
}

class DrawingRunnable implements Runnable {
    private int def_width;
    private int def_height;
    private JFrame window;
    private Drawing canvas;

    DrawingRunnable(final int DEFAULT_WIDTH, final int DEFAULT_HEIGHT, JFrame frame, Drawing panel) {
        def_width = DEFAULT_WIDTH;
        def_height = DEFAULT_HEIGHT;
        window = frame;
        canvas = panel;
    }

    public void run() {
        System.out.println("Starting new drawing thread...");

        canvas.addListeners();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(def_width, def_height);
        window.setVisible(true);
        window.setResizable(false);
        window.add(canvas);
    }
}