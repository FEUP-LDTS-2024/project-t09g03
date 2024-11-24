package com.chickengame.viewer;

import com.chickengame.controler.ImageHandler;
import com.chickengame.gui.GUI;
import com.chickengame.model.elements.Element;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
/**desenhha os objetos na tela*/
public class ObjectPainter {
    ObjectPainter(){}

    public void draw(GUI gui, ImageHandler image, Element element)
    {
        for(int i = 0; i< image.getSizeX(element.getImage());i++)
        {
            for(int c = 0; c<image.getSizeY(element.getImage()); c++)
            {
                String paint = image.getColor(i,c,element.getImage());
                if(paint.equals("#000000"))
                {
                    continue;
                }
                else
                {
                    int x = i + element.getPosition().getX();
                    int y = c + element.getPosition().getY();
                    gui.draw(x,y,paint);
                }
            }
        }
    }
}
