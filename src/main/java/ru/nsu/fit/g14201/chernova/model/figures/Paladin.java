package ru.nsu.fit.g14201.chernova.model.figures;

import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Катя on 21.12.2017.
 */
public class Paladin extends Figure {
    public Paladin(Team team){
        super(team);
    }

    public List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> possibleMoves = new ArrayList<>();

        return possibleMoves;
    }
    public List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> captureMoves = new ArrayList<>();

        return captureMoves;
    }
}
