package ru.nsu.fit.g14201.chernova.model;

public class PlayerInfo {
    private Team currentTurn;

    public void startGame() {
        currentTurn = Team.GOLDEN;
    }

    public Team getCurrentTurn() {
        return currentTurn;
    }

    public void switchTurn() {
        currentTurn = Team.getOppositeTeam(currentTurn);
    }
}
