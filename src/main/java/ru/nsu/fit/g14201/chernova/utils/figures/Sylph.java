package ru.nsu.fit.g14201.chernova.utils.figures;

import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;
import ru.nsu.fit.g14201.chernova.utils.FigureView;
import ru.nsu.fit.g14201.chernova.view.TeamView;

import java.awt.*;

/**
 * Created by RARETA on 23.12.2017.
 */
public class Sylph extends FigureView {


    public Sylph(FieldCoordinateView coord, TeamView team, Dimension size) {
        super(coord, team, size);
    }

    @Override
    public String getStringViewFigure() {
        return "S";
    }

}
