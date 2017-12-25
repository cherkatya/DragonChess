package ru.nsu.fit.g14201.chernova.view.utils.boards;

import com.sun.istack.internal.Nullable;
import org.apache.log4j.Logger;
import ru.nsu.fit.g14201.chernova.view.FigureView;
import ru.nsu.fit.g14201.chernova.view.figures.Dragon;
import ru.nsu.fit.g14201.chernova.view.figures.Griffon;
import ru.nsu.fit.g14201.chernova.view.figures.Sylph;
import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;
import ru.nsu.fit.g14201.chernova.view.utils.TeamView;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by castiel on 25.12.2017.
 */
public class UpperBoard extends Board {
    private static Logger log = Logger.getLogger(UpperBoard.class);

    public UpperBoard(Dimension cellSize, @Nullable FigureView[][] _field) {
        super(cellSize, _field);
        if (_field == null) {
            for (int i = 0; i < 6; i++) {
                FigureView figure = new Sylph(
                        TeamView.GOLDEN, cellSize);
                setFigure(i * 2, 1, figure);
            }

            setFigure(2, 0, new Griffon(
                    TeamView.GOLDEN, cellSize));
            setFigure(10, 0, new Griffon(
                    TeamView.GOLDEN, cellSize));

            setFigure(6, 0, new Dragon(TeamView.GOLDEN, cellSize));

            //-------------------CRIMSON-----------------------//

            for (int i = 0; i < 6; i++) {
                FigureView figure = new Sylph(
                        TeamView.CRIMSON, cellSize);
                setFigure(i * 2, 7 - 1, figure);
            }

            setFigure(2, 7 - 0, new Griffon(
                    TeamView.CRIMSON, cellSize));
            setFigure(10, 7 - 0, new Griffon(
                    TeamView.CRIMSON, cellSize));

            setFigure(6, 7 - 0, new Dragon(TeamView.CRIMSON, cellSize));
        }
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public Board clone(Dimension cellSize, @Nullable FigureView[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                FigureView figure = field[i][j];
                if (figure != null) {
                    figure.resizeImage(cellSize);
                }
            }
        }
        return new UpperBoard(cellSize, field);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
