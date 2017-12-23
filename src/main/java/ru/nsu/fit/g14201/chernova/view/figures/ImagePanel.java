package ru.nsu.fit.g14201.chernova.view.figures;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by RARETA on 23.12.2017.
 */
public class ImagePanel extends JPanel {
    private BufferedImage image;
    private final String str;

    public ImagePanel(String viewStr) {
        this.str = viewStr;
//        try {
//            image = ImageIO.read(new File(path));
//        } catch (IOException ex) {
//            // handle exception...
//            JOptionPane.showMessageDialog(this, "Error: can't read " + path);
//        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Serif", Font.PLAIN, 96));
        g2.setColor(Color.BLUE);
        g2.drawString(str, 40, 140);
    }
}