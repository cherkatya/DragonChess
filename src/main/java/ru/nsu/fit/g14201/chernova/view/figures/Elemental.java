package ru.nsu.fit.g14201.chernova.view.figures;

import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;
import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;
import ru.nsu.fit.g14201.chernova.view.FigureView;
import ru.nsu.fit.g14201.chernova.view.utils.TeamView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Катя on 21.12.2017.
 */
public class Elemental extends FigureView {
    public Elemental(TeamView team, Dimension size) {
        super(team, size);
    }

    @Override
    public String getStringViewFigure() {
        return "E";
    }
}