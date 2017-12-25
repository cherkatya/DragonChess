package ru.nsu.fit.g14201.chernova.view.figures;

import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;
import ru.nsu.fit.g14201.chernova.view.FigureView;
import ru.nsu.fit.g14201.chernova.view.utils.TeamView;

import java.awt.*;

/**
 * Created by RARETA on 23.12.2017.
 */
public class Sylph extends FigureView {
    public Sylph(TeamView team, Dimension size) {
        super(team, size);
    }

    @Override
    public String getStringViewFigure() {
        return "S";
    }
}
