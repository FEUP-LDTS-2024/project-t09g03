package com.chickengame.viewer.game;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.Menu;
import com.chickengame.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu location) {
        super(location);
    }

    //wip
    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
