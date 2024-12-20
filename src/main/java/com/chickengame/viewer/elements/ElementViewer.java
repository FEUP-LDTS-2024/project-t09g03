package com.chickengame.viewer.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Element;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class ElementViewer
{
    protected final BasicTextImage image;

    public ElementViewer(ImageLoader imgLoader, String path)
    {
        this.image = imgLoader.getImage(path);
    }

    public void draw(GUI gui, Element element)
    {
        gui.drawImage(element.getPosition(),image);
    }
}
