package ru.nsu.fit.g14201.chernova.model.figures;

import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Катя on 21.12.2017.
 */
public class Dragon extends Figure {
    public Dragon(Team team){
        super(team);
    }

    private boolean isLastCell(int x, int y) {
        return y == 0 || y == 11 || x == 0 || x == 7;
    }
    private void checkPossibleLine(int index, boolean[] bounds, List<FieldCoordinate> moves, Field field, int x, int y){
        if(!bounds[index]){
            if(isLastCell(x, y))
                bounds[index] = true;
            FieldCoordinate coord = new FieldCoordinate(0, x, y);
            if(field.isEmpty(coord))
                moves.add(coord);
            else{
                bounds[index] = true;
            }
        }
    }
    public List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> possibleMoves = new ArrayList<>();
        int x = coords.getX();
        int y = coords.getY();
        boolean[] bounds = new boolean[4];

        for(int shift = 1; shift <= 7; shift++){
            checkPossibleLine(0, bounds, possibleMoves, field, x + shift, y + shift);
            checkPossibleLine(1, bounds, possibleMoves, field, x - shift, y + shift);
            checkPossibleLine(2, bounds, possibleMoves, field, x - shift, y - shift);
            checkPossibleLine(3, bounds, possibleMoves, field, x + shift, y - shift);
        }

        possibleMoves.add(new FieldCoordinate(1, coords.getX(), coords.getY() + 1));
        possibleMoves.add(new FieldCoordinate(1, coords.getX() + 1, coords.getY()));
        possibleMoves.add(new FieldCoordinate(1, coords.getX() - 1, coords.getY()));
        possibleMoves.add(new FieldCoordinate(1, coords.getX(), coords.getY() - 1));

        return possibleMoves;
    }
    private void checkCaptureLine(int index, boolean[] bounds, List<FieldCoordinate> moves, Field field, int x, int y){
        if(!bounds[index]){
            if(isLastCell(x, y))
                bounds[index] = true;
            FieldCoordinate coord = new FieldCoordinate(0, x, y);
            if(!field.isEmpty(coord)){
                bounds[index] = true;
                if(field.getFigure(coord).getTeam() != team)
                    moves.add(coord);
            }
        }
    }
    public List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> captureMoves = new ArrayList<>();

        captureMoves.add(new FieldCoordinate(1, coords.getX(), coords.getY() + 1));
        captureMoves.add(new FieldCoordinate(1, coords.getX() + 1, coords.getY()));
        captureMoves.add(new FieldCoordinate(1, coords.getX() - 1, coords.getY()));
        captureMoves.add(new FieldCoordinate(1, coords.getX(), coords.getY() - 1));

        checkCaptureMoves(captureMoves, field);

        int x = coords.getX();
        int y = coords.getY();
        boolean[] bounds = new boolean[4];

        for(int shift = 1; shift <= 7; shift++){
            checkCaptureLine(0, bounds, captureMoves, field, x + shift, y + shift);
            checkCaptureLine(1, bounds, captureMoves, field, x - shift, y + shift);
            checkCaptureLine(2, bounds, captureMoves, field, x - shift, y - shift);
            checkCaptureLine(3, bounds, captureMoves, field, x + shift, y - shift);
        }

        return captureMoves;
    }
}
