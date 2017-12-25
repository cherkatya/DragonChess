package ru.nsu.fit.g14201.chernova.view.figures;


import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by RARETA on 23.12.2017.
 */
public class FigureImage {
    public BufferedImage image;
    private final String str;
    private final Color color;

    public FigureImage(String viewStr, Color color, Dimension imageSize) {
        this.str = viewStr;
        this.color = color;
        this.image = new BufferedImage(imageSize.width, imageSize.height,
                BufferedImage.TYPE_INT_ARGB);

        Graphics g = image.getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int textSize = (int)(imageSize.width * ((str.length() <= 1) ? (26 / 25.0f) : (18.0f / 25.0f)));
        g2.setFont(new Font("Serif", Font.PLAIN, textSize));
        g2.setColor(this.color);
        g2.fillOval(1, 1, image.getWidth() - 2, image.getHeight() - 2);
        g2.setColor(Color.BLACK);
        g2.drawOval(1, 1, image.getWidth() - 2, image.getHeight() - 2);
        g2.setColor(Color.BLACK);
        int shiftX = (int)(imageSize.width * ((str.length() <= 1) ? 0.2f : 0.15f));
        int shiftY = (int)(imageSize.height * ((str.length() <= 1) ? 0.1f : 0.2f));
        g2.drawString(str, shiftX, image.getHeight() - 1 - shiftY);

//        try {
//            image = ImageIO.read(new File(path));
//        } catch (IOException ex) {
//            // handle exception...
//            JOptionPane.showMessageDialog(this, "Error: can't read " + path);
//        }
    }
}
