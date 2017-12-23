package ru.nsu.fit.g14201.chernova.view;

/**
 * Created by RARETA on 23.12.2017.
 */
public class FieldView {
    private FigureView[][][] field = new FigureView[3][8][12];

    public void setFigure(FigureView figure, FieldCoordinateView coords){
        field[coords.getBoard()][coords.getY()][coords.getX()] = figure;
    }
    public FigureView getFigure(FieldCoordinateView coords){
        return field[coords.getBoard()][coords.getY()][coords.getX()];
    }
}
