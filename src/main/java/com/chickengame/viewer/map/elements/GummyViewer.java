package com.chickengame.viewer.map.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Gummy;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class GummyViewer implements ElementViewer<Gummy>
{
    private ImageLoader imgLoader = new ImageLoader();
    private BasicTextImage imgGummy = imgLoader.getImage("images/game/gummy.png");
    private BasicTextImage imgGummyDown = imgLoader.getImage("images/game/gummyDown.png");

    @Override
    public void draw(Gummy gummy, GUI gui)
    {
        if(gummy.getStateDown())
        {
            gui.drawImage(gummy.getPosition(),imgGummyDown);
        }
        else
        {
            gui.drawImage(gummy.getPosition(),imgGummy);
        }
    }
}
