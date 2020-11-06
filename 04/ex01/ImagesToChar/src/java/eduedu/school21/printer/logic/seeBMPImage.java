package eduedu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class seeBMPImage {
    private String path = "/Users/cseabass/IdeaProjects/Module04/ex01/ImagesToChar/src/resources/it.bmp";
    BufferedImage image;

    public seeBMPImage() throws IOException {
        this.image = ImageIO.read(new File(path));
    }

    public void seeBMPImage () {
        for (int yPixel = 0; yPixel < image.getHeight(); yPixel++)
        {
            for (int xPixel = 0; xPixel < image.getWidth(); xPixel++)
            {
                int color = image.getRGB(xPixel, yPixel);
                if (color == Color.BLACK.getRGB()) {
                    System.out.print("O");
                } else {
                    System.out.print(".");
                }
            }
            System.out.print("\n");
        }
    }
}
