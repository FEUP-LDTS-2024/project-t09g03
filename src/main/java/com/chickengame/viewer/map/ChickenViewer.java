package com.chickengame.viewer.map;

import com.chickengame.viewer.ImageLoader;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Chicken;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class ChickenViewer implements ElementViewer<Chicken>
{
    private ImageLoader imgLoader = new ImageLoader();

    private BasicTextImage imgMoving = imgLoader.getImage("images/game/chickenMoving.png");
    private BasicTextImage imgStatic = imgLoader.getImage("images/game/chickenStatic.png");

    private BasicTextImage imgMovingDown = imgLoader.getImage("images/game/chickenMovingDown.png");
    private BasicTextImage imgStaticDown = imgLoader.getImage("images/game/chickenStaticDown.png");

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
