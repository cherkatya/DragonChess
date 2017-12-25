package ru.nsu.fit.g14201.chernova.model.figures;

import org.junit.Before;
import org.junit.Test;
import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HeroTest {
    private Field field;
    private Figure hero;

    @Before
    public void init()
    {
        field = new Field();
        hero = new Hero(Team.GOLDEN);
    }

    @Test
    public void normalMove()
    {
        FieldCoordinate fc = new FieldCoordinate(1, 4, 4);
        field.setFigure(hero, fc);
        List<FieldCoordinate> moves = hero.getPossibleMoves(field, fc);
        assertEquals(16, moves.size());
    }

    @Test
    public void returnMove()
    {
        FieldCoordinate fc = new FieldCoordinate(1, 4, 4);
        field.setFigure(hero, fc);
        List<FieldCoordinate> moves = hero.getPossibleMoves(field, fc);
        assertEquals(16, moves.size());
        field.setFigure(null, fc);
        fc = new FieldCoordinate(2, 3, 4);
        field.setFigure(hero, fc);
        moves = hero.getPossibleMoves(field, fc);
        assertEquals(1, moves.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalBoardTest()
    {
        FieldCoordinate fc = new FieldCoordinate(2, 4, 4);
        field.setFigure(hero, fc);
        List<FieldCoordinate> moves = hero.getPossibleMoves(field, fc);
        assertEquals(true, false);
    }

    @Test
    public void captureTest()
    {
        FieldCoordinate fc = new FieldCoordinate(1, 4, 4);
        field.setFigure(hero, fc);
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 3, 3));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 3, 5));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(2, 3, 5));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(0, 5, 5));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 6, 6));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 0, 0));
        List<FieldCoordinate> moves = hero.getCaptureMoves(field, fc);
        assertEquals(5, moves.size());
    }
}
