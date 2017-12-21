package ru.nsu.fit.g14201.chernova.model;

import java.util.List;

/**
 * Created by Катя on 21.12.2017.
 */
public abstract class Figure {
    protected Team team;

    public Figure(Team team){
        this.team = team;
    }

    public Team getTeam(){
        return team;
    }
    public abstract List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords);
    public abstract List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords);
}
