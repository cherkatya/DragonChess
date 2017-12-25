package ru.nsu.fit.g14201.chernova.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GameModel {
    private Field field;

    public GameModel(Field field) {
        this.field = field;
    }

    public boolean isCheckState(Team toTeam)
    {
        throw new NotImplementedException();
    }
}
