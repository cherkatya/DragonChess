package ru.nsu.fit.g14201.chernova.view;

import org.junit.Test;
import ru.nsu.fit.g14201.chernova.presenter.Presenter;
import ru.nsu.fit.g14201.chernova.view.utils.ChessFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by castiel on 26.12.2017.
 */
public class MakeMoveTest {
    @Test
    public void upFigureCountTest(){
        Presenter presenter = new Presenter();
        ChessFrame chessFrame = new ChessFrame(presenter);
        presenter.setView(chessFrame);

        chessFrame.makeMove(new FieldCoordinateView(0, 0, 1),
                new FieldCoordinateView(1, 0, 1), false);

        assertNotNull(chessFrame.getField()[1].getFigure(0, 1));
        assertEquals(chessFrame.getField()[0].getFigure(0, 1), null);
    }
}
