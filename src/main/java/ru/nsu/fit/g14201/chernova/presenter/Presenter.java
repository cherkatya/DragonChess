package ru.nsu.fit.g14201.chernova.presenter;

import ru.nsu.fit.g14201.chernova.view.ChessDragonView;
import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;

/**
 * Created by castiel on 26.12.2017.
 */
public class Presenter {
    public ChessDragonView getView() {
        return view;
    }

    public void setView(ChessDragonView view) {
        this.view = view;
    }

    private ChessDragonView view;


    void selectCell(FieldCoordinateView cellCoord) {

    }
}
