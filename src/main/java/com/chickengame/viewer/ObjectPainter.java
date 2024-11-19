package com.chickengame.viewer;

import com.chickengame.controler.ImageHandler;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ObjectPainter {
    ObjectPainter(){}

    public void draw(TextGraphics graphics, ImageHandler image)
    {
        for(int i = 0; i< image.getSizeX();i++)
        {
            for(int c = 0; c<image.getSizeY(); c++)
            {
                String paint = image.getColor(i,c);
                if(paint.equals("#000000"))
                {
                    continue;
                }else
                {
                    graphics.setForegroundColor(TextColor.Factory.fromString(image.getColor(i, c)));
                    graphics.setCharacter(i + superior.getX(), c + superior.getY(), '█');
                }
            }
        }
    }
}
