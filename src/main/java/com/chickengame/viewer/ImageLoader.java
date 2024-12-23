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
        if(resource == null)throw new RuntimeException();
        File file = null;
        BufferedImage bufferedImage = null;
        try {
            file = new File(resource.toURI());
            bufferedImage = ImageIO.read(file);
            assert(bufferedImage != null);
        } catch (IOException | URISyntaxException | AssertionError e) {
            throw new RuntimeException(e);
        }
        BasicTextImage textImage = new BasicTextImage(bufferedImage.getWidth(),bufferedImage.getHeight());
        buffertoBasic(bufferedImage, textImage);
        return textImage;
    }

    private void buffertoBasic(BufferedImage image, BasicTextImage textImage)
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

    private TextColor getColor(int x, int y, BufferedImage image)
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