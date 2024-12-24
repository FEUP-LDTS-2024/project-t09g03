package com.chickengame.viewer.game.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Element;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.ObjectViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class ElementViewer<T extends Element> implements ObjectViewer<T>
{
    protected final BasicTextImage image;

    public ElementViewer(ImageLoader imgLoader, String path)
    {
        this.image = imgLoader.getImage(path);
    }

    public void draw(GUI gui, T element)
    {
        gui.drawImage(element.getPosition(),image);
    }
}
