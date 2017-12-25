package ru.nsu.fit.g14201.chernova.view.utils.boards;

import com.sun.istack.internal.Nullable;
import ru.nsu.fit.g14201.chernova.view.FigureView;
import ru.nsu.fit.g14201.chernova.view.figures.*;
import ru.nsu.fit.g14201.chernova.view.utils.TeamView;

import java.awt.*;

/**
 * Created by castiel on 25.12.2017.
 */
public class MiddleBoard extends Board {
    public MiddleBoard(Dimension cellSize, @Nullable FigureView[][] _field) {
        super(cellSize, _field);
        if (_field == null) {
            for (int i = 0; i < 12; i++) {
                FigureView figure = new Warrior(
                        TeamView.GOLDEN, cellSize);
                setFigure(i, 1, figure);
            }

            setFigure(0, 0, new Oliphant(
                    TeamView.GOLDEN, cellSize));
            setFigure(11, 0, new Oliphant(
                    TeamView.GOLDEN, cellSize));

            setFigure(1, 0, new Unicorn(
                    TeamView.GOLDEN, cellSize));
            setFigure(10, 0, new Unicorn(
                    TeamView.GOLDEN, cellSize));

            setFigure(2, 0, new Hero(
                    TeamView.GOLDEN, cellSize));
            setFigure(9, 0, new Hero(
                    TeamView.GOLDEN, cellSize));

            setFigure(3, 0, new Thief(
                    TeamView.GOLDEN, cellSize));
            setFigure(8, 0, new Thief(
                    TeamView.GOLDEN, cellSize));

            setFigure(4, 0, new Cleric(
                    TeamView.GOLDEN, cellSize));
            setFigure(5, 0, new Mage(
                    TeamView.GOLDEN, cellSize));
            setFigure(6, 0, new King(
                    TeamView.GOLDEN, cellSize));
            setFigure(7, 0, new Paladin(
                    TeamView.GOLDEN, cellSize));

            //-------------------CRIMSON-----------------------//

            for (int i = 0; i < 12; i++) {
                FigureView figure = new Warrior(
                        TeamView.CRIMSON, cellSize);
                setFigure(i, 7 - 1, figure);
            }

            setFigure(0, 7, new Oliphant(
                    TeamView.CRIMSON, cellSize));
            setFigure(11, 7, new Oliphant(
                    TeamView.CRIMSON, cellSize));

            setFigure(1, 7, new Unicorn(
                    TeamView.CRIMSON, cellSize));
            setFigure(10, 7, new Unicorn(
                    TeamView.CRIMSON, cellSize));

            setFigure(2, 7, new Hero(
                    TeamView.CRIMSON, cellSize));
            setFigure(9, 7, new Hero(
                    TeamView.CRIMSON, cellSize));

            setFigure(3, 7, new Thief(
                    TeamView.CRIMSON, cellSize));
            setFigure(8, 7, new Thief(
                    TeamView.CRIMSON, cellSize));

            setFigure(4, 7, new Cleric(
                    TeamView.CRIMSON, cellSize));
            setFigure(5, 7, new Mage(
                    TeamView.CRIMSON, cellSize));
            setFigure(6, 7, new King(
                    TeamView.CRIMSON, cellSize));
            setFigure(7, 7, new Paladin(
                    TeamView.CRIMSON, cellSize));
        }
    }

    @Override
    public int getNumber() {
        return 1;
    }

    @Override
    public Board clone(Dimension cellSize, @Nullable FigureView[][] field) {
        return new MiddleBoard(cellSize, field);
    }
}
