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

    /**
     * Object constructor for window which will be used to draw
     */
    AbstractDrawing() {
        this.setLayout(new BorderLayout());

        JPanel graph = new JPanel();
        JPanel actions = new JPanel();

        actions.setLayout(new GridLayout(3,1));
        actions.add(sortTypes);
        actions.add(buttonShuffle);
        actions.add(buttonSort);
        this.add(actions, BorderLayout.EAST);
    }
}
