package com.chickengame.viewer.map.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.IceCream;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class IceCreamViewer implements ElementViewer<IceCream>
{
    private ImageLoader imgLoader = new ImageLoader();
    private BasicTextImage imgIcecream = imgLoader.getImage("images/game/iceCream.png");
    private BasicTextImage imgIcecreamDown = imgLoader.getImage("images/game/iceCreamDown.png");

    @Override
    public void draw(IceCream iceCream, GUI gui)
    {
        if(iceCream.getStateDown())
        {
            gui.drawImage(iceCream.getPosition(),imgIcecreamDown);
        }
        else
        {
            gui.drawImage(iceCream.getPosition(),imgIcecream);
        }
    }
}
