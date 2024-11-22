package com.chickengame.controler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ImageHandler {


    public static BufferedImage getImage(String imagePath) throws URISyntaxException, IOException {
        URL resource = ImageHandler.class.getClassLoader().getResource(imagePath);
        File file = new File(resource.toURI());
        return ImageIO.read(file);
    }


    public String getColor(int x, int y, BufferedImage image)
    {
        int rgb = image.getRGB(x,y);
        if(((rgb>>24)&0xff) == 0)
        {
            return "#000000";
        }
        int red = (rgb>>16) & 0xff;
        int green = (rgb>>8) & 0xff;
        int blue = rgb & 0xff;
        return String.format("#%02x%02x%02x", red, green, blue);
    }
    public int getSizeX(BufferedImage image)
    {
        return image.getWidth();
    }
    public int getSizeY(BufferedImage image)
    {
        return image.getHeight();
    }

}
