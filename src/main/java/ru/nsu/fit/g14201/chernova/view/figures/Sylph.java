package ru.nsu.fit.g14201.chernova.view.figures;

import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;
import ru.nsu.fit.g14201.chernova.view.FigureView;
import ru.nsu.fit.g14201.chernova.view.Team;

/**
 * Created by RARETA on 23.12.2017.
 */
public class Sylph extends FigureView {
    private ImagePanel image;

    public Sylph(FieldCoordinateView coord, Team team) {
        super(coord, team);
        image = new ImagePanel("S");
    }

    @Override
    public ImagePanel getImage() {
        return image;
    }
}
