package com.chickengame.viewer;

import com.chickengame.controller.ImageHandler;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Element;

/**desenha os objetos na tela*/
public class ObjectPainter {
    public ObjectPainter(){}

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
