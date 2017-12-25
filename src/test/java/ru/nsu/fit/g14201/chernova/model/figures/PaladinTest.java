package ru.nsu.fit.g14201.chernova.model.figures;

import org.junit.Before;
import org.junit.Test;
import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PaladinTest {
    private Field field;
    private Figure paladin;

    @Before
    public void init()
    {
        field = new Field();
        paladin = new Paladin(Team.GOLDEN);
    }

    @Test
    public void normalMove()
    {
        FieldCoordinate fc = new FieldCoordinate(1, 5, 3);
        field.setFigure(paladin, fc);
        List<FieldCoordinate> moves = paladin.getPossibleMoves(field, fc);
        assertEquals(24, moves.size());
    }

    @Test
    public void edgeBoardMove()
    {
        FieldCoordinate fc = new FieldCoordinate(0, 0, 0);
        field.setFigure(paladin, fc);
        List<FieldCoordinate> moves = paladin.getPossibleMoves(field, fc);
        assertEquals(7, moves.size());
    }
}
