package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.CandyCane;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class CandyCaneViewer implements ElementViewer<CandyCane>
{
    private ImageLoader imgLoader = new ImageLoader();
    private BasicTextImage imgCandyCane= imgLoader.getImage("images/game/candyCane.png");
    private BasicTextImage imgCandyCaneDown = imgLoader.getImage("images/game/candyCane.png");
    @Override
    public void draw(CandyCane candyCane, GUI gui)
    {
        if(candyCane.getStateDown())
        {
            gui.drawImage(candyCane.getPosition(),imgCandyCaneDown);
        }
        else
        {
            gui.drawImage(candyCane.getPosition(),imgCandyCane);
        }
    }
}
