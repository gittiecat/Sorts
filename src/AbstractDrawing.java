import javax.swing.*;
import java.awt.*;

class AbstractDrawing extends JPanel{

    JButton buttonShuffle = new JButton("Shuffle");
    JButton buttonSort = new JButton("Sort");
    private static final int x = Sort.getArray().length/6; //array size divided by the amount of different colours

    private String[] sorts = {
            "Bubble Sort",
            "Insertion Sort",
            "Selection Sort",
            "QuickSort"
    };

    protected JComboBox<String> sortTypes = new JComboBox<>(sorts);

    protected JPanel graph = new JPanel();
    protected JPanel actions = new JPanel();

    public void paintComponent(Graphics g) {
        int[] array = Sort.getArray();
        for (int i = 0; i < array.length; i++) {
            g.setColor(getColor(i, array));
            g.drawLine(i + 10, array.length, i + 10, array.length - array[i]);
        }
    }

//    static void drawUpdate(Graphics g) {
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

    public static Color getColor(int i,int[] array) {
        int c = array[i]/x;
        int val = (int)(((double)array[i]/(double)x - c)*255);
        if (c == 0) { return (new Color(255, val,0)); }
        else if (c == 1) { return(new Color(255 - val, 255, 0)); }
        else if (c == 2) { return (new Color(0,255, val)); }
        else if (c == 3) { return (new Color(0,255 - val,255)); }
        else if (c == 4) { return (new Color( val,0,255)); }
        else { return (new Color(255,0,255 - val)); }
    }

//    public Color getColor(int i, int[] array, Graphics g) {
//        int c = array[i]/x;
//        int val = (int)(((double)array[i]/(double)x - c)*255);
//        if (c == 0) { g.setColor(new Color(255, val,0)); }
//        else if (c == 1) { g.setColor(new Color(255 - val, 255, 0)); }
//        else if (c == 2) { g.setColor(new Color(0,255, val)); }
//        else if (c == 3) { g.setColor(new Color(0,255 - val,255)); }
//        else if (c == 4) { g.setColor(new Color( val,0,255)); }
//        else { g.setColor(new Color(255,0,255 - val)); }
//    }

//    public void drawUpdate(Graphics g) {
//        int[] prevState = currentState;
//        int[] newState = Sort.getArray();
//        for (int i = 0; i < Sort.getArray().length; i++) {
//            if (prevState[i] != newState[i]) {
//                g.setColor(Color.WHITE);
//                g.drawLine(i,0,i,prevState[i]);
//                g.setColor(getColor(i, newState, g));
//            }
//        }
//    }

    /**
     * Object constructor for window which will be used to draw
     */
    AbstractDrawing() {
        this.setLayout(new BorderLayout());

        actions.setLayout(new GridLayout(3,1));
        actions.add(sortTypes);
        actions.add(buttonSort);
        actions.add(buttonShuffle);
        this.add(actions, BorderLayout.EAST);
        this.add(graph, BorderLayout.WEST);
    }
}
