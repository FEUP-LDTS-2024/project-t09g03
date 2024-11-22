package com.chickengame.viewer;

import com.chickengame.controler.ImageHandler;
import com.chickengame.model.Menu.Menu;
import com.chickengame.model.elements.Element;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class MenuViwer
{
    private final TextGraphics graphics;
    private final List<Element> elements;
    private final ImageHandler imageHandler;
    private ObjectPainter painter;
    public MenuViwer(TextGraphics graphics, Menu menu)
    {
        this.graphics = graphics;
        this.elements = menu.getElements();
        this.imageHandler = new ImageHandler();
        this.painter = new ObjectPainter();
    }

    public void drawMenu()
    {
        for(Element e : elements)
        {
            painter.draw(graphics,imageHandler, e);
        }
    }

}
