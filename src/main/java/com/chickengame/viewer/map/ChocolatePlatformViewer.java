package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.ChocolatePlatform;
import com.chickengame.model.game.elements.Platform;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class ChocolatePlatformViewer implements ElementViewer<ChocolatePlatform>
{
    private ImageLoader imgLoader = new ImageLoader();

    private BasicTextImage imgChocolatePlatform = imgLoader.getImage("images/game/chocolatePlatform.png");

    public void draw(ChocolatePlatform platform, GUI gui)
    {
        gui.drawImage(platform.getPosition(),imgChocolatePlatform);
    }
}
