package ru.nsu.fit.g14201.chernova.model.figures;

import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Катя on 21.12.2017.
 */
public class Sylph extends Figure {
    public Sylph(Team team){
        super(team);
    }

    private void addSecondBoardMoves(List<FieldCoordinate> possibleMoves, FieldCoordinate coords, Field field){
        possibleMoves.add(new FieldCoordinate(coords.getBoard() - 1, coords.getY(), coords.getX()));
        if (team == Team.GOLDEN) {
            for(int x = 0; x < 12; x += 2){
                possibleMoves.add(new FieldCoordinate(0, 1, x));
            }
        } else {
            for(int x = 0; x < 12; x += 2){
                possibleMoves.add(new FieldCoordinate(0, 6, x));
            }
        }
        checkPossibilityMoves(possibleMoves, field);
    }
    private void checkBounds(List <FieldCoordinate> moves){
        for (Iterator<FieldCoordinate> iterator = moves.iterator(); iterator.hasNext(); )
            if(iterator.next().getBoard() > 1 || iterator.next().getBoard() < 0 || iterator.next().getY() < 0 ||
                        iterator.next().getY() >= 8 || iterator.next().getX() < 0 || iterator.next().getX() >= 12)
                iterator.remove();
    }
    private void checkPossibilityMoves(List<FieldCoordinate> possibleMoves, Field field){
        checkBounds(possibleMoves);

        for (Iterator<FieldCoordinate> iterator = possibleMoves.iterator(); iterator.hasNext(); )
            if(!field.isEmpty(iterator.next()))
                iterator.remove();
    }
    public List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> possibleMoves = new ArrayList<>();
        if(coords.getBoard() == 0) {
            if (team == Team.GOLDEN) {
                possibleMoves.add(new FieldCoordinate(coords.getBoard(), coords.getY() + 1, coords.getX() - 1));
                possibleMoves.add(new FieldCoordinate(coords.getBoard(), coords.getY() + 1, coords.getX() + 1));
            } else {
                possibleMoves.add(new FieldCoordinate(coords.getBoard(), coords.getY() - 1, coords.getX() - 1));
                possibleMoves.add(new FieldCoordinate(coords.getBoard(), coords.getY() - 1, coords.getX() + 1));
            }
            checkPossibilityMoves(possibleMoves, field);
        }
        if(coords.getBoard() == 1)
            addSecondBoardMoves(possibleMoves, coords, field);

        return possibleMoves;
    }
    private void checkCaptureMoves(List<FieldCoordinate> captureMoves, Field field){
        checkBounds(captureMoves);

        for (Iterator<FieldCoordinate> iterator = captureMoves.iterator(); iterator.hasNext(); )
            if(field.isEmpty(iterator.next()))
                iterator.remove();
    }
    public List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> captureMoves = new ArrayList<>();
        if(coords.getBoard() == 0) {
            if (team == Team.GOLDEN) {
                captureMoves.add(new FieldCoordinate(coords.getBoard(), coords.getY() + 1, coords.getX()));
            } else {
                captureMoves.add(new FieldCoordinate(coords.getBoard(), coords.getY() - 1, coords.getX()));
            }
            captureMoves.add(new FieldCoordinate(coords.getBoard() + 1, coords.getY(), coords.getX()));
        }
        checkCaptureMoves(captureMoves, field);
        return captureMoves;
    }
}
