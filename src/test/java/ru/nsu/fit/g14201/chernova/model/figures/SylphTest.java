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
public class SylphTest {
    @Test
    public void possibleUpMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure sylph = new Sylph(Team.GOLDEN);
        field.setFigure(sylph, coords);

        List<FieldCoordinate> possibleMoves = sylph.getPossibleMoves(field, coords);

        assertEquals(2, possibleMoves.size());
    }
    @Test
    public void possibleMiddleMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(1, 5, 3);
        Figure sylph = new Sylph(Team.GOLDEN);
        field.setFigure(sylph, coords);

        List<FieldCoordinate> possibleMoves = sylph.getPossibleMoves(field, coords);

        assertEquals(7, possibleMoves.size());
    }
    @Test
    public void captureMoveWithoutDownFigureTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure sylph = new Sylph(Team.GOLDEN);
        field.setFigure(sylph, coords);
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 5, 4));

        List<FieldCoordinate> captureMoves = sylph.getCaptureMoves(field, coords);

        assertEquals(1, captureMoves.size());
    }
    @Test
    public void captureMoveWithDownFigureTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure sylph = new Sylph(Team.GOLDEN);
        field.setFigure(sylph, coords);
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 5, 4));
        field.setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 5, 3));

        List<FieldCoordinate> captureMoves = sylph.getCaptureMoves(field, coords);

        assertEquals(2, captureMoves.size());
    }
    @Test
    public void boundMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 0, 4);
        Figure sylph = new Sylph(Team.GOLDEN);
        field.setFigure(sylph, coords);

        List<FieldCoordinate> possibleMoves = sylph.getPossibleMoves(field, coords);

        assertEquals(1, possibleMoves.size());
    }
    @Test
    public void blockMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(1, 5, 3);
        Figure sylph = new Sylph(Team.GOLDEN);
        field.setFigure(sylph, coords);
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 0, 1));

        List<FieldCoordinate> possibleMoves = sylph.getPossibleMoves(field, coords);

        assertEquals(6, possibleMoves.size());
    }
    @Test
    public void captureMoveOurFigureTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure sylph = new Sylph(Team.GOLDEN);
        field.setFigure(sylph, coords);
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 5, 4));
        field.setFigure(new Warrior(Team.GOLDEN), new FieldCoordinate(1, 5, 3));

        List<FieldCoordinate> captureMoves = sylph.getCaptureMoves(field, coords);

        assertEquals(1, captureMoves.size());
    }
}
