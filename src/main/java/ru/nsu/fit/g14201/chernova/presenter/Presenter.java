package ru.nsu.fit.g14201.chernova.presenter;

import org.apache.log4j.Logger;
import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.GameModel;
import ru.nsu.fit.g14201.chernova.view.ChessDragonView;
import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;

/**
 * Created by castiel on 26.12.2017.
 */
public class Presenter {
    private static Logger log = Logger.getLogger(Presenter.class);

    private GameModel model;
    private Field field;
    private FieldCoordinate selectedCell;

    public Presenter() {
        field = new Field();
        model = new GameModel(field);
        selectedCell = null;
    }

    public ChessDragonView getView() {
        return view;
    }

    public void setView(ChessDragonView view) {
        this.view = view;
    }

    private ChessDragonView view;

    public void selectCell(FieldCoordinateView cellCoord) {
        log.debug("Coord = " + cellCoord.getBoard() + " " + cellCoord.getX() + " " + cellCoord.getY());
    }

    public void start()
    {
        field.populate();
    }
}
