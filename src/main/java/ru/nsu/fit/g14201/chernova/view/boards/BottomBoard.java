package ru.nsu.fit.g14201.chernova.view.boards;

import javax.swing.*;

/**
 * Created by castiel on 25.12.2017.
 */
public class BottomBoard extends BoardZoom {
    public BottomBoard(JFrame locateRelative) {
        super(locateRelative);
    }

    @Override
    public int getNumber() {
        return 0;
    }
}
