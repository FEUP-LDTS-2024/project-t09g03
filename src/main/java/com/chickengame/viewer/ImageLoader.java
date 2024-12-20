package com.chickengame.viewer;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class ImageLoader {

    public BasicTextImage getImage(String imagePath){
        URL resource = ImageLoader.class.getClassLoader().getResource(imagePath);
        File file = null;
        try {
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BasicTextImage textImage = new BasicTextImage(bufferedImage.getWidth(),bufferedImage.getHeight());
        BuffertoBasic(bufferedImage, textImage);
        return textImage;
    }

    public void BuffertoBasic(BufferedImage image,BasicTextImage textImage)
    {
        double t1 = System.nanoTime();
        for(int i = 0; i< image.getWidth();i++)
        {
            for(int c = 0; c<image.getHeight(); c++)
            {
                String paint = getColor(i,c,image);
                if(paint.equals("#000000"))
                {

                    TextColor txcolor = TextColor.Factory.fromString("#00FFFD");
                    textImage.setCharacterAt(i,c,new TextCharacter(' ', txcolor,txcolor));
                }
                else
                {
                    TextColor txcolor = TextColor.Factory.fromString(paint);
                    textImage.setCharacterAt(i,c,new TextCharacter(' ', txcolor,txcolor));
                }
            }
        }
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
}