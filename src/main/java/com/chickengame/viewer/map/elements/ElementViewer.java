package com.chickengame.viewer.map.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Element;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class ElementViewer<T extends Element>
{

    private BasicTextImage image;
    protected Position position;

    private BasicTextImage img;
    public ElementViewer<T>(ImageLoader imgLoader,Position position, String path)
    {
        this.image = imgLoader.getImage(path);
        this.position = position;
    }
    void draw(GUI gui)
    {
        gui.drawImage(position,image);
    }
}
