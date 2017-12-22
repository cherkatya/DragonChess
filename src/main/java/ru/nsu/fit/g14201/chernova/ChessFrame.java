package ru.nsu.fit.g14201.chernova;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;

/**
 * Created by SPN on 23.12.2017.
 */
public class ChessFrame extends JFrame {
    private Color backgroundColor = Color.LIGHT_GRAY;
    private Dimension frameSize = new Dimension(600, 600);

    public ChessFrame() {
        super("Dragon Chess");

        setSize(frameSize);
        //setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));
        add(new Board());
        add(new Board());
        setBackground(backgroundColor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
