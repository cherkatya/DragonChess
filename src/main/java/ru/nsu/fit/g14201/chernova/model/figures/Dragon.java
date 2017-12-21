package ru.nsu.fit.g14201.chernova.model.figures;

import ru.nsu.fit.g14201.chernova.model.Field;
import ru.nsu.fit.g14201.chernova.model.FieldCoordinate;
import ru.nsu.fit.g14201.chernova.model.Figure;
import ru.nsu.fit.g14201.chernova.model.Team;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Катя on 21.12.2017.
 */
public class Dragon extends Figure {
    public Dragon(Team team){
        super(team);
    }

    private void checkBlocks(List<FieldCoordinate> moves, Field field, FieldCoordinate baseCoords){
        for (Iterator<FieldCoordinate> iterator = moves.iterator(); iterator.hasNext(); ){
            FieldCoordinate coords = iterator.next();
            if(!field.isEmpty(coords) && field.getFigure(coords).getTeam() == team)
                iterator.remove();
        }
    }
    private boolean isBoardEnd(int x, int y) {
        return y < 0 || y >= 12 || x < 0 || x >= 8;
    }
    private List<FieldCoordinate> getMoves(FieldCoordinate coords, Field field){
        List<FieldCoordinate> moves = new ArrayList<>();
        int x = coords.getX();
        int y = coords.getY();
        Point[] bounds = new Point[4];

        for(int shift = 1; shift <= 7; shift++){
            if(!isBoardEnd(x + shift, y + shift))
                moves.add(new FieldCoordinate(0, coords.getY() + shift, coords.getX() + shift));
            if(!isBoardEnd(x + shift, y - shift))
                moves.add(new FieldCoordinate(0, coords.getY() - shift, coords.getX() + shift));
            if(!isBoardEnd(x - shift, y + shift))
                moves.add(new FieldCoordinate(0, coords.getY() + shift, coords.getX() - shift));
            if(!isBoardEnd(x - shift, y - shift))
                moves.add(new FieldCoordinate(0, coords.getY() - shift, coords.getX() - shift));
        }

        checkMoveValidity(moves, field, team);

        return moves;
    }
    public List<FieldCoordinate> getPossibleMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> possibleMoves = getMoves(coords, field);

        //checkPossibleBlocks(possibleMoves, field);

        return possibleMoves;
    }
    public List<FieldCoordinate> getCaptureMoves(Field field, FieldCoordinate coords){
        List<FieldCoordinate> captureMoves = getMoves(coords, field);

        //checkCaptureBlocks(captureMoves, field);

        captureMoves.add(new FieldCoordinate(1, coords.getY() + 1, coords.getX()));
        captureMoves.add(new FieldCoordinate(1, coords.getY(), coords.getX() + 1));
        captureMoves.add(new FieldCoordinate(1, coords.getY(), coords.getX() - 1));
        captureMoves.add(new FieldCoordinate(1, coords.getY() - 1, coords.getX()));
        captureMoves.add(new FieldCoordinate(1, coords.getY(), coords.getX()));

        checkMoveValidity(captureMoves, field, team);

        return captureMoves;
    }
}
