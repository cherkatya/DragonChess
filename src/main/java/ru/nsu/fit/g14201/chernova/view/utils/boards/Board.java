package ru.nsu.fit.g14201.chernova.view.utils.boards;

import org.apache.log4j.Logger;
import ru.nsu.fit.g14201.chernova.view.FigureView;
import ru.nsu.fit.g14201.chernova.view.utils.TeamView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by RARETA on 23.12.2017.
 */
public abstract class Board extends JPanel {
    private static Logger log = Logger.getLogger(Board.class);

    public Board(Dimension cellSize) {
        this.cellSize = cellSize;
        //log.debug(cellSize);
        this.boardSize = new Dimension(COLUMNS * this.cellSize.width, ROWS * this.cellSize.height);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (e.getButton() == MouseEvent.BUTTON1) {
                    clearHighlightedCellsAsMove();

                    Point clickPoint = e.getPoint();
                    // clickPoint -> get FieldCoord
                    int j = (int) Math.floor(clickPoint.x * 1.0f / cellSize.width);
                    int i = (int) Math.floor(clickPoint.y * 1.0f / cellSize.height);
                    log.debug("clicked (" + j + " x, " + i + " y)");
                }
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

    public ArrayList<Point> getHighlightedCellsAsMove() {
        return highlightedCellsAsMove;
    }

    private ArrayList<Point> highlightedCellsAsMove = new ArrayList<>();

    public void highlightCellAsMove(Point p) {
        highlightedCellsAsMove.add(p);
    }

    public void clearHighlightedCellsAsMove() {
        highlightedCellsAsMove.clear();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(goldenSideColor);
        g.fillRect(0, 0, boardSize.width, boardSize.height);

        g.setColor(crimsonSideColor);
        for(int i = 0; i < boardSize.height; i += 2 * cellSize.height){
            for(int j = 0; j < boardSize.width; j += 2 * cellSize.width){
                g.fillRect(j, i, cellSize.width, cellSize.height);
            }
        }

        for(int i = cellSize.width; i < boardSize.height; i += 2 * cellSize.height){
            for(int j = cellSize.height; j < boardSize.width; j += 2 * cellSize.width){
                g.fillRect(j, i, cellSize.width, cellSize.height);
            }
        }

        g.setColor(moveHighlighting);
        for (Point p : highlightedCellsAsMove) {
            g.fillRect(p.x * cellSize.width, p.y * cellSize.height, cellSize.width, cellSize.height);
        }
    }

    private final Color goldenSideColor = TeamView.getCellColor(TeamView.CRIMSON, getNumber());
    private final Color crimsonSideColor = TeamView.getCellColor(TeamView.GOLDEN, getNumber());
    private final Color moveHighlighting = new Color(255, 241, 69);

    //private final Point position = new Point(0, 0);
    protected final int ROWS = 8;
    protected final int COLUMNS = 12;
    protected final Dimension cellSize;
    protected final Dimension boardSize;

    public Dimension getBoardSize() { return boardSize; }

    private FigureView[][] field;
    {
        field = new FigureView[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLUMNS; j++)
                field[i][j] = null;
    }
    public FigureView getFigure(int x, int y) { return field[y][x]; }
    public void setFigure(int x, int y, FigureView figure) { field[y][x] = figure; }

    public abstract int getNumber();
    public abstract Board clone(Dimension cellSize);

}
