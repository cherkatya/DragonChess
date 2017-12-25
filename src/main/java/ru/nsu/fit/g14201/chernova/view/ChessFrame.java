package ru.nsu.fit.g14201.chernova.view;

import ru.nsu.fit.g14201.chernova.utils.FigureView;
import ru.nsu.fit.g14201.chernova.utils.figures.Sylph;
import ru.nsu.fit.g14201.chernova.view.boards.BoardZoom;
import ru.nsu.fit.g14201.chernova.view.boards.BottomBoard;
import ru.nsu.fit.g14201.chernova.view.boards.MiddleBoard;
import ru.nsu.fit.g14201.chernova.view.boards.UpperBoard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by SPN on 23.12.2017.
 */
public class ChessFrame extends JFrame {
    private Color backgroundColor = Color.DARK_GRAY;
    private Dimension frameSize = new Dimension(1000,
            Toolkit.getDefaultToolkit().getScreenSize().height - 50);

    public ChessFrame() {
        super("Dragon Chess");

        //setBackground(backgroundColor);
        //setForeground(backgroundColor);
        setSize(frameSize);
        //setExtendedState(JFrame.MAXIMIZED_VERT);
        setLocationRelativeTo(null);    //set frame in center of screen
        setLayout(new GridLayout(3, 3, 0, 0));
        add(Box.createHorizontalGlue());
        add(new UpperBoard(this));
        add(Box.createHorizontalGlue());
        add(Box.createHorizontalGlue());
        add(new MiddleBoard(this));
        add(Box.createHorizontalGlue());
        add(Box.createHorizontalGlue());
        add(new BottomBoard(this));
        add(Box.createHorizontalGlue());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

