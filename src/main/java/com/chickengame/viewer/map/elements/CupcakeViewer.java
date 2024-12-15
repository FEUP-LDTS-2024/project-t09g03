package com.chickengame.viewer.map.elements;


import com.chickengame.viewer.ImageLoader;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Cupcake;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class CupcakeViewer implements ElementViewer<Cupcake>
{
    private ImageLoader imgLoader = new ImageLoader();
    private BasicTextImage imgCupcake = imgLoader.getImage("images/game/cupcake.png");
    private BasicTextImage imgCupcakeDown = imgLoader.getImage("images/game/cupcakeDown.png");
    @Override
    public void draw(Cupcake cupcake, GUI gui)
    {
        if(cupcake.getStateDown())
        {
            gui.drawImage(cupcake.getPosition(),imgCupcakeDown);
        }
        else
        {
            gui.drawImage(cupcake.getPosition(),imgCupcake);
        }
    }
}
