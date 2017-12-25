package ru.nsu.fit.g14201.chernova.view;

import org.junit.Test;
import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.utils.ChessDragonView;

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
        ChessFrame chessFrame = new ChessFrame();

        List<FieldCoordinateView> posMoves = new ArrayList<>();
        posMoves.add(new FieldCoordinateView(1, 1, 1));
        chessFrame.showPossibleMoves(posMoves);

        assertEquals(chessFrame.getField()[1].getHighlightedCellsAsMove().get(0), new Point(1, 1));
    }
}
