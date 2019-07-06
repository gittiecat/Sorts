import javax.swing.*;
import java.awt.*;

class Drawing extends JPanel{

    private JButton buttonShuffle = new JButton("Shuffle");
    private JButton buttonSort = new JButton("Sort");
    private static final int x = Sort.getArray().length/6; //array size divided by the amount of different colours
    private static int[] currentState = null;
    private JPanel graph = new JPanel();
    private static int count = 0;

    static void getPrevState(int[] array) {
        currentState = array.clone();
    }

    private String[] sorts = {
            "Bubble Sort",
            "Insertion Sort",
            "Selection Sort",
            "QuickSort"
    };

    private JComboBox<String> sortTypes = new JComboBox<>(sorts);

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (count == 0) { initialise(g); count++; }
        drawUpdate(g);
    }

    private void drawUpdate(Graphics g) {
        int[] prevState = currentState;
        int[] newState = Sort.getArray();
        for (int i = 0; i < Sort.getArray().length; i++) {
            g.setColor(Color.WHITE);
            g.drawLine(i + 10, newState.length, i + 10, newState.length - prevState[i]);
            g.setColor(getColor(i, newState));
            g.drawLine(i + 10, newState.length, i + 10, newState.length - newState[i]);
        }
    }

    private void initialise(Graphics g) {
        int[] array = Sort.getArray();
        for (int i = 0; i < array.length; i++) {
            g.setColor(getColor(i, array));
            g.drawLine(i + 10, array.length, i + 10, array.length - array[i]);
        }
    }

    public static Color getColor(int i,int[] array) {
        int c = array[i]/x;
        int val = (int)(((double)array[i]/(double)x - c)*255);
        if (c == 0) { return (new Color(255, val,0)); }
        else if (c == 1) { return (new Color(255 - val, 255, 0)); }
        else if (c == 2) { return (new Color(0,255, val)); }
        else if (c == 3) { return (new Color(0,255 - val,255)); }
        else if (c == 4) { return (new Color( val,0,255)); }
        else { return (new Color(255,0,255 - val)); }
    }

    void addListeners() {
        buttonShuffle.addActionListener(e -> Sort.shuffle(Sort.getArray()));
        buttonSort.addActionListener(e -> doSortType());
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

    /**
     * Object constructor for window which will be used to draw
     */
    Drawing() {
        this.setLayout(new BorderLayout());

        JPanel actions = new JPanel();
        actions.setLayout(new GridLayout(3,1));
        actions.add(sortTypes);
        actions.add(buttonSort);
        actions.add(buttonShuffle);
        this.add(actions, BorderLayout.EAST);
        this.add(graph, BorderLayout.WEST);
    }
}
