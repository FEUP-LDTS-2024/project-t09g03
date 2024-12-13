package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Cornspike;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class CornspikeViwer implements ElementViewer<Cornspike> {
    private ImageLoader imageLoader = new ImageLoader();
    private BasicTextImage imgup = imageLoader.getImage("images/game/cornspike.png");
    private BasicTextImage imgdown = imageLoader.getImage("images/game/cornspikeDown.png");

    @Override
    public void draw(Cornspike element, GUI gui)
    {
        if(element.getStateDown())
        {
            gui.drawImage(element.getPosition(),imgdown);
        }else
        {
            gui.drawImage(element.getPosition(),imgup);
        }
    }
}
