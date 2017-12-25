package ru.nsu.fit.g14201.chernova.model.figures;

import org.junit.Test;
import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WarriorTest {
    @Test
    public void normalMoveTest() {
        Field field = new Field();
        Figure warrior = new Warrior(Team.GOLDEN);
        FieldCoordinate coords = new FieldCoordinate(1,6, 0);
        field.setFigure(warrior, coords);
        List<FieldCoordinate> moves = warrior.getPossibleMoves(field, coords);

        assertEquals(1, moves.size());

        warrior = new Warrior(Team.CRIMSON);
        coords = new FieldCoordinate(1,6, 7);
        field.setFigure(warrior, coords);
        moves = warrior.getPossibleMoves(field, coords);

        assertEquals(2, moves.size());
    }

    @Test
    public void normalCaptureTest()
    {
        Field field = new Field();
        Figure warrior = new Warrior(Team.GOLDEN);
        FieldCoordinate coords = new FieldCoordinate(1,6, 0);
        field.setFigure(warrior, coords);
        List<FieldCoordinate> moves = warrior.getCaptureMoves(field, coords);

        assertEquals(2, moves.size());

        warrior = new Warrior(Team.CRIMSON);
        coords = new FieldCoordinate(1,6, 11);
        field.setFigure(warrior, coords);
        moves = warrior.getCaptureMoves(field, coords);

        assertEquals(2, moves.size());
    }
}
