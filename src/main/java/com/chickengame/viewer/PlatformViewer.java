package com.chickengame.viewer;

import com.chickengame.controler.ImageLoader;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Platform;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class PlatformViewer implements ElementViewer<Platform>
{
    private ImageLoader imageLoader = new ImageLoader();
    private BasicTextImage image = imageLoader.getImage("images/game/platform.png");

    public void draw(Platform platform, GUI gui)
    {
        gui.drawImage(platform.getPosition(),image);
    }
}
