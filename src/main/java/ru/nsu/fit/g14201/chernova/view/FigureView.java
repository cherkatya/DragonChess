package ru.nsu.fit.g14201.chernova.view;

import ru.nsu.fit.g14201.chernova.view.figures.ImagePanel;

/**
 * Created by RARETA on 23.12.2017.
 */
public abstract class FigureView {

    public FigureView(FieldCoordinateView coord, Team team) {
        this.coord = coord;
        this.team = team;
    }

    public abstract ImagePanel getImage();

    public FieldCoordinateView getCoord() {
        return coord;
    }

    public void setCoord(FieldCoordinateView coord) {
        this.coord = coord;
    }

    private FieldCoordinateView coord;

    public Team getTeam() {
        return team;
    }

    private final Team team;
}
