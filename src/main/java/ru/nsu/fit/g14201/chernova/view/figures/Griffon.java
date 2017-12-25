package ru.nsu.fit.g14201.chernova.view.figures;

import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;
import ru.nsu.fit.g14201.chernova.view.FigureView;
import ru.nsu.fit.g14201.chernova.view.utils.TeamView;

import java.awt.*;

/**
 * Created by castiel on 26.12.2017.
 */
public class Griffon extends FigureView {
    public Griffon(TeamView team, Dimension size) {
        super(team, size);
    }

    @Override
    public String getStringViewFigure() {
        return "G";
    }
}