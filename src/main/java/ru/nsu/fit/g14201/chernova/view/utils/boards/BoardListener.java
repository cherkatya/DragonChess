package ru.nsu.fit.g14201.chernova.view.utils.boards;

import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;

/**
 * Created by castiel on 26.12.2017.
 */
public interface BoardListener {
    abstract void selectCell(FieldCoordinateView coord);
}
