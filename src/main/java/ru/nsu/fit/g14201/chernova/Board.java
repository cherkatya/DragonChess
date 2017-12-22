package ru.nsu.fit.g14201.chernova;

import javax.swing.*;
import java.awt.*;

/**
 * Created by SPN on 23.12.2017.
 */
public class Board extends JPanel {
    private Color firstSideColor = new Color(0xffd700);
    private Color secondSideColor = new Color(220, 20, 60);

    public void paint(Graphics g){
        g.setColor(firstSideColor);
        g.fillRect(100, 100, 400, 400);

        g.setColor(secondSideColor);
        for(int i = 100; i <= 400; i+=100){
            for(int j = 100; j <= 400; j+=100){
                //g.clearRect(i, j, 50, 50);
                g.fillRect(i, j, 50, 50);
            }
        }

        for(int i = 150; i <= 450; i+=100){
            for(int j = 150; j <= 450; j+=100){
                //g.clearRect(i, j, 50, 50);
                g.fillRect(i, j, 50, 50);
            }
        }
    }
}
