package ru.nsu.fit.g14201.chernova.model.figures;

import org.junit.Before;
import org.junit.Test;
import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class KingTest {
    private Field field;
    private Figure king;

    @Before
    public void init()
    {
        field = new Field();
        king = new King(Team.GOLDEN);
    }

    @Test
    public void normalMove()
    {
        FieldCoordinate fc = new FieldCoordinate(1, 4, 4);
        field.setFigure(king, fc);
        List<FieldCoordinate> moves = king.getPossibleMoves(field, fc);
        assertEquals(10, moves.size());
    }

    @Test
    public void edgeBoardMove()
    {
        FieldCoordinate fc = new FieldCoordinate(2, 4, 4);
        field.setFigure(king, fc);
        List<FieldCoordinate> moves = king.getPossibleMoves(field, fc);
        assertEquals(1, moves.size());
    }

    @Test
    public void cornerCaptureMove()
    {
        FieldCoordinate fc = new FieldCoordinate(1, 0, 0);
        field.setFigure(king, fc);
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(0, 0, 0));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(2, 0, 0));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 1, 1));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 1, 0));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 0, 1));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 2, 0));
        List<FieldCoordinate> moves = king.getCaptureMoves(field, fc);
        assertEquals(5, moves.size());
    }
}
