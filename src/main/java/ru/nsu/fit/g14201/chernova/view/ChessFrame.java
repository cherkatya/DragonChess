package ru.nsu.fit.g14201.chernova.view;

import ru.nsu.fit.g14201.chernova.utils.ChessDragonView;
import ru.nsu.fit.g14201.chernova.utils.FigureView;
import ru.nsu.fit.g14201.chernova.utils.figures.Sylph;
import ru.nsu.fit.g14201.chernova.view.boards.Board;
import ru.nsu.fit.g14201.chernova.view.boards.BottomBoard;
import ru.nsu.fit.g14201.chernova.view.boards.MiddleBoard;
import ru.nsu.fit.g14201.chernova.view.boards.UpperBoard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SPN on 23.12.2017.
 */
public class ChessFrame extends JFrame implements ChessDragonView {
    private Color backgroundColor = Color.DARK_GRAY;
    private Dimension frameSize = new Dimension(1000,
            Toolkit.getDefaultToolkit().getScreenSize().height - 50);
    private final int CELL_SIZE = 25;
    private Dimension boardSize = new Dimension(CELL_SIZE, CELL_SIZE);

    private Board[] field;

    {
        field = new Board[3];
        field[0] = new UpperBoard(boardSize);
        field[1] = new UpperBoard(boardSize);
        field[2] = new UpperBoard(boardSize);
        for (int i = 0; i < 3; i++)
            field[i].addZoom();
    }

    public ChessFrame() {
        super("Dragon Chess");

        setSize(frameSize);
        setLocationRelativeTo(null);    //set frame in center of screen
        setLayout(new GridLayout(3, 3, 0, 0));
        add(Box.createHorizontalGlue());
        add(field[0]);
        add(Box.createHorizontalGlue());
        add(Box.createHorizontalGlue());
        add(field[1]);
        add(Box.createHorizontalGlue());
        add(Box.createHorizontalGlue());
        add(field[2]);
        add(Box.createHorizontalGlue());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        List<FieldCoordinateView> posMoves = new ArrayList<>();
//        posMoves.add(new FieldCoordinateView(1, 1, 1));
//        showPossibleMoves(posMoves);
    }

    @Override
    public void showPossibleMoves(List<FieldCoordinateView> possibleMoves) {
        for (FieldCoordinateView coord : possibleMoves) {
            field[coord.getBoard()].highlightCellAsMove(new Point(coord.getX(), coord.getY()));
        }
    }

    @Override
    public void showPossibleAttacks() {

    }

    @Override
    public void makeMove() {

    }

    @Override
    public void switchTurn() {

    }

    @Override
    public void check() {

    }

    @Override
    public void checkAndMate() {

    }

    @Override
    public void tie() {

    }
}

