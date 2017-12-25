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

    protected static void checkMoveValidity(List<FieldCoordinate> moves, Field field, Team team){
        //bounds
        moves.removeIf(coord -> coord.getBoard() > 2 || coord.getBoard() < 0 || coord.getY() < 0 || coord.getY() >= 8 || coord.getX() < 0 || coord.getX() >= 12);

        //team
        moves.removeIf(coords -> !field.isEmpty(coords) && field.getFigure(coords).getTeam() == team);
    }
    protected static void checkPossibilityMoves(List<FieldCoordinate> possibleMoves, Field field){
        for (Iterator<FieldCoordinate> iterator = possibleMoves.iterator(); iterator.hasNext(); )
            if(!field.isEmpty(iterator.next()))
                iterator.remove();
    }
    protected static void checkCaptureMoves(List<FieldCoordinate> captureMoves, Field field){
        for (Iterator<FieldCoordinate> iterator = captureMoves.iterator(); iterator.hasNext(); )
            if(field.isEmpty(iterator.next()))
                iterator.remove();
    }

    protected void addDiagonalMoves(List<FieldCoordinate> moves, Field field, FieldCoordinate coords)
    {
        for (int i = 1; ((coords.getX() - i) >= 0) && ((coords.getY() - i) >= 0); i++)
        {
            if (!addIfEmpty(moves, field, new FieldCoordinate(coords.getBoard(), coords.getX() - i, coords.getY() - i)))
                break;
        }

        for (int i = 1; ((coords.getX() - i) >= 0) && ((coords.getY() + i) < 8); i++)
        {
            if (!addIfEmpty(moves, field, new FieldCoordinate(coords.getBoard(), coords.getX() - i, coords.getY() + i)))
                break;
        }

        for (int i = 1; ((coords.getX() + i) < 12) && ((coords.getY() - i) >= 0); i++)
        {
            if (!addIfEmpty(moves, field, new FieldCoordinate(coords.getBoard(), coords.getX() + i, coords.getY() - i)))
                break;
        }

        for (int i = 1; ((coords.getX() + i) < 12) && ((coords.getY() + i) < 8); i++)
        {
            if (!addIfEmpty(moves, field, new FieldCoordinate(coords.getBoard(), coords.getX() + i, coords.getY() + i)))
                break;
        }
    }

    protected void addOrthogonalMoves(List<FieldCoordinate> moves, Field field, FieldCoordinate coords)
    {
        boolean res;
        for (int i = 1; coords.getX() - i >= 0; i++)
        {
            res = addIfEmpty(moves, field, new FieldCoordinate(coords.getBoard(), coords.getX() - i, coords.getY()));
            if (!res)
                break;
        }

        for (int i = 1; coords.getX() + i < 12; i++)
        {
            res = addIfEmpty(moves, field, new FieldCoordinate(coords.getBoard(), coords.getX() + i, coords.getY()));
            if (!res)
                break;
        }

        for (int i = 1; coords.getY() - i >= 0; i++)
        {
            res = addIfEmpty(moves, field, new FieldCoordinate(coords.getBoard(), coords.getX(), coords.getY() - i));
            if (!res)
                break;
        }

        for (int i = 1; coords.getY() + i < 8; i++)
        {
            res = addIfEmpty(moves, field, new FieldCoordinate(coords.getBoard(), coords.getX(), coords.getY() + i));
            if (!res)
                break;
        }
    }

    private boolean addIfEmpty(List<FieldCoordinate> moves, Field field, FieldCoordinate coords)
    {
        moves.add(coords);

        return field.isEmpty(coords);
    }

    public Team getTeam(){
        return team;
    }
    public abstract List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords);
    public abstract List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords);
}
