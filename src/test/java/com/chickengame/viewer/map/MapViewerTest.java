package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.map.Map;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.game.elements.ElementViewer;
import com.chickengame.viewer.game.map.MapViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class MapViewerTest
{
    private MapViewer mapViewer;
    private ElementViewerFactory elementViewerFactory;
    private GUI gui;
    private Map map;
    private List<Element> elements;
    private Element element1;
    private Element element2;
    private Element element3;
    private Element element4;
    private ElementViewer elementViewer1;
    private ElementViewer elementViewer2;
    private ElementViewer elementViewer3;
    private ElementViewer elementViewer4;
    private String name1;
    private String name2;
    private String name3;
    private String name4;


    @BeforeEach
    public void helper()
    {
        this.elementViewerFactory = Mockito.mock(ElementViewerFactory.class);
        this.gui = Mockito.mock(GUI.class);
        this.map = Mockito.mock(Map.class);
        this.elements = new ArrayList<>();

        this.element1 = Mockito.mock(Element.class);
        this.element2 = Mockito.mock(Element.class);
        this.element3 = Mockito.mock(Element.class);
        this.element4 = Mockito.mock(Element.class);

        this.elementViewer1 = Mockito.mock(ElementViewer.class);
        this.elementViewer2 = Mockito.mock(ElementViewer.class);
        this.elementViewer3 = Mockito.mock(ElementViewer.class);
        this.elementViewer4 = Mockito.mock(ElementViewer.class);

        this.name1 = "cupcake";
        this.name2 = "platform";
        this.name3 = "toblerone";
        this.name4 = "iceCream";

        elements.add(element1);
        elements.add(element2);
        elements.add(element3);
        elements.add(element4);

        Mockito.when(element1.getName()).thenReturn(name1);
        Mockito.when(element2.getName()).thenReturn(name2);
        Mockito.when(element3.getName()).thenReturn(name3);
        Mockito.when(element4.getName()).thenReturn(name4);

        Mockito.when(elementViewerFactory.getViewer(name1)).thenReturn(elementViewer1);
        Mockito.when(elementViewerFactory.getViewer(name2)).thenReturn(elementViewer2);
        Mockito.when(elementViewerFactory.getViewer(name3)).thenReturn(elementViewer3);
        Mockito.when(elementViewerFactory.getViewer(name4)).thenReturn(elementViewer4);

        Mockito.when(map.getElements()).thenReturn(elements);

        this.mapViewer = new MapViewer(map, elementViewerFactory);
    }

    @Test
    public void drawElements()
    {
        mapViewer.drawElements(gui);

        Mockito.verify(elementViewerFactory, Mockito.times(1)).getViewer("cupcake");
        Mockito.verify(elementViewer1, Mockito.times(1)).draw(gui, element1);

        Mockito.verify(elementViewerFactory, Mockito.times(1)).getViewer("platform");
        Mockito.verify(elementViewer2, Mockito.times(1)).draw(gui, element2);

        Mockito.verify(elementViewerFactory, Mockito.times(1)).getViewer("toblerone");
        Mockito.verify(elementViewer3, Mockito.times(1)).draw(gui, element3);

        Mockito.verify(elementViewerFactory, Mockito.times(1)).getViewer("iceCream");
        Mockito.verify(elementViewer4, Mockito.times(1)).draw(gui, element4);
    }
}
