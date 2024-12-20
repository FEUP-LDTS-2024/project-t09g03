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
        assert(resource != null);
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
        buffertoBasic(bufferedImage, textImage);
        return textImage;
    }

    public void buffertoBasic(BufferedImage image, BasicTextImage textImage)
    {

        for(int i = 0; i< image.getWidth();i++)
        {
            for(int c = 0; c<image.getHeight(); c++)
            {
                TextColor textColor = getColor(i,c,image);

                    textImage.setCharacterAt(i,c,new TextCharacter(' ', textColor,textColor));

            }
        }

    }

    public TextColor getColor(int x, int y, BufferedImage image)
    {
        int rgb = image.getRGB(x,y);
        if(((rgb>>24)&0xff) == 0)
        {
            return new TextColor.RGB(0,0,0);
        }
        int red = (rgb>>16) & 0xff;
        int green = (rgb>>8) & 0xff;
        int blue = rgb & 0xff;
        return new TextColor.RGB(red,green,blue);
    }
}