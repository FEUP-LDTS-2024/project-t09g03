package com.chickengame.viewer;
import com.googlecode.lanterna.graphics.BasicTextImage;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class ImageLoaderTest
{
    @Test
    public void getImage() throws IOException
    {
        ImageLoader imageLoader = new ImageLoader();
        URL resource = getClass().getClassLoader().getResource("images/testImage.png");
        assertNotNull(resource);
        BufferedImage bufferedImage = ImageIO.read(new File(resource.getFile()));

        URL resource2 = getClass().getClassLoader().getResource("images/testImage2.png");
        assertNotNull(resource2);
        BufferedImage bufferedImage2 = ImageIO.read(new File(resource2.getFile()));

        BasicTextImage textImage = imageLoader.getImage("images/testImage.png");
        BasicTextImage textImage2 = imageLoader.getImage("images/testImage2.png");

        assertNotNull(textImage);
        assertNotNull(textImage2);

        assert(equals1(bufferedImage, textImage));
        assert(equals2(bufferedImage, textImage));
        assert(equals3(bufferedImage, textImage));
        assert(equals4(bufferedImage, textImage));

        assert(equals1(bufferedImage2, textImage2));
        assert(equals2(bufferedImage2, textImage2));
        assert(equals3(bufferedImage2, textImage2));
        assert(equals4(bufferedImage2, textImage2));
    }


    public boolean equals1(BufferedImage bufferedImage, BasicTextImage basicTextImage)
    {
        Color color = new Color(bufferedImage.getRGB(0, 0));
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        boolean rRed = (red == basicTextImage.getCharacterAt(0, 0).getBackgroundColor().getRed());
        boolean rGreen = (green == basicTextImage.getCharacterAt(0, 0).getBackgroundColor().getGreen());
        boolean resultBlue = (blue == basicTextImage.getCharacterAt(0, 0).getBackgroundColor().getBlue());
        return rRed & rGreen & resultBlue;
    }

    public boolean equals2(BufferedImage bufferedImage, BasicTextImage basicTextImage)
    {
        Color color = new Color(bufferedImage.getRGB(1, 0));
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        boolean rRed = (red == basicTextImage.getCharacterAt(1, 0).getBackgroundColor().getRed());
        boolean rGreen = (green == basicTextImage.getCharacterAt(1, 0).getBackgroundColor().getGreen());
        boolean resultBlue = (blue == basicTextImage.getCharacterAt(1, 0).getBackgroundColor().getBlue());
        return rRed & rGreen & resultBlue;
    }
    public boolean equals3(BufferedImage bufferedImage, BasicTextImage basicTextImage)
    {
        Color color = new Color(bufferedImage.getRGB(0, 1));
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        boolean rRed = (red == basicTextImage.getCharacterAt(0, 1).getBackgroundColor().getRed());
        boolean rGreen = (green == basicTextImage.getCharacterAt(0, 1).getBackgroundColor().getGreen());
        boolean resultBlue = (blue == basicTextImage.getCharacterAt(0, 1).getBackgroundColor().getBlue());
        return rRed & rGreen & resultBlue;
    }
    public boolean equals4(BufferedImage bufferedImage, BasicTextImage basicTextImage)
    {
        Color color = new Color(bufferedImage.getRGB(1, 1));
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        boolean rRed = (red == basicTextImage.getCharacterAt(1, 1).getBackgroundColor().getRed());
        boolean rGreen = (green == basicTextImage.getCharacterAt(1, 1).getBackgroundColor().getGreen());
        boolean resultBlue = (blue == basicTextImage.getCharacterAt(1, 1).getBackgroundColor().getBlue());
        return rRed & rGreen & resultBlue;
    }

    @Test
    public void invalidImage()
    {
       boolean result = false;
       try
       {
        ImageLoader imageLoader = new ImageLoader();
        imageLoader.getImage("invalidImage.png");
       }
       catch (RuntimeException e)
       {
           result = true;
       }
        assert result;
    }

    @Test
    public void wrongFile()
    {
        boolean result = false;
        try
        {
            ImageLoader imageLoader = new ImageLoader();
            imageLoader.getImage("images/wrongFile.zip");
        }
        catch (RuntimeException e)
        {
            result = true;
        }
        assert result;
    }



}
