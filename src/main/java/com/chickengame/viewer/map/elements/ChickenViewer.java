package com.chickengame.viewer.map.elements;

import com.chickengame.viewer.ImageLoader;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Chicken;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class ChickenViewer extends InvertedElementViewer
{
    private BasicTextImage imgMoving;
    private BasicTextImage imgMovingDown;

    public ChickenViewer(ImageLoader imgLoader,String path, String invertedPath,String movingPath,String movingDownPath)
    {
        super(imgLoader,path,invertedPath);
        imgMoving = imgLoader.getImage(movingPath);
        imgMovingDown = imgLoader.getImage(movingDownPath);
    }

    public void draw(GUI gui,Chicken chicken)
    {
        if(!chicken.isWalking())
        {
            super.draw(gui,chicken);
        }
        else if(!chicken.isInverted())
        {
            gui.drawImage(chicken.getPosition(),imgMoving);
        }
        else
        {
            gui.drawImage(chicken.getPosition(),imgMovingDown);
        }
        chicken.setWalking(!chicken.isWalking());
    }
}
