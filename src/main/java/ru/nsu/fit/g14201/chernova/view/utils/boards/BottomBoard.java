package ru.nsu.fit.g14201.chernova.view.utils.boards;

import java.awt.*;

/**
 * Created by castiel on 25.12.2017.
 */
public class BottomBoard extends Board {
    public BottomBoard(Dimension cellSize) {
        super(cellSize);
    }

    @Override
    public int getNumber() {
        return 2;
    }

    @Override
    public Board clone(Dimension cellSize) { return new BottomBoard(cellSize); }
}
