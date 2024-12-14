package com.chickengame.viewer.map;

import com.chickengame.viewer.ImageLoader;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Chicken;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class ChickenViewer implements ElementViewer<Chicken>
{
    private BasicTextImage imgMoving;
    private BasicTextImage imgStatic;

    private BasicTextImage imgMovingDown;
    private BasicTextImage imgStaticDown;

    public ChickenViewer(int type)
    {
        ImageLoader imgLoader = new ImageLoader();
        imgMoving = imgLoader.getImage("images/game/chicken/chickenMoving" + type + ".png");
        imgStatic = imgLoader.getImage("images/game/chicken/chickenStatic"+ type + ".png");
        imgMovingDown = imgLoader.getImage("images/game/chicken/chickenMovingDown" + type + ".png");
        imgStaticDown = imgLoader.getImage("images/game/chicken/chickenStaticDown" + type + ".png");
    }
    @Override
    public void draw(Chicken chicken, GUI gui)
    {
        boolean state = false;
        if(chicken.isStateMoving() && chicken.isMovingDown())
        {
            gui.drawImage(chicken.getPosition(),imgMoving);
        }
        else if(!chicken.isStateMoving() && chicken.isMovingDown())
        {
            gui.drawImage(chicken.getPosition(),imgStatic);
            state = true;
        }
        else if (!chicken.isStateMoving() && !chicken.isMovingDown())
        {
            gui.drawImage(chicken.getPosition(),imgStaticDown);
            state = true;
        }
        else {
            gui.drawImage(chicken.getPosition(), imgMovingDown);
        }
        chicken.setStateMoving(state);
    }
}
