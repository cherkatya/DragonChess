package ru.nsu.fit.g14201.chernova.view;

import org.junit.Test;
import ru.nsu.fit.g14201.chernova.presenter.Presenter;
import ru.nsu.fit.g14201.chernova.view.utils.ChessFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by castiel on 26.12.2017.
 */
public class ShowPossibleMovesTest {
    @Test
    public void upFigureCountTest(){
        Presenter presenter = new Presenter();
        ChessFrame chessFrame = new ChessFrame(presenter);
        presenter.setView(chessFrame);

        List<FieldCoordinateView> posMoves = new ArrayList<>();
        posMoves.add(new FieldCoordinateView(1, 1, 1));
        chessFrame.showPossibleMoves(new FieldCoordinateView(1, 2, 2), posMoves);

        assertEquals(chessFrame.getField()[1].getHighlightedCellsAsMove().get(0), new Point(1, 1));
    }
}
