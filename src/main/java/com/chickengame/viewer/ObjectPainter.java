package com.chickengame.viewer;

import com.chickengame.controler.ImageHandler;
import com.chickengame.model.elements.Element;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ObjectPainter {
    ObjectPainter(){}

    public void draw(TextGraphics graphics, ImageHandler image, Element element)
    {
        for(int i = 0; i< image.getSizeX(element.getImage());i++)
        {
            for(int c = 0; c<image.getSizeY(element.getImage()); c++)
            {
                String paint = image.getColor(i,c,element.getImage());
                if(paint.equals("#000000"))
                {
                    continue;
                }else
                {
                    graphics.setForegroundColor(TextColor.Factory.fromString(paint));
                    graphics.setCharacter(i + element.getPosition().getX(), c + element.getPosition().getY(), '█');
                }
            }
        }
    }
}
