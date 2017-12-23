package ru.nsu.fit.g14201.chernova.view;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by SPN on 23.12.2017.
 */
class BoardZoom extends Board {

    private JFrame zoomedBoard = new JFrame();

    public BoardZoom(JFrame locateRelative) {
        super(25);

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
        //zoomedBoard.d
    }


}
