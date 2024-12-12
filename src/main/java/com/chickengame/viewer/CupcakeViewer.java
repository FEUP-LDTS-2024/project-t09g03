package com.chickengame.viewer;


import com.chickengame.controler.ImageLoader;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Cupcake;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class CupcakeViewer implements ElementViewer<Cupcake>
{
    private ImageLoader imageLoader = new ImageLoader();
    private BasicTextImage cupcake = imageLoader.getImage("images/game/cupcake.png");
    private BasicTextImage cupcakeDown = imageLoader.getImage("images/game/cupcakeDown.png");
    @Override
    public void draw(Cupcake cupcake, GUI gui)
    {
        BasicTextImage image = cupcake;
        if(cupcake.getboll) /// alterarr!!!!
        {
            image = cupcakeDown;
        }
        gui.drawImage(cupcake.getPosition(),image);
    }
}
