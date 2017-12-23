package ru.nsu.fit.g14201.chernova.model.figures;

import org.junit.Test;
import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Катя on 22.12.2017.
 */
public class GriffonTest {
    @Test
    public void possibleUpMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure griffon = new Griffon(Team.GOLDEN);
        field.setFigure(griffon, coords);

        List<FieldCoordinate> possibleMoves = griffon.getPossibleMoves(field, coords);

        assertEquals(12, possibleMoves.size());
    }
    @Test
    public void possibleMiddleMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(1, 5, 3);
        Figure griffon = new Griffon(Team.GOLDEN);
        field.setFigure(griffon, coords);

        List<FieldCoordinate> possibleMoves = griffon.getPossibleMoves(field, coords);

        assertEquals(4, possibleMoves.size());
    }
    @Test
    public void captureMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure griffon = new Griffon(Team.GOLDEN);
        field.setFigure(griffon, coords);
        field.setFigure(new Griffon(Team.CRIMSON), new FieldCoordinate(0, 2, 1));
        field.setFigure(new Griffon(Team.CRIMSON), new FieldCoordinate(1, 4, 2));

        List<FieldCoordinate> captureMoves = griffon.getCaptureMoves(field, coords);

        assertEquals(2, captureMoves.size());
    }
    @Test
    public void boundMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 0, 0);
        Figure griffon = new Griffon(Team.GOLDEN);
        field.setFigure(griffon, coords);

        List<FieldCoordinate> possibleMoves = griffon.getPossibleMoves(field, coords);

        assertEquals(3, possibleMoves.size());
    }
    @Test
    public void blockMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(1, 5, 3);
        Figure griffon = new Griffon(Team.GOLDEN);
        field.setFigure(griffon, coords);
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 4, 2));

        List<FieldCoordinate> possibleMoves = griffon.getPossibleMoves(field, coords);

        assertEquals(3, possibleMoves.size());
    }
    @Test
    public void captureMoveOurFigureTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure griffon = new Griffon(Team.GOLDEN);
        field.setFigure(griffon, coords);
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 2, 1));
        field.setFigure(new Warrior(Team.GOLDEN), new FieldCoordinate(1, 4, 2));

        List<FieldCoordinate> captureMoves = griffon.getCaptureMoves(field, coords);

        assertEquals(1, captureMoves.size());
    }
}
