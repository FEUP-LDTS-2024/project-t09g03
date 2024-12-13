package com.chickengame.viewer.map;

import com.chickengame.viewer.ImageLoader;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Platform;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class PlatformViewer implements ElementViewer<Platform>
{
    private ImageLoader imgLoader = new ImageLoader();

    private BasicTextImage imgPlatform = imgLoader.getImage("images/game/platform.png");

    public void draw(Platform platform, GUI gui)
    {
        gui.drawImage(platform.getPosition(),imgPlatform);
    }
}