package ru.nsu.fit.g14201.chernova.view.utils;

import java.awt.*;

/**
 * Created by RARETA on 23.12.2017.
 */
public enum TeamView {
    GOLDEN,CRIMSON;
    static private final Color goldenSideColor = new Color(0xffd700);
    static private final Color crimsonSideColor = new Color(220, 20, 60);

    public static Color getFigureColor(TeamView team) {
        if (team == GOLDEN) {
            return goldenSideColor;
        }
        return crimsonSideColor;
    }

    public static Color getCellColor(TeamView team, int boardNumber) {
        switch (boardNumber) {
        case 0:
            if (team == GOLDEN)
                return new Color(150, 220, 150);
            return new Color(71, 174, 51);
        case 1:
            if (team == GOLDEN)
                return new Color(150, 220, 150);
            return new Color(71, 174, 51);
        case 2:
            if (team == GOLDEN)
                return new Color(150, 220, 150);
            return new Color(71, 174, 51);
        }
        if (team == GOLDEN)
            return new Color(150, 220, 150);
        return new Color(71, 174, 51);
    }

    public static TeamView getOppositeTeam(TeamView team){
        if(team == GOLDEN)
            return CRIMSON;
        return GOLDEN;
    }
}