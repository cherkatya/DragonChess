package ru.nsu.fit.g14201.chernova;

/**
 * Created by SPN on 23.12.2017.
 */
import org.w3c.dom.css.RGBColor;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessFrame extends JFrame {

    private Color backgroundColor = Color.LIGHT_GRAY;

    public ChessFrame() {
        super("Dragon Chess");

        setSize(600,600);
        getContentPane().add(new Board());
        setLocationRelativeTo(null);
        setBackground(backgroundColor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}