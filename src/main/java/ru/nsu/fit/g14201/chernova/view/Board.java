package ru.nsu.fit.g14201.chernova.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by RARETA on 23.12.2017.
 */
class Board extends JPanel {
    private final Color goldenSideColor = new Color(0xffd700);
    private final Color crimsonSideColor = new Color(220, 20, 60);

    private final Point position = new Point(0, 0);
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

    public void paint(Graphics g){
        g.setColor(goldenSideColor);
        g.fillRect(position.x, position.y, size.width, size.height);

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
    }
}
