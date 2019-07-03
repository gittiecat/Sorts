import javax.swing.*;
import java.awt.*;

abstract class AbstractDrawing extends JPanel{

    JButton buttonShuffle = new JButton("Shuffle");
    JButton buttonSort = new JButton("Sort");

    private final int x = Sort.getArray().length/6; //array size divided by the amount of different colours

    private String[] sorts = {
            "Bubble Sort",
            "Insertion Sort",
            "Selection Sort",
            "QuickSort"
    };

    protected JComboBox<String> sortTypes = new JComboBox<>(sorts);

    protected JPanel graph = new JPanel();
    protected JPanel actions = new JPanel();

    private double kCalc(double i) {
        return i / x;
    }

    public void paintComponent(Graphics g) {
        int[] array = Sort.getArray();
        for (int i = 0; i < array.length; i++) {
            double k = kCalc(array[i]);
            int val = (int)((255/x)*k);
            int c = (int)k;
            if (c == 0) { g.setColor(new Color(255, val,0)); }
            else if (c == 1) { g.setColor(new Color(255 - val, 255, 0)); }
            else if (c == 2) { g.setColor(new Color(0,255, val)); }
            else if (c == 3) { g.setColor(new Color(0,255 - val,255)); }
            else if (c == 4) { g.setColor(new Color( val,0,255)); }
            else { g.setColor(new Color(255,0,255 - val)); }
            g.drawLine(i + 10, array.length, i + 10, array.length - array[i]);
        }
    }

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
