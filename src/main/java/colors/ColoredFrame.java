package colors;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

public abstract class ColoredFrame extends JFrame {
    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    @PostConstruct
    public void init (){
        setSize(400, 400);
        getContentPane().setBackground(color);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public abstract void showOnRandomPlace();
}