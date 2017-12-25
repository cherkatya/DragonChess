package ru.nsu.fit.g14201.chernova.view.utils.boards;

import com.sun.istack.internal.Nullable;
import ru.nsu.fit.g14201.chernova.view.FigureView;
import ru.nsu.fit.g14201.chernova.view.figures.*;
import ru.nsu.fit.g14201.chernova.view.utils.TeamView;

import java.awt.*;

/**
 * Created by castiel on 25.12.2017.
 */
public class BottomBoard extends Board {
    public BottomBoard(Dimension cellSize, @Nullable FigureView[][] _field) {
        super(cellSize, _field);
        if (_field == null) {
            for (int i = 0; i < 6; i++) {
                FigureView figure = new Dwarf(
                        TeamView.GOLDEN, cellSize);
                setFigure(i * 2 + 1, 1, figure);
            }

            setFigure(2, 0, new Basilisk(
                    TeamView.GOLDEN, cellSize));
            setFigure(10, 0, new Basilisk(
                    TeamView.GOLDEN, cellSize));

            setFigure(6, 0, new Elemental(
                    TeamView.GOLDEN, cellSize));

            //-------------------CRIMSON-----------------------//

            for (int i = 0; i < 6; i++) {
                FigureView figure = new Dwarf(
                        TeamView.CRIMSON, cellSize);
                setFigure(i * 2 + 1, 6, figure);
            }

            setFigure(2, 7, new Basilisk(
                    TeamView.CRIMSON, cellSize));
            setFigure(10, 7, new Basilisk(
                    TeamView.CRIMSON, cellSize));

            setFigure(6, 7, new Elemental(
                    TeamView.CRIMSON, cellSize));
        }
    }

    @Override
    public int getNumber() {
        return 2;
    }

    @Override
    public Board clone(Dimension cellSize, @Nullable FigureView[][] field) {
        return new BottomBoard(cellSize, field);
    }
}
