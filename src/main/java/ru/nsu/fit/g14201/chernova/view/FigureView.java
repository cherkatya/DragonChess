package ru.nsu.fit.g14201.chernova.view;

import ru.nsu.fit.g14201.chernova.view.utils.TeamView;
import ru.nsu.fit.g14201.chernova.view.figures.FigureImage;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by RARETA on 23.12.2017.
 */
public abstract class FigureView {
    private FigureImage image;

    public FigureView(TeamView team, Dimension size) {
        //this.coord = coord;
        this.team = team;
        image = new FigureImage(getStringViewFigure(), TeamView.getFigureColor(team), size);
    }

    public void resizeImage(Dimension newSize) {
        image = new FigureImage(getStringViewFigure(), TeamView.getFigureColor(team), newSize);
    }

    public abstract String getStringViewFigure();

    public BufferedImage getImage() {
        return image.image;
    }

//    public FieldCoordinateView getCoord() {
//        return coord;
//    }

//    public void setCoord(FieldCoordinateView coord) {
//        this.coord = coord;
//    }

    private FieldCoordinateView coord;

    public TeamView getTeam() {
        return team;
    }

    private final TeamView team;
}
