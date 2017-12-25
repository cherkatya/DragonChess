package ru.nsu.fit.g14201.chernova.view;

import ru.nsu.fit.g14201.chernova.presenter.Presenter;
import ru.nsu.fit.g14201.chernova.view.utils.ChessFrame;

/**
 * Created by Катя on 07.12.2017.
 */
public class Main {
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        ChessFrame frame = new ChessFrame(presenter);
        presenter.setView(frame);
        presenter.start();
        frame.setVisible(true);
    }
}
