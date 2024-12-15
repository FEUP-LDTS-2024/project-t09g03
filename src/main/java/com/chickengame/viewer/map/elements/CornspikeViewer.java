package com.chickengame.viewer.map.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Cornspike;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class CornspikeViewer implements ElementViewer<Cornspike>
{
    private ImageLoader imgLoader = new ImageLoader();
    private BasicTextImage imgcornspike = imgLoader.getImage("images/game/cornspike.png");
    private BasicTextImage imgcornspikeDown = imgLoader.getImage("images/game/cornspikeDown.png");


    @Override
    public void draw(Cornspike cornspike, GUI gui)
    {
        if(cornspike.getStateDown())
        {
            gui.drawImage(cornspike.getPosition(),imgcornspikeDown);
        }
        else
        {
            gui.drawImage(cornspike.getPosition(),imgcornspike);
        }
    }
}
