package com.chickengame.viewer;

import com.chickengame.controler.ImageHandler;
import com.chickengame.gui.GUI;
import com.chickengame.model.menu.Menu;
import com.chickengame.model.elements.Element;

import java.util.List;

public class MenuViewer
{
    private final GUI gui;
    private final List<Element> elements;
    private final ImageHandler imageHandler;
    private ObjectPainter painter;
    public MenuViewer(GUI gui, Menu menu)
    {
        this.gui = gui;
        this.elements = menu.getElements();
        this.imageHandler = new ImageHandler();
        this.painter = new ObjectPainter();
    }

    public void drawMenu()
    {
        for(Element e : elements)
        {
            painter.draw(gui,imageHandler, e);
        }
    }

}
