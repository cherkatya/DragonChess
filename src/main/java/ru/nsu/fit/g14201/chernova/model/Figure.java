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

    protected void checkMoveValidity(List<FieldCoordinate> moves, Field field, Team team){
        //bounds
        for (Iterator<FieldCoordinate> iterator = moves.iterator(); iterator.hasNext(); ){
            FieldCoordinate coord = iterator.next();
            if (coord.getBoard() > 2 || coord.getBoard() < 0 || coord.getY() < 0 || coord.getY() >= 8 || coord.getX() < 0 || coord.getX() >= 12)
                iterator.remove();
        }

        //team
        for (Iterator<FieldCoordinate> iterator = moves.iterator(); iterator.hasNext(); ){
            FieldCoordinate coords = iterator.next();
            if(!field.isEmpty(coords) && field.getFigure(coords).getTeam() == team)
                iterator.remove();
        }
    }
    protected void checkPossibilityMoves(List<FieldCoordinate> possibleMoves, Field field){
        for (Iterator<FieldCoordinate> iterator = possibleMoves.iterator(); iterator.hasNext(); )
            if(!field.isEmpty(iterator.next()))
                iterator.remove();
    }
    protected void checkCaptureMoves(List<FieldCoordinate> captureMoves, Field field){
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
