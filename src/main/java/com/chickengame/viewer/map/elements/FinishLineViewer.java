package com.chickengame.viewer.map.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.elements.FinishLine;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

import java.awt.*;

public class FinishLineViewer implements ElementViewer<FinishLine> {

    private final ImageLoader  imageLoader = new ImageLoader();
    private BasicTextImage finishLine = imageLoader.getImage("images/game/finish_line.png");

    @Override
    public void draw(FinishLine element, GUI gui)
    {
        gui.drawImage(element.getPosition(),finishLine);
    }
}
