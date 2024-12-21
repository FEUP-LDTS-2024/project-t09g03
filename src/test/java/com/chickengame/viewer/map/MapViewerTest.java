package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.map.Map;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.elements.ElementViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class MapViewerTest {
    private MapViewer mapViewer;
    private ElementViewerFactory elementViewerFactory;
    private GUI gui;
    private Map map;
    private List<Element> elements;
    private Element element;
    private ElementViewer elementViewer;


    @BeforeEach
    public void helper()
    {
        this.elementViewerFactory = Mockito.mock(ElementViewerFactory.class);
        this.gui = Mockito.mock(GUI.class);
        this.map = Mockito.mock(Map.class);
        this.elements = new ArrayList<>();
        this.element = Mockito.mock(Element.class);
        this.elementViewer = Mockito.mock(ElementViewer.class);

        elements.add(element);
        Mockito.when(elementViewerFactory.getViewer(any())).thenReturn(elementViewer);
        Mockito.when(map.getElements()).thenReturn(elements);

        this.mapViewer = new MapViewer(map ,elementViewerFactory);
    }

    @Test
    public void drawElements()
    {
        mapViewer.drawElements(gui);

        Mockito.verify(elementViewerFactory, Mockito.times(elements.size())).getViewer(any());
        Mockito.verify(elementViewer, Mockito.times(elements.size())).draw(gui, element);
    }
}
