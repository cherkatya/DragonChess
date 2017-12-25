package ru.nsu.fit.g14201.chernova.view.utils.boards;

import com.sun.istack.internal.Nullable;
import ru.nsu.fit.g14201.chernova.view.FigureView;

import java.awt.*;

/**
 * Created by castiel on 25.12.2017.
 */
public class BottomBoard extends Board {
    public BottomBoard(Dimension cellSize, @Nullable FigureView[][] field) {
        super(cellSize, field);
    }

    @Override
    public int getNumber() {
        return 2;
    }

    @Override
    public Board clone(Dimension cellSize, @Nullable FigureView[][] field) {
        return new BottomBoard(cellSize, field);
    }
}
