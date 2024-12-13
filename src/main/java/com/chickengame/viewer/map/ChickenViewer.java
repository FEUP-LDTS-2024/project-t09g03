package com.chickengame.viewer.map;

import com.chickengame.viewer.ImageLoader;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Chicken;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class ChickenViewer implements ElementViewer<Chicken>
{
    private ImageLoader imageLoader = new ImageLoader();
    private BasicTextImage imgMoving = imageLoader.getImage("images/game/chickenMoving.png");
    private BasicTextImage imgStatic = imageLoader.getImage("images/game/chickenStatic.png");
    private BasicTextImage imgStaticDown = imageLoader.getImage("images/game/chickenStaticDown.png");
    private BasicTextImage imgMovingDown = imageLoader.getImage("images/game/chickenMovingDown.png");
    @Override
    public void draw(Chicken chicken, GUI gui)
    {
        BasicTextImage image = imgMoving;;
        boolean state = true;

        if(!chicken.isStateMoving() && !chicken.isStateDown())
        {
            image = imgStatic;
        }
        else if (!chicken.isStateMoving() && chicken.isMovingDown())
        {
            image = imgStaticDown;
        }
        else if (chicken.isStateMoving() && !chicken.isMovingDown())
        {
            image = imgMovingDown;
        }

        gui.drawImage(chicken.getPosition(),image);
        chicken.setStateMoving(state);
    }
}
