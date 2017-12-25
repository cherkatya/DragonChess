package ru.nsu.fit.g14201.chernova.utils;

import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;
import ru.nsu.fit.g14201.chernova.view.TeamView;
import ru.nsu.fit.g14201.chernova.utils.figures.ImagePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by RARETA on 23.12.2017.
 */
public abstract class FigureView {
    private ImagePanel image;

    public FigureView(FieldCoordinateView coord, TeamView team, Dimension size) {
        this.coord = coord;
        this.team = team;
        image = new ImagePanel(getStringViewFigure(), TeamView.getFigureColor(team), size);
    }

    public abstract String getStringViewFigure();

    public BufferedImage getImage() {
        return image.image;
    }

    public FieldCoordinateView getCoord() {
        return coord;
    }

    public void setCoord(FieldCoordinateView coord) {
        this.coord = coord;
    }

    private FieldCoordinateView coord;

    public TeamView getTeam() {
        return team;
    }

    private final TeamView team;
}
