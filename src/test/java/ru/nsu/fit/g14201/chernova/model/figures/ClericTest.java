package ru.nsu.fit.g14201.chernova.model.figures;

import org.junit.Before;
import org.junit.Test;
import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ClericTest {
    private Field field;
    private Figure cleric;
    @Before
    public void init()
    {
        field = new Field();
        cleric = new Cleric(Team.GOLDEN);
    }

    @Test
    public void normalMove()
    {
        FieldCoordinate fc = new FieldCoordinate(1, 4, 4);
        field.setFigure(cleric, fc);
        List<FieldCoordinate> moves = cleric.getPossibleMoves(field, fc);
        assertEquals(10, moves.size());
    }

    @Test
    public void edgeCornerMode()
    {
        FieldCoordinate fc = new FieldCoordinate(0, 0, 0);
        field.setFigure(cleric, fc);
        List<FieldCoordinate> moves = cleric.getPossibleMoves(field, fc);
        assertEquals(4, moves.size());
    }

    @Test
    public void captureTest()
    {
        FieldCoordinate fc = new FieldCoordinate(1, 4, 4);
        field.setFigure(cleric, fc);
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 3, 4));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 5, 4));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 3, 3));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 3, 5));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(2, 4, 4));
        List<FieldCoordinate> moves = cleric.getCaptureMoves(field, fc);
        assertEquals(5, moves.size());
    }
}
