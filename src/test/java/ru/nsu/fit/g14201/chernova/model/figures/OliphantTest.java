package ru.nsu.fit.g14201.chernova.model.figures;

import org.junit.Test;
import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OliphantTest {
    @Test
    public void normalMoveTest() {
        Field field = new Field();
        Figure oliphant = new Oliphant(Team.GOLDEN);
        FieldCoordinate coords = new FieldCoordinate(1,6, 0);
        field.setFigure(oliphant, coords);
        List<FieldCoordinate> moves = oliphant.getPossibleMoves(field, coords);

        assertEquals(18, moves.size());
    }

    @Test
    public void cornerMoveTest() {
        Field field = new Field();
        Figure oliphant = new Oliphant(Team.GOLDEN);
        FieldCoordinate coords = new FieldCoordinate(1,0, 0);
        field.setFigure(oliphant, coords);
        List<FieldCoordinate> moves = oliphant.getPossibleMoves(field, coords);

        assertEquals(18, moves.size());
    }

    @Test
    public void normalCaptureTest()
    {
        Field field = new Field();
        Figure oliphant = new Oliphant(Team.GOLDEN);
        FieldCoordinate coords = new FieldCoordinate(1,6, 0);
        field.setFigure(oliphant, coords);
        List<FieldCoordinate> moves = oliphant.getCaptureMoves(field, coords);

        assertEquals(0, moves.size());

        oliphant = new Oliphant(Team.CRIMSON);
        coords = new FieldCoordinate(1,0, 0);
        field.setFigure(oliphant, coords);
        field.setFigure(new Oliphant(Team.GOLDEN), new FieldCoordinate(1, 0, 2));
        moves = oliphant.getCaptureMoves(field, coords);

        assertEquals(2, moves.size());
    }
}
