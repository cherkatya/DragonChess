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
public class DragonTest {
    @Test
    public void possibleUpMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure dragon = new Dragon(Team.GOLDEN);
        field.setFigure(dragon, coords);

        List<FieldCoordinate> possibleMoves = dragon.getPossibleMoves(field, coords);

        assertEquals(18, possibleMoves.size());
    }
    @Test
    public void captureUpMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure dragon = new Dragon(Team.GOLDEN);
        field.setFigure(dragon, coords);
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 4, 4));
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 7, 5));
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 2, 0));
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 7, 1));
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 6, 3));

        List<FieldCoordinate> captureMoves = dragon.getCaptureMoves(field, coords);

        assertEquals(5, captureMoves.size());
    }
    @Test
    public void captureDownMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure dragon = new Dragon(Team.GOLDEN);
        field.setFigure(dragon, coords);
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(1, 5, 3));
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(1, 5, 2));

        List<FieldCoordinate> captureMoves = dragon.getCaptureMoves(field, coords);

        assertEquals(2, captureMoves.size());
    }
    @Test
    public void boundMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 0, 0);
        Figure dragon = new Dragon(Team.GOLDEN);
        field.setFigure(dragon, coords);

        List<FieldCoordinate> possibleMoves = dragon.getPossibleMoves(field, coords);

        assertEquals(9, possibleMoves.size());
    }
    @Test
    public void blockMoveTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure dragon = new Dragon(Team.GOLDEN);
        field.setFigure(dragon, coords);
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 3, 5));

        List<FieldCoordinate> possibleMoves = dragon.getPossibleMoves(field, coords);

        assertEquals(15, possibleMoves.size());
    }
    @Test
    public void blockCaptureTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure dragon = new Dragon(Team.GOLDEN);
        field.setFigure(dragon, coords);
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 1, 7));
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 3, 5));

        List<FieldCoordinate> captureMoves = dragon.getCaptureMoves(field, coords);

        assertEquals(1, captureMoves.size());
    }
    @Test
    public void captureMoveOurFigureTest(){
        Field field = new Field();
        FieldCoordinate coords = new FieldCoordinate(0, 5, 3);
        Figure dragon = new Dragon(Team.GOLDEN);
        field.setFigure(dragon, coords);
        field.setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 5, 4));
        field.setFigure(new Warrior(Team.GOLDEN), new FieldCoordinate(0, 3, 5));
        field.setFigure(new Warrior(Team.GOLDEN), new FieldCoordinate(1, 5, 3));

        List<FieldCoordinate> captureMoves = dragon.getCaptureMoves(field, coords);

        assertEquals(1, captureMoves.size());
    }
}
