package ru.nsu.fit.g14201.chernova.view.utils.boards;

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

    {
        for (int i = 0; i < 6; i++) {
            FigureView figure = new Sylph(new FieldCoordinateView(0, i * 2, 1),
                    TeamView.GOLDEN, cellSize);
            setFigure(i * 2, 1, figure);
        }
    }

    public UpperBoard(Dimension cellSize) {
        super(cellSize);
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public Board clone(Dimension cellSize) { return new UpperBoard(cellSize); }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
