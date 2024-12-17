package com.chickengame.viewer.map.elements;

import com.chickengame.gui.GUI;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class InvertedElementViewer extends ElementViewer<InvertedElement>
{

    private BasicTextImage invertedImage;

    public InvertedElementViewer<InvertedElement>(ImageLoader imgLoader,Position position, String path, String invertedPath)
    {
        super(imgLoader,position,path);
        this.invertedImage = imgLoader.getImage(invertedPath);
    }


    void draw(GUI gui,boolean state)
    {
        if(state)
        {
            gui.drawImage(super.position,invertedImage);
        }
        else
        {
            this.draw(gui);
        }
    }
}
