package ru.nsu.fit.g14201.chernova;

import javax.swing.*;
import java.awt.*;

/**
 * Created by SPN on 23.12.2017.
 */
public class Board extends JPanel {
    private final Color firstSideColor = new Color(0xffd700);
    private final Color secondSideColor = new Color(220, 20, 60);

    private final Point position = new Point(0, 0);
    private final int rows = 8;
    private final int columns = 12;
    private final int cellCommonSize = 25;
    private final Dimension cellSize = new Dimension(cellCommonSize, cellCommonSize);
    private final Dimension size = new Dimension(columns * cellSize.width, rows * cellSize.height);

    public void paint(Graphics g){
        g.setColor(firstSideColor);
        g.fillRect(position.x, position.y, size.width, size.height);

        g.setColor(secondSideColor);
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
