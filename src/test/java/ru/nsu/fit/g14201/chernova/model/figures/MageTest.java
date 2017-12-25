package ru.nsu.fit.g14201.chernova.model.figures;

import org.junit.Before;
import org.junit.Test;
import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MageTest {
    private Field field;
    private Figure mage;

    @Before
    public void init()
    {
        field = new Field();
        mage = new Mage(Team.GOLDEN);
    }

    @Test
    public void normalMove()
    {
        FieldCoordinate fc = new FieldCoordinate(1, 5, 3);
        field.setFigure(mage, fc);
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 5, 7));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 5, 1));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 1, 3));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 10, 3));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 2, 0));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 6, 4));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 7, 1));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(0, 5, 3));
        List<FieldCoordinate> moves = mage.getPossibleMoves(field, fc);
        assertEquals(19, moves.size());
    }

    @Test
    public void edgeBoardMove()
    {
        FieldCoordinate fc = new FieldCoordinate(0, 5, 3);
        field.setFigure(mage, fc);
        List<FieldCoordinate> moves = mage.getPossibleMoves(field, fc);
        assertEquals(6, moves.size());

        fc = new FieldCoordinate(2, 3, 5);
        field.setFigure(mage, fc);
        moves = mage.getPossibleMoves(field, fc);
        assertEquals(6, moves.size());
    }
}
