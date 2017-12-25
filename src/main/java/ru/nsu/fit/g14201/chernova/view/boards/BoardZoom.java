package ru.nsu.fit.g14201.chernova.view.boards;

import ru.nsu.fit.g14201.chernova.utils.figures.Sylph;
import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;
import ru.nsu.fit.g14201.chernova.view.TeamView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by SPN on 23.12.2017.
 */
public abstract class BoardZoom extends Board {

    public static final int CELL_SIZE = 25;

    private JFrame zoomedBoard = new JFrame();

    public BoardZoom(JFrame locateRelative) {
        super(CELL_SIZE);

        //this.add(new Sylph(new FieldCoordinateView(1, 1, 1), TeamView.CRIMSON).getImage());

        zoomedBoard.setLocationRelativeTo(null);
        //zoomedBoard.setLocation(locateRelative.);
        Board boardPanel = new Board(50);
        zoomedBoard.add(boardPanel);
        zoomedBoard.setSize(boardPanel.getSize());
        //zoomedBoard.setExtendedState(JFrame.MAXIMIZED_BOTH);
        zoomedBoard.setUndecorated(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // Left button
                if (e.getButton() == MouseEvent.BUTTON3) {
                    zoomedBoard.setVisible(true);
                }
            }
        });
        zoomedBoard.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                zoomedBoard.setVisible(false);
            }
        });
    }

    public abstract int getNumber();

}
