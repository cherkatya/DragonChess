package ru.nsu.fit.g14201.chernova.view.boards;

import ru.nsu.fit.g14201.chernova.utils.figures.Sylph;
import ru.nsu.fit.g14201.chernova.view.TeamView;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by RARETA on 23.12.2017.
 */
public class Board extends JPanel {
    private final Color goldenSideColor = TeamView.getCellColor(TeamView.CRIMSON, 0);
    private final Color crimsonSideColor = TeamView.getCellColor(TeamView.GOLDEN, 0);

    //private final Point position = new Point(0, 0);
    protected final int rows = 8;
    protected final int columns = 12;
    protected final int cellCommonSize;
    protected final Dimension cellSize;

    @Override
    public Dimension getSize() {
        return size;
    }

    protected final Dimension size;

    public Board(int cellSize) {
        this.cellCommonSize = cellSize;
        this.cellSize = new Dimension(cellCommonSize, cellCommonSize);
        this.size = new Dimension(columns * this.cellSize.width, rows * this.cellSize.height);
    }

    @Override
    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        g.setColor(goldenSideColor);
        g.fillRect(0, 0, size.width, size.height);

        g.setColor(crimsonSideColor);
        for(int i = 0; i < size.width; i += 2 * cellSize.width){
            for(int j = 0; j < size.height; j += 2 * cellSize.height){
                g.fillRect(i, j, cellSize.width, cellSize.height);
            }
        }

        for(int i = cellSize.width; i < size.width; i += 2 * cellSize.width){
            for(int j = cellSize.height; j < size.height; j += 2 * cellSize.height){
                g.fillRect(i, j, cellSize.width, cellSize.height);
            }
        }

        //new Sylph(new FieldCoordinateView(1, 1, 1), TeamView.CRIMSON).getImage().paint(g);


    }
}
