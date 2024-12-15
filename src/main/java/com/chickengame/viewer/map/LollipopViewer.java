package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Lollipop;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class LollipopViewer implements ElementViewer<Lollipop>
{
    private ImageLoader imgLoader = new ImageLoader();
    private BasicTextImage imgLollipop = imgLoader.getImage("images/game/lollipop.png");
    private BasicTextImage imgLollipopDown = imgLoader.getImage("images/game/lollipopDown.png");

    @Override
    public void draw(Lollipop lollipop, GUI gui)
    {
        if(lollipop.getStateDown())
        {
            gui.drawImage(lollipop.getPosition(),imgLollipopDown);
        }
        else
        {
            gui.drawImage(lollipop.getPosition(),imgLollipop);
        }
    }
}
