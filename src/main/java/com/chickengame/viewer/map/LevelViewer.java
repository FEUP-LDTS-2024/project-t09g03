package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.map.elements.ChickenViewer;
import com.chickengame.viewer.map.elements.ElementViewer;

public class LevelViewer extends Viewer<LevelMap> {

    private final MapViewer mapViewer;
    private final ElementViewer backgroundViewer;
    private final ElementViewer finishLineViewer;
    private final ChickenViewer chickenViewer;
    private final ElementViewerFactory elementViewerFactory;

    public LevelViewer(LevelMap location) {
        super(location);
        elementViewerFactory = new ElementViewerFactory();
        mapViewer = new MapViewer(getLocation().getMap(),elementViewerFactory);
        chickenViewer = elementViewerFactory.getChickenViewer(location.getChicken().getSkin());
        backgroundViewer = elementViewerFactory.getViewer("background");
        finishLineViewer = elementViewerFactory.getViewer("finishLine");
    }

    @Override
    protected void drawElements(GUI gui){
        backgroundViewer.draw(gui,getLocation().getBackground());
        mapViewer.drawElements(gui);
        finishLineViewer.draw(gui,getLocation().getFinishLine());
        chickenViewer.draw(gui,getLocation().getChicken());
    }



}
