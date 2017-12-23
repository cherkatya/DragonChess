package ru.nsu.fit.g14201.chernova.model;

/**
 * Created by Катя on 21.12.2017.
 */
public class GameMove {
    private FieldCoordinate oldPosition;
    private FieldCoordinate newPosition;

    public GameMove(FieldCoordinate oldPosition, FieldCoordinate newPosition){
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
    }

    public FieldCoordinate getOldPosition() {
        return oldPosition;
    }

    public FieldCoordinate getNewPosition() {
        return newPosition;
    }
}
