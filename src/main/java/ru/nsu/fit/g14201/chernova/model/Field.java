package ru.nsu.fit.g14201.chernova.model;

import ru.nsu.fit.g14201.chernova.model.figures.*;

/**
 * Created by Катя on 21.12.2017.
 */
public class Field {
    private Figure[][][] field = new Figure[3][8][12];

    public void setFigure(Figure figure, FieldCoordinate coords){
        field[coords.getBoard()][coords.getY()][coords.getX()] = figure;
    }
    public Figure getFigure(FieldCoordinate coords){
        return field[coords.getBoard()][coords.getY()][coords.getX()];
    }
    public boolean isEmpty(FieldCoordinate coords){
        return field[coords.getBoard()][coords.getY()][coords.getX()] == null;
    }
    public void makeMove(GameMove gameMove){
        setFigure(getFigure(gameMove.getOldPosition()), gameMove.getNewPosition());
    }
    public void transformFigure(Figure figure, FieldCoordinate coords){
        if(figure.getClass().getName().equals("ru.nsu.fit.g14201.chernova.model.figures.Warrior")){
            if(coords.getY() == 7 && figure.getTeam() == Team.GOLDEN || coords.getY() == 0 && figure.getTeam() == Team.CRIMSON)
                field[coords.getBoard()][coords.getY()][coords.getX()] = new Hero(figure.getTeam());
        }
    }
    public void populate(){
        populateUpBoard();
        populateMiddleBoard();
        populateDownBoard();
    }
    private void populateUpBoard(){
        for(int x = 0; x < 12; x += 2){
            setFigure(new Sylph(Team.GOLDEN), new FieldCoordinate(0, x, 1));
            setFigure(new Sylph(Team.CRIMSON), new FieldCoordinate(0, x, 6));
        }
        setFigure(new Griffon(Team.GOLDEN), new FieldCoordinate(0, 2, 0));
        setFigure(new Griffon(Team.CRIMSON), new FieldCoordinate(0, 2, 7));
        setFigure(new Griffon(Team.GOLDEN), new FieldCoordinate(0, 10, 0));
        setFigure(new Griffon(Team.CRIMSON), new FieldCoordinate(0, 10, 7));
        setFigure(new Dragon(Team.GOLDEN), new FieldCoordinate(0, 6, 0));
        setFigure(new Dragon(Team.CRIMSON), new FieldCoordinate(0, 6, 7));
    }
    private void populateMiddleBoard(){
        for(int x = 0; x < 12; x++){
            setFigure(new Warrior(Team.GOLDEN), new FieldCoordinate(1, x, 1));
            setFigure(new Warrior(Team.CRIMSON), new FieldCoordinate(1, x, 6));
        }
        setFigure(new Oliphant(Team.GOLDEN), new FieldCoordinate(1, 0, 0));
        setFigure(new Oliphant(Team.CRIMSON), new FieldCoordinate(1, 0, 7));
        setFigure(new Oliphant(Team.GOLDEN), new FieldCoordinate(1, 11, 0));
        setFigure(new Oliphant(Team.CRIMSON), new FieldCoordinate(1, 11, 7));

        setFigure(new Unicorn(Team.GOLDEN), new FieldCoordinate(1, 1, 0));
        setFigure(new Unicorn(Team.CRIMSON), new FieldCoordinate(1, 1, 7));
        setFigure(new Unicorn(Team.GOLDEN), new FieldCoordinate(1, 10, 0));
        setFigure(new Unicorn(Team.CRIMSON), new FieldCoordinate(1, 10, 7));

        setFigure(new Hero(Team.GOLDEN), new FieldCoordinate(1, 2, 0));
        setFigure(new Hero(Team.CRIMSON), new FieldCoordinate(1, 2, 7));
        setFigure(new Hero(Team.GOLDEN), new FieldCoordinate(1, 9, 0));
        setFigure(new Hero(Team.CRIMSON), new FieldCoordinate(1, 9, 7));

        setFigure(new Thief(Team.GOLDEN), new FieldCoordinate(1, 3, 0));
        setFigure(new Thief(Team.CRIMSON), new FieldCoordinate(1, 3, 7));
        setFigure(new Thief(Team.GOLDEN), new FieldCoordinate(1, 8, 0));
        setFigure(new Thief(Team.CRIMSON), new FieldCoordinate(1, 8, 7));

        setFigure(new Cleric(Team.GOLDEN), new FieldCoordinate(1, 4, 0));
        setFigure(new Cleric(Team.CRIMSON), new FieldCoordinate(1, 4, 7));
        setFigure(new Mage(Team.GOLDEN), new FieldCoordinate(1, 5, 0));
        setFigure(new Mage(Team.CRIMSON), new FieldCoordinate(1, 5, 7));
        setFigure(new King(Team.GOLDEN), new FieldCoordinate(1, 6, 0));
        setFigure(new King(Team.CRIMSON), new FieldCoordinate(1, 6, 7));
        setFigure(new Paladin(Team.GOLDEN), new FieldCoordinate(1, 7, 0));
        setFigure(new Paladin(Team.CRIMSON), new FieldCoordinate(1, 7, 7));
    }
    private void populateDownBoard(){
        for(int x = 1; x < 12; x += 2){
            setFigure(new Dwarf(Team.GOLDEN), new FieldCoordinate(2, x, 1));
            setFigure(new Dwarf(Team.CRIMSON), new FieldCoordinate(2, x, 6));
        }
        setFigure(new Basilisk(Team.GOLDEN), new FieldCoordinate(2, 2, 0));
        setFigure(new Basilisk(Team.CRIMSON), new FieldCoordinate(2, 2, 7));
        setFigure(new Basilisk(Team.GOLDEN), new FieldCoordinate(2, 10, 0));
        setFigure(new Basilisk(Team.CRIMSON), new FieldCoordinate(2, 10, 7));
        setFigure(new Elemental(Team.GOLDEN), new FieldCoordinate(2, 6, 0));
        setFigure(new Elemental(Team.CRIMSON), new FieldCoordinate(2, 6, 7));
    }
}