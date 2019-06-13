import javax.swing.*;
import java.awt.*;

public abstract class AbstractDrawing extends JPanel{

    protected JButton buttonShuffle = new JButton("Shuffle");

    protected JButton buttonSort = new JButton("Sort");

    protected String[] sorts = {
            "Bubble Sort",
            "Insertion Sort",
            "Selection Sort",
            "QuickSort"
    };
    protected JComboBox<String> sortTypes = new JComboBox<>(sorts);

    /**
     * Object constructor for window which will be used to draw
     */
    protected AbstractDrawing() {
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
