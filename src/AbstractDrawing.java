import javax.swing.*;
import java.awt.*;

abstract class AbstractDrawing extends JPanel{

    JButton buttonShuffle = new JButton("Shuffle");

    JButton buttonSort = new JButton("Sort");

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
            g.setColor(new Color((int) (array[i]/3.90625), 0, 255));
            g.drawLine( i, array.length, i, array[i]);
        }
    }

    /**
     * Object constructor for window which will be used to draw
     */
    AbstractDrawing() {
        this.setLayout(new BorderLayout());

        actions.setLayout(new GridLayout(3,1));
        actions.add(sortTypes);
        actions.add(buttonShuffle);
        actions.add(buttonSort);
        this.add(actions, BorderLayout.EAST);
        this.add(graph, BorderLayout.WEST);
    }
}
