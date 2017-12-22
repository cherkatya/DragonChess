package ru.nsu.fit.g14201.chernova;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;

/**
 * Created by SPN on 23.12.2017.
 */
public class ChessFrame extends JFrame {
    private Color backgroundColor = Color.LIGHT_GRAY;
    private Dimension frameSize = new Dimension(1000, 600);

    public ChessFrame() {
        super("Dragon Chess");

        setSize(frameSize);
        setLocationRelativeTo(null);    //set frame in center of screen
        setLayout(new GridLayout(3, 1, 0, 0));
//        add(Box.createVerticalGlue());
//        add(Box.createVerticalGlue());
//        add(Box.createVerticalGlue());
        add(new Board());
        add(new Board());
        add(new Board());
//        add(Box.createVerticalGlue());
//        add(Box.createVerticalGlue());
//        add(Box.createVerticalGlue());
        setBackground(backgroundColor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

