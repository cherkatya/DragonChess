package ru.nsu.fit.g14201.chernova.model;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Катя on 21.12.2017.
 */
public abstract class Figure {
    protected Team team;

    public Figure(Team team){
        this.team = team;
    }

    protected void checkBounds(List <FieldCoordinate> moves) {
        for (Iterator<FieldCoordinate> iterator = moves.iterator(); iterator.hasNext(); )
            if (iterator.next().getBoard() > 2 || iterator.next().getBoard() < 0 || iterator.next().getY() < 0 ||
                    iterator.next().getY() >= 8 || iterator.next().getX() < 0 || iterator.next().getX() >= 12)
                iterator.remove();
    }
    protected void checkPossibilityMoves(List<FieldCoordinate> possibleMoves, Field field){
        checkBounds(possibleMoves);

        for (Iterator<FieldCoordinate> iterator = possibleMoves.iterator(); iterator.hasNext(); )
            if(!field.isEmpty(iterator.next()))
                iterator.remove();
    }
    protected void checkCaptureMoves(List<FieldCoordinate> captureMoves, Field field){
        checkBounds(captureMoves);

        for (Iterator<FieldCoordinate> iterator = captureMoves.iterator(); iterator.hasNext(); )
            if(field.isEmpty(iterator.next()))
                iterator.remove();
    }

    public Team getTeam(){
        return team;
    }
    public abstract List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords);
    public abstract List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords);
}
