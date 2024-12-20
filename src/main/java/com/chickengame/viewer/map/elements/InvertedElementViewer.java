package com.chickengame.viewer.map.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.elements.InvertedElement;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class InvertedElementViewer extends ElementViewer
{
    private final BasicTextImage invertedImage;

    public InvertedElementViewer(ImageLoader imgLoader,String path, String invertedPath)
    {
        super(imgLoader,path);
        this.invertedImage = imgLoader.getImage(invertedPath);
    }

    public void draw(GUI gui, Element element)
    {
        InvertedElement invertedElement = (InvertedElement) element;
        if(invertedElement.isInverted())
        {
            gui.drawImage(invertedElement.getPosition(),invertedImage);
        }
        else
        {
            super.draw(gui,invertedElement);
        }
    }
}
