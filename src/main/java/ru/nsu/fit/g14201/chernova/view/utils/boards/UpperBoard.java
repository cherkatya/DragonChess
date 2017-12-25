package ru.nsu.fit.g14201.chernova.view.utils.boards;

import com.sun.istack.internal.Nullable;
import org.apache.log4j.Logger;
import ru.nsu.fit.g14201.chernova.view.FigureView;
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

    public UpperBoard(Dimension cellSize, @Nullable FigureView[][] field) {
        super(cellSize, field);
        if (field == null) {
            for (int i = 0; i < 6; i++) {
                FigureView figure = new Sylph(new FieldCoordinateView(0, i * 2, 1),
                        TeamView.GOLDEN, cellSize);
                setFigure(i * 2, 1, figure);
            }
            log.debug("Cell size = " + cellSize);
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
