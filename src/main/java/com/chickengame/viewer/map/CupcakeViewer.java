package com.chickengame.viewer.map;


import com.chickengame.viewer.ImageLoader;
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
        BasicTextImage image = this.cupcake;
        if(cupcake.getStateDown()) /// alterarr!!!!
        {
            image = cupcakeDown;
        }
        gui.drawImage(cupcake.getPosition(),image);
    }
}
