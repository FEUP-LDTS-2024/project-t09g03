package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Background;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class BackgroundViewer implements ElementViewer<Background>
{
    private ImageLoader imgLoader = new ImageLoader();

    private BasicTextImage imgBackground = imgLoader.getImage("images/game/background.png");

    @Override
    public void draw(Background background, GUI gui)
    {
        gui.drawImage(background.getPosition(),imgBackground);
    }
}
