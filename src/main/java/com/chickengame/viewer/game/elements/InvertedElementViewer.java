package com.chickengame.viewer.game.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.InvertedElement;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class InvertedElementViewer extends ElementViewer<InvertedElement>
{
    private final BasicTextImage invertedImage;

    public InvertedElementViewer(ImageLoader imgLoader,String path, String invertedPath)
    {
        super(imgLoader,path);
        this.invertedImage = imgLoader.getImage(invertedPath);
    }

    @Override
    public void draw(GUI gui, InvertedElement invertedElement)
    {
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
