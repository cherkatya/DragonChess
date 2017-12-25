package ru.nsu.fit.g14201.chernova.model.figures;

import org.junit.Before;
import org.junit.Test;
import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OliphantTest {
    private Field field;
    private Figure oliphant;
    @Before
    public void init()
    {
        field = new Field();
        oliphant = new Oliphant(Team.GOLDEN);
    }

    @Test
    public void normalMoveTest() {
        FieldCoordinate coords = new FieldCoordinate(1,6, 0);
        field.setFigure(oliphant, coords);
        List<FieldCoordinate> moves = oliphant.getPossibleMoves(field, coords);

        assertEquals(18, moves.size());
    }

    @Test
    public void cornerMoveTest() {
        FieldCoordinate coords = new FieldCoordinate(1,0, 0);
        field.setFigure(oliphant, coords);
        List<FieldCoordinate> moves = oliphant.getPossibleMoves(field, coords);

        assertEquals(18, moves.size());
    }

    @Test
    public void normalCaptureTest()
    {
        FieldCoordinate coords = new FieldCoordinate(1,6, 0);
        field.setFigure(oliphant, coords);
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 4, 0));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 8, 0));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 6, 5));
        List<FieldCoordinate> moves = oliphant.getCaptureMoves(field, coords);

        assertEquals(3, moves.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongBoardText()
    {
        FieldCoordinate coords = new FieldCoordinate(0, 4, 4);
        field.setFigure(oliphant, coords);
        List<FieldCoordinate> moves = oliphant.getPossibleMoves(field, coords);
        assertEquals(true, false);
    }
}
