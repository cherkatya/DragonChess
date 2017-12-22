package ru.nsu.fit.g14201.chernova;

/**
 * Created by SPN on 23.12.2017.
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessFrame extends JFrame {

    public ChessFrame() {
        super("Dragon Chess");

        setSize(600,600);
        getContentPane().add(new Board());
        setLocationRelativeTo(null);
        setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}