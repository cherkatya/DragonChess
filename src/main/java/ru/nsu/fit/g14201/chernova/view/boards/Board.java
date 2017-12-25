package ru.nsu.fit.g14201.chernova.view.boards;

import org.apache.log4j.Logger;
import ru.nsu.fit.g14201.chernova.view.TeamView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by RARETA on 23.12.2017.
 */
public abstract class Board extends JPanel {
    private static Logger log = Logger.getLogger(Board.class);

    private final Color goldenSideColor = TeamView.getCellColor(TeamView.CRIMSON, 0);
    private final Color crimsonSideColor = TeamView.getCellColor(TeamView.GOLDEN, 0);

    //private final Point position = new Point(0, 0);
    protected final int ROWS = 8;
    protected final int COLUMNS = 12;
    protected final Dimension cellSize;

    public Dimension getBoardSize() { return boardSize; }

    public abstract int getNumber();
    public abstract Board clone(Dimension cellSize);

    protected final Dimension boardSize;

    public Board(Dimension cellSize) {
        this.cellSize = cellSize;
        log.debug(cellSize);
        this.boardSize = new Dimension(COLUMNS * this.cellSize.width, ROWS * this.cellSize.height);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
    }

    private JFrame zoomedBoard;
    public void addZoom() {
        zoomedBoard = new JFrame();
        zoomedBoard.setLocationRelativeTo(null);
        Board boardPanel = this.clone(new Dimension(cellSize.width * 2, cellSize.height * 2));
        zoomedBoard.add(boardPanel);
        zoomedBoard.setSize(boardPanel.getBoardSize());
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

    @Override
    public void paintComponent(Graphics g){
        g.setColor(goldenSideColor);
        g.fillRect(0, 0, boardSize.width, boardSize.height);

        g.setColor(crimsonSideColor);
        for(int i = 0; i < boardSize.width; i += 2 * cellSize.width){
            for(int j = 0; j < boardSize.height; j += 2 * cellSize.height){
                g.fillRect(i, j, cellSize.width, cellSize.height);
            }
        }

        for(int i = cellSize.width; i < boardSize.width; i += 2 * cellSize.width){
            for(int j = cellSize.height; j < boardSize.height; j += 2 * cellSize.height){
                g.fillRect(i, j, cellSize.width, cellSize.height);
            }
        }
    }

}
