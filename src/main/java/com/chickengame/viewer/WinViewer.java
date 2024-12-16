package com.chickengame.viewer;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.Win;
import com.chickengame.viewer.menu.ButtonViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class WinViewer extends Viewer<Win>{

    private final BasicTextImage background;
    private final ButtonViewer buttonViewer;

    public WinViewer(Win location) {
        super(location);
        background = getImageLoader().getImage("images/menu/win/Congratulations.png");
        buttonViewer = new ButtonViewer(getLocation().getBack());
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawImage(new Position(0,0), background);
        buttonViewer.drawElements(gui);
    }
}
