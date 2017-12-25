package ru.nsu.fit.g14201.chernova.view.boards;

import ru.nsu.fit.g14201.chernova.utils.FigureView;
import ru.nsu.fit.g14201.chernova.utils.figures.Sylph;
import ru.nsu.fit.g14201.chernova.view.FieldCoordinateView;
import ru.nsu.fit.g14201.chernova.view.TeamView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by castiel on 25.12.2017.
 */
public class UpperBoard extends Board {

    private Map<TeamView, ArrayList<FigureView>> figuresMap;
    private FigureView[][] field;

    {
        figuresMap = new HashMap<>();
        field = new FigureView[ROWS][COLUMNS];

        ArrayList<FigureView> figuresCrim = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            figuresCrim.add(new Sylph(new FieldCoordinateView(0, i * 2, 1), TeamView.GOLDEN,
                    cellSize));
        }
        figuresMap.put(TeamView.CRIMSON, figuresCrim);
    }

    public UpperBoard(Dimension cellSize) {
        super(cellSize);
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public Board clone(Dimension cellSize) { return new UpperBoard(cellSize); }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //BufferedImage image = new Sylph(new FieldCoordinateView(1, 1, 1), TeamView.CRIMSON).getImage().image;
        //g.drawImage(image, 40, 40, image.getWidth(), image.getHeight(), null);
        for (Map.Entry<TeamView, ArrayList<FigureView>> entry : figuresMap.entrySet()) {
            for (FigureView figure : entry.getValue()) {
                FieldCoordinateView coord = figure.getCoord();
                g.drawImage(figure.getImage(), coord.getX() * cellSize.width,
                        coord.getY() * cellSize.height, null);
            }
        }
    }
}
