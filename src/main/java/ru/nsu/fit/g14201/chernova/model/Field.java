package ru.nsu.fit.g14201.chernova.model;

import ru.nsu.fit.g14201.chernova.model.figures.*;

/**
 * Created by Катя on 21.12.2017.
 */
public class Field {
    private Figure[][][] field = new Figure[3][8][12];

    public void setFigure(Figure figure, FieldCoordinate coords){
        if(isEmpty(coords))
            field[coords.getBoard()][coords.getY()][coords.getX()] = figure;
    }
    public Figure getFigure(FieldCoordinate coords){
        return field[coords.getBoard()][coords.getY()][coords.getX()];
    }
    public boolean isEmpty(FieldCoordinate coords){
        return field[coords.getBoard()][coords.getY()][coords.getX()] == null;
    }
    public void makeMove(GameMove gameMove){
        if(!isEmpty(gameMove.getOldPosition())) {
            setFigure(getFigure(gameMove.getOldPosition()), gameMove.getNewPosition());
        }
    }
    public void populate(){
        populateUpBoard();
        populateMiddleBoard();
        populateDownBoard();
    }
    private void populateUpBoard(){
        for(int x = 0; x < 12; x += 2){
            setFigure(new Sylph(Team.GOLDEN), new FieldCoordinate(0, 1, x));
            setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, 6, x));
        }
        setFigure(new Griffon(Team.GOLDEN), new FieldCoordinate(0, 0, 2));
        setFigure(new Griffon(Team.CRIMSON), new FieldCoordinate(0, 7, 2));
        setFigure(new Griffon(Team.GOLDEN), new FieldCoordinate(0, 0, 10));
        setFigure(new Griffon(Team.CRIMSON), new FieldCoordinate(0, 7, 10));
        setFigure(new Dragon(Team.GOLDEN), new FieldCoordinate(0, 0, 6));
        setFigure(new Dragon(Team.CRIMSON), new FieldCoordinate(0, 7, 6));
    }
    private void populateMiddleBoard(){
        for(int x = 0; x < 12; x++){
            setFigure(new Warrior(Team.GOLDEN), new FieldCoordinate(1, 1, x));
            setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, 6, x));
        }
        setFigure(new Oliphant(Team.GOLDEN), new FieldCoordinate(1, 0, 0));
        setFigure(new Oliphant(Team.CRIMSON), new FieldCoordinate(1, 7, 0));
        setFigure(new Oliphant(Team.GOLDEN), new FieldCoordinate(1, 0, 11));
        setFigure(new Oliphant(Team.CRIMSON), new FieldCoordinate(1, 7, 11));

        setFigure(new Unicorn(Team.GOLDEN), new FieldCoordinate(1, 0, 1));
        setFigure(new Unicorn(Team.CRIMSON), new FieldCoordinate(1, 7, 1));
        setFigure(new Unicorn(Team.GOLDEN), new FieldCoordinate(1, 0, 10));
        setFigure(new Unicorn(Team.CRIMSON), new FieldCoordinate(1, 7, 10));

        setFigure(new Hero(Team.GOLDEN), new FieldCoordinate(0, 0, 2));
        setFigure(new Hero(Team.CRIMSON), new FieldCoordinate(0, 7, 2));
        setFigure(new Hero(Team.GOLDEN), new FieldCoordinate(0, 0, 9));
        setFigure(new Hero(Team.CRIMSON), new FieldCoordinate(0, 7, 9));

        setFigure(new Thief(Team.GOLDEN), new FieldCoordinate(1, 0, 3));
        setFigure(new Thief(Team.CRIMSON), new FieldCoordinate(1, 7, 3));
        setFigure(new Thief(Team.GOLDEN), new FieldCoordinate(1, 0, 8));
        setFigure(new Thief(Team.CRIMSON), new FieldCoordinate(1, 7, 8));

        setFigure(new Cleric(Team.GOLDEN), new FieldCoordinate(1, 0, 4));
        setFigure(new Cleric(Team.CRIMSON), new FieldCoordinate(1, 7, 4));
        setFigure(new Mage(Team.GOLDEN), new FieldCoordinate(1, 0, 5));
        setFigure(new Mage(Team.CRIMSON), new FieldCoordinate(1, 7, 5));
        setFigure(new King(Team.GOLDEN), new FieldCoordinate(0, 0, 6));
        setFigure(new King(Team.CRIMSON), new FieldCoordinate(0, 7, 6));
        setFigure(new Paladin(Team.GOLDEN), new FieldCoordinate(0, 0, 7));
        setFigure(new Paladin(Team.CRIMSON), new FieldCoordinate(0, 7, 7));
    }
    private void populateDownBoard(){
        for(int x = 1; x < 12; x += 2){
            setFigure(new Dwarf(Team.GOLDEN), new FieldCoordinate(2, 1, x));
            setFigure(new Dwarf(Team.CRIMSON), new FieldCoordinate(2, 6, x));
        }
        setFigure(new Basilisk(Team.GOLDEN), new FieldCoordinate(2, 0, 2));
        setFigure(new Basilisk(Team.CRIMSON), new FieldCoordinate(2, 7, 2));
        setFigure(new Basilisk(Team.GOLDEN), new FieldCoordinate(2, 0, 10));
        setFigure(new Basilisk(Team.CRIMSON), new FieldCoordinate(2, 7, 10));
        setFigure(new Elemental(Team.GOLDEN), new FieldCoordinate(0, 0, 6));
        setFigure(new Elemental(Team.CRIMSON), new FieldCoordinate(0, 7, 6));
    }
}
