package ru.nsu.fit.g14201.chernova.view.utils;

import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.presenter.Presenter;
import ru.nsu.fit.g14201.chernova.view.ChessDragonView;
import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;
import ru.nsu.fit.g14201.chernova.view.utils.boards.Board;
import ru.nsu.fit.g14201.chernova.view.utils.boards.UpperBoard;

import javax.swing.*;
import java.awt.*;
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

    public Board[] getField() {
        return field;
    }

    private final Presenter presenter;
    private Board[] field;

    {
        field = new Board[3];
        field[0] = new UpperBoard(boardSize);
        field[1] = new UpperBoard(boardSize);
        field[2] = new UpperBoard(boardSize);
        for (int i = 0; i < 3; i++)
            field[i].addZoom();
    }

    public ChessFrame(Presenter presenter) {
        super("Dragon Chess");
        this.presenter = presenter;

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
    }

    @Override
    public void showPossibleMoves(FieldCoordinateView figure, List<FieldCoordinateView> possibleMoves) {
        for (FieldCoordinateView coord : possibleMoves) {
            field[coord.getBoard()].highlightCellAsMove(new Point(coord.getX(), coord.getY()));
        }
    }

    @Override
    public void showPossibleAttacks(FieldCoordinateView figure, List<FieldCoordinateView> possibleAttacks) {

    }

    @Override
    public void makeMove(FieldCoordinateView from, FieldCoordinateView to, boolean isAttack) {

    }

    @Override
    public void switchTurnTo(TeamView team) {

    }

    @Override
    public void check(TeamView toWhom, FieldCoordinate figureWhoMakeCheck, FieldCoordinate figureThatUnderCheck) {

    }

    @Override
    public void checkAndMate(TeamView toWhom, FieldCoordinate figureWhoMakeCheckAndMate, FieldCoordinate figureThatUnderCheckAndMate) {

    }

    @Override
    public void tie() {

    }
}

