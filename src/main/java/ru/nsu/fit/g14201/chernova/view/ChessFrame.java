package ru.nsu.fit.g14201.chernova.view;

import ru.nsu.fit.g14201.chernova.view.figures.Sylph;

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

        FigureView sylph = new Sylph(new FieldCoordinateView(1, 1, 1), Team.GOLDEN);


        //setBackground(backgroundColor);
        //setForeground(backgroundColor);
        setSize(frameSize);
        //setExtendedState(JFrame.MAXIMIZED_VERT);
        setLocationRelativeTo(null);    //set frame in center of screen
        setLayout(new GridLayout(3, 3, 0, 0));
        add(sylph.getImage());
        //add(Box.createHorizontalGlue());
//        add(new BoardZoom(this));
//        add(Box.createHorizontalGlue());
//        add(Box.createHorizontalGlue());
//        add(new BoardZoom(this));
//        add(Box.createHorizontalGlue());
//        add(Box.createHorizontalGlue());
//        add(new BoardZoom(this));
//        add(Box.createHorizontalGlue());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

