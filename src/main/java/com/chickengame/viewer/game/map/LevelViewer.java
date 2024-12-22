package com.chickengame.viewer.game.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.game.elements.ChickenViewer;
import com.chickengame.viewer.game.elements.ElementViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class LevelViewer extends Viewer<LevelMap> {

    private final MapViewer mapViewer;
    private final BasicTextImage backgroundBasicTextImage;
    private final ElementViewer finishLineViewer;
    private final ChickenViewer chickenViewer;
    private final ElementViewerFactory elementViewerFactory;

    public LevelViewer(LevelMap location, ElementViewerFactory viewerFactory) {
        super(location);
        elementViewerFactory = viewerFactory;
        mapViewer = new MapViewer(getLocation().getMap(),elementViewerFactory);
        chickenViewer = elementViewerFactory.getChickenViewer(location.getChicken().getSkin());
        backgroundBasicTextImage = viewerFactory.getBackground("background");
        finishLineViewer = elementViewerFactory.getViewer("finishLine");
    }

    @Override
    protected void drawElements(GUI gui){
        gui.drawImage(new Position(0,0),backgroundBasicTextImage);
        mapViewer.drawElements(gui);
        chickenViewer.draw(gui,getLocation().getChicken());
        finishLineViewer.draw(gui,getLocation().getFinishLine());
    }



}
