package ru.nsu.fit.g14201.chernova;

import javax.swing.*;
import java.awt.*;

/**
 * Created by SPN on 23.12.2017.
 */
public class ChessFrame extends JFrame {
    private Color backgroundColor = Color.DARK_GRAY;
    private Dimension frameSize = new Dimension(1000, 900);

    public ChessFrame() {
        super("Dragon Chess");

        //setBackground(backgroundColor);
        //setForeground(backgroundColor);
        setSize(frameSize);
        //setExtendedState(JFrame.MAXIMIZED_VERT);
        setLocationRelativeTo(null);    //set frame in center of screen
        setLayout(new GridLayout(3, 3, 0, 0));
//        add(Box.createVerticalGlue());
//        add(Box.createVerticalGlue());
//        add(Box.createVerticalGlue());
        add(Box.createHorizontalGlue());
        add(new BoardZoom(this));
        add(Box.createHorizontalGlue());
        add(Box.createHorizontalGlue());
        add(new BoardZoom(this));
        add(Box.createHorizontalGlue());
        add(Box.createHorizontalGlue());
        add(new BoardZoom(this));
        add(Box.createHorizontalGlue());
//        add(Box.createVerticalGlue());
//        add(Box.createVerticalGlue());
//        add(Box.createVerticalGlue());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

