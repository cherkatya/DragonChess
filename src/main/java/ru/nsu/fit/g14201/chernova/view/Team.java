package ru.nsu.fit.g14201.chernova.view;

/**
 * Created by RARETA on 23.12.2017.
 */
public enum Team {
    GOLDEN,CRIMSON;

    public static Team getOppositeTeam(Team team){
        if(team == GOLDEN)
            return CRIMSON;
        return GOLDEN;
    }
}