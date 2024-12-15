package com.chickengame.viewer.map.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Toblerone;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class TobleroneViewer implements ElementViewer<Toblerone>
{
    private ImageLoader imgLoader = new ImageLoader();
    private BasicTextImage imgToblerone = imgLoader.getImage("images/game/toblerone.png");
    private BasicTextImage imgTobleroneDown = imgLoader.getImage("images/game/tobleroneDown.png");

    @Override
    public void draw(Toblerone toblerone, GUI gui)
    {
        if(toblerone.getStateDown())
        {
            gui.drawImage(toblerone.getPosition(),imgTobleroneDown);
        }
        else
        {
            gui.drawImage(toblerone.getPosition(),imgToblerone);
        }
    }
}
