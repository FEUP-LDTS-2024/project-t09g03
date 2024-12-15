package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.map.elements.BackgroundViewer;
import com.chickengame.viewer.map.elements.ChickenViewer;

public class LevelViewer extends Viewer<LevelMap> {

    private final MapViewer mapViewer;
    private final BackgroundViewer backgroundViewer = new BackgroundViewer();
    private final ChickenViewer chickenViewer;

    public LevelViewer(LevelMap location) {
        super(location);
        mapViewer = new MapViewer(getLocation().getMap());
        chickenViewer = new ChickenViewer(getLocation().getChicken().getType());
    }

    @Override
    protected void drawElements(GUI gui){
        backgroundViewer.draw(getLocation().getBackground(),gui);
        mapViewer.drawElements(gui);
        chickenViewer.draw(getLocation().getChicken(),gui);
    }
}
