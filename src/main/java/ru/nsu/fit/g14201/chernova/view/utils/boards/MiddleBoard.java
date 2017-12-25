package ru.nsu.fit.g14201.chernova.view.utils.boards;

import com.sun.istack.internal.Nullable;
import ru.nsu.fit.g14201.chernova.view.FigureView;

import java.awt.*;

/**
 * Created by castiel on 25.12.2017.
 */
public class MiddleBoard extends Board {
    public MiddleBoard(Dimension cellSize, @Nullable FigureView[][] field) {
        super(cellSize, field);
    }

    @Override
    public int getNumber() {
        return 1;
    }

    @Override
    public Board clone(Dimension cellSize, @Nullable FigureView[][] field) {
        return new MiddleBoard(cellSize, field);
    }
}
