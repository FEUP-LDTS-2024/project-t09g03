package com.chickengame.viewer.menu;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.menu.HelpMenu;
import com.chickengame.viewer.Viewer;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class HelpViewer extends Viewer<HelpMenu> {

    private final BasicTextImage background = getImageLoader().getImage("images/menu/Help.png");
    private final ButtonViewer buttonViewer;
    public HelpViewer(HelpMenu location) {
        super(location);
        buttonViewer = new ButtonViewer(getLocation().getBack());

    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawImage(new Position(0,0),background);
        buttonViewer.drawElements(gui);
    }
}
