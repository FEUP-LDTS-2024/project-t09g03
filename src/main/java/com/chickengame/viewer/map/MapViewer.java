package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.map.Map;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.map.elements.ElementViewer;

import java.util.List;

public class MapViewer extends Viewer<Map>
{
    private final ElementViewerFactory elementViewerFactory;
    public MapViewer(Map location, ElementViewerFactory elementViewerFactory) {
        super(location);
        this.elementViewerFactory = elementViewerFactory;
    }

    @Override
    public void drawElements(GUI gui)
    {
        List<Element> elements = getLocation().getElements();
        for(Element element : elements)
        {
            ElementViewer elementViewer = elementViewerFactory.getViewer(element.getName());
            elementViewer.draw(gui,element);
        }
    }

    public ElementViewerFactory getElementViewerFactory()
    {
        return elementViewerFactory;
    }
}
