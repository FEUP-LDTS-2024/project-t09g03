package com.chickengame.viewer;

import com.chickengame.controler.ImageLoader;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Chicken;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class ChickenViewer implements ElementViewer<Chicken>
{
    private ImageLoader imageLoader = new ImageLoader();
    private BasicTextImage imageMoving = imageLoader.getImage("images/game/chickenMoving.png");
    private BasicTextImage imageStatic = imageLoader.getImage("images/game/ChickenStatic.png");
    @Override
    public void draw(Chicken chicken, GUI gui)
    {
        if(chicken.isStateMoving())
        {
            gui.drawImage(chicken.getPosition(),imageMoving);
            chicken.setStateMoving(false);
        }
        else
        {
            gui.drawImage(chicken.getPosition(),imageStatic);
            chicken.setStateMoving(true);
        }
    }
}
