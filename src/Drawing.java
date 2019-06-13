import javax.swing.*;
import java.awt.*;

public class Drawing extends AbstractDrawing {

    public Drawing() {
        super();

    }

    private void addListeners() {
        buttonShuffle.addActionListener(e -> Sort.shuffle(new Sort().getArray()));
//        buttonSort.addActionListener(e -> );
    }
}