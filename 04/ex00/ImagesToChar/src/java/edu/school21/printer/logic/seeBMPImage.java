package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class seeBMPImage {
    private String path;
    BufferedImage image;

    public seeBMPImage(String path) throws IOException {
        this.path = path;
        this.image = ImageIO.read(new File(path));
    }

    public void seeBMPImage (String black, String white) {
        for (int yPixel = 0; yPixel < image.getHeight(); yPixel++)
        {
            for (int xPixel = 0; xPixel < image.getWidth(); xPixel++)
            {
                int color = image.getRGB(xPixel, yPixel);
                if (color == Color.BLACK.getRGB()) {
                    System.out.print(black);
                } else {
                    System.out.print(white);
                }
            }
            System.out.print("\n");
        }
    }
}
