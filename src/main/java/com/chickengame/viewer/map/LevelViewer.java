package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.elements.ChickenViewer;
import com.chickengame.viewer.elements.ElementViewer;

public class LevelViewer extends Viewer<LevelMap> {
    private final MapViewer mapViewer;
    private final ElementViewer backgroundViewer;
    private final ElementViewer finishLineViewer;
    private final ChickenViewer chickenViewer;
    private final ElementViewerFactory elementViewerFactory;

    public LevelViewer(LevelMap location, ElementViewerFactory viewerFactory) {
        super(location);
        elementViewerFactory = viewerFactory;
        mapViewer = new MapViewer(getLocation().getMap(),elementViewerFactory);
        chickenViewer = elementViewerFactory.getChickenViewer(location.getChicken().getSkin());
        backgroundViewer = elementViewerFactory.getViewer("background");
        finishLineViewer = elementViewerFactory.getViewer("finishLine");
    }

    @Override
    protected void drawElements(GUI gui){
        backgroundViewer.draw(gui,getLocation().getBackground());
        mapViewer.drawElements(gui);
        chickenViewer.draw(gui,getLocation().getChicken());
        finishLineViewer.draw(gui,getLocation().getFinishLine());
    }



}
