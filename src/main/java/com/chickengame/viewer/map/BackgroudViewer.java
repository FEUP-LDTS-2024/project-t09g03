package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Background;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class BackgroudViewer implements ElementViewer<Background> {
    private ImageLoader imageLoader = new ImageLoader();
    private BasicTextImage backgroudimg = imageLoader.getImage("images/game/background.png");
    @Override
    public void draw(Background background, GUI gui) {
        gui.drawImage(background.getPosition(),backgroudimg);

    }
}
