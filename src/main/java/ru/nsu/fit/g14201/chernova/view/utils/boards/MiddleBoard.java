package ru.nsu.fit.g14201.chernova.view.utils.boards;

import java.awt.*;

/**
 * Created by castiel on 25.12.2017.
 */
public class MiddleBoard extends Board {
    public MiddleBoard(Dimension cellSize) {
        super(cellSize);
    }

    @Override
    public int getNumber() {
        return 1;
    }

    @Override
    public Board clone(Dimension cellSize) { return new MiddleBoard(cellSize); }
}
