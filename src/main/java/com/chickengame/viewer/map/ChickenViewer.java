package com.chickengame.viewer.map;

import com.chickengame.viewer.ImageLoader;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Chicken;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class ChickenViewer implements ElementViewer<Chicken>
{
    private ImageLoader imageLoader = new ImageLoader();
    private BasicTextImage imageMoving = imageLoader.getImage("images/game/chickenMoving.png");
    private BasicTextImage imageStatic = imageLoader.getImage("images/game/chickenStatic.png");
    @Override
    public void draw(Chicken chicken, GUI gui)
    {
        BasicTextImage image;
        boolean state = false;
        if(chicken.isStateMoving() && chicken.isMovingDown())
        {
            image = imageMoving;
        } else
            image = imageStatic;
            /*if (!chicken.isStateMoving() && chicken.isMovingDown()) {
        }
        else if (chicken.isStateMoving() && !chicken.isMovingDown())
        {
            //image = ;
            state = true;
        }
        else
        {
            //image = ;
            state = true;
        }*/
        gui.drawImage(chicken.getPosition(),image);
        chicken.setStateMoving(state);
    }
}
